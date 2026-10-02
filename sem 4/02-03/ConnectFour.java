import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;

public class ConnectFour extends JFrame {

    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final int CELL_SIZE = 100;
    private static final int BOARD_PADDING = 20;

    private int[][] board;
    private boolean isPlayerTurn;
    private boolean gameOver;

    private boolean isAnimating;
    private int animCol;
    private int animRow;
    private double animY;
    private int animPlayer;
    private Timer animTimer;

    private JLabel titleLabel;
    private JLabel statusLabel;
    private BoardPanel boardPanel;
    private JButton btnPlayAgain;
    private JButton btnExit;

    private Random random = new Random();

    public ConnectFour() {
        setTitle("Connect Four");
        setSize(900, 820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(0xECECEC));

        initComponents();
        resetGame();
    }

    private void initComponents() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(new Color(0xECECEC));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        titleLabel = new JLabel("CONNECT FOUR");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 48));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(0x333333));

        statusLabel = new JLabel("Your Turn");
        statusLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusLabel.setForeground(new Color(0x666666));

        topPanel.add(titleLabel);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(statusLabel);

        add(topPanel, BorderLayout.NORTH);

        boardPanel = new BoardPanel();
        add(boardPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(0xECECEC));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 30, 0));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));

        btnPlayAgain = new JButton("Play Again");
        btnPlayAgain.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnPlayAgain.setFocusPainted(false);
        btnPlayAgain.addActionListener(e -> resetGame());

        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnExit.setFocusPainted(false);
        btnExit.addActionListener(e -> System.exit(0));

        bottomPanel.add(btnPlayAgain);
        bottomPanel.add(btnExit);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void resetGame() {
        board = new int[ROWS][COLS];
        isPlayerTurn = true;
        gameOver = false;
        isAnimating = false;
        statusLabel.setText("Your Turn");
        boardPanel.repaint();
    }

    private void updateStatus() {
        if (gameOver) {
            return;
        }
        if (isPlayerTurn) {
            statusLabel.setText("Your Turn");
        } else {
            statusLabel.setText("Computer Turn");
        }
    }

    private void handleColumnClick(int col) {
        if (gameOver || isAnimating || !isPlayerTurn) {
            return;
        }
        if (col < 0 || col >= COLS) {
            return;
        }

        int row = getLowestEmptyRow(board, col);
        if (row != -1) {
            startAnimation(row, col, 1);
        }
    }

    private int getLowestEmptyRow(int[][] b, int col) {
        for (int r = ROWS - 1; r >= 0; r--) {
            if (b[r][col] == 0) {
                return r;
            }
        }
        return -1;
    }

    private void startAnimation(int row, int col, int player) {
        isAnimating = true;
        animRow = row;
        animCol = col;
        animPlayer = player;
        
        int boardW = COLS * CELL_SIZE + 2 * BOARD_PADDING;
        int boardH = ROWS * CELL_SIZE + 2 * BOARD_PADDING;
        int startX = (boardPanel.getWidth() - boardW) / 2;
        int startY = (boardPanel.getHeight() - boardH) / 2;

        animY = startY - CELL_SIZE; 
        
        double targetY = startY + BOARD_PADDING + row * CELL_SIZE;
        double speed = 25.0;

        animTimer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animY += speed;
                if (animY >= targetY) {
                    animY = targetY;
                    animTimer.stop();
                    board[animRow][animCol] = animPlayer;
                    isAnimating = false;
                    boardPanel.repaint();
                    checkGameState();
                } else {
                    boardPanel.repaint();
                }
            }
        });
        animTimer.start();
    }

    private void checkGameState() {
        if (checkWin(board, animPlayer)) {
            gameOver = true;
            statusLabel.setText(animPlayer == 1 ? "You Win!" : "Computer Wins!");
        } else if (isBoardFull(board)) {
            gameOver = true;
            statusLabel.setText("Draw Game");
        } else {
            isPlayerTurn = !isPlayerTurn;
            updateStatus();
            if (!isPlayerTurn) {
                Timer pause = new Timer(300, e -> playComputerMove());
                pause.setRepeats(false);
                pause.start();
            }
        }
    }

    private void playComputerMove() {
        if (gameOver || isAnimating) return;

        int bestCol = -1;

        bestCol = findWinningMove(2);
        
        if (bestCol == -1) {
            bestCol = findWinningMove(1);
        }
        
        if (bestCol == -1) {
            if (getLowestEmptyRow(board, COLS / 2) != -1) {
                bestCol = COLS / 2;
            }
        }
        
        if (bestCol == -1) {
            ArrayList<Integer> validCols = new ArrayList<>();
            for (int c = 0; c < COLS; c++) {
                if (getLowestEmptyRow(board, c) != -1) {
                    validCols.add(c);
                }
            }
            if (!validCols.isEmpty()) {
                bestCol = validCols.get(random.nextInt(validCols.size()));
            }
        }

        if (bestCol != -1) {
            int row = getLowestEmptyRow(board, bestCol);
            startAnimation(row, bestCol, 2);
        }
    }

    private int findWinningMove(int player) {
        for (int c = 0; c < COLS; c++) {
            int r = getLowestEmptyRow(board, c);
            if (r != -1) {
                board[r][c] = player;
                boolean win = checkWin(board, player);
                board[r][c] = 0; 
                if (win) return c;
            }
        }
        return -1;
    }

    private boolean checkWin(int[][] b, int player) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS - 3; c++) {
                if (b[r][c] == player && b[r][c+1] == player && b[r][c+2] == player && b[r][c+3] == player) {
                    return true;
                }
            }
        }
        for (int r = 0; r < ROWS - 3; r++) {
            for (int c = 0; c < COLS; c++) {
                if (b[r][c] == player && b[r+1][c] == player && b[r+2][c] == player && b[r+3][c] == player) {
                    return true;
                }
            }
        }
        for (int r = 0; r < ROWS - 3; r++) {
            for (int c = 0; c < COLS - 3; c++) {
                if (b[r][c] == player && b[r+1][c+1] == player && b[r+2][c+2] == player && b[r+3][c+3] == player) {
                    return true;
                }
            }
        }
        for (int r = 3; r < ROWS; r++) {
            for (int c = 0; c < COLS - 3; c++) {
                if (b[r][c] == player && b[r-1][c+1] == player && b[r-2][c+2] == player && b[r-3][c+3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isBoardFull(int[][] b) {
        for (int c = 0; c < COLS; c++) {
            if (b[0][c] == 0) return false;
        }
        return true;
    }

    private class BoardPanel extends JPanel {
        public BoardPanel() {
            setOpaque(false);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int boardW = COLS * CELL_SIZE + 2 * BOARD_PADDING;
                    int boardH = ROWS * CELL_SIZE + 2 * BOARD_PADDING;
                    int startX = (getWidth() - boardW) / 2;
                    int startY = (getHeight() - boardH) / 2;

                    int x = e.getX() - startX - BOARD_PADDING;
                    int y = e.getY() - startY - BOARD_PADDING;

                    if (x >= 0 && x < COLS * CELL_SIZE && y >= 0 && y < ROWS * CELL_SIZE) {
                        int col = x / CELL_SIZE;
                        handleColumnClick(col);
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int boardW = COLS * CELL_SIZE + 2 * BOARD_PADDING;
            int boardH = ROWS * CELL_SIZE + 2 * BOARD_PADDING;
            int startX = (getWidth() - boardW) / 2;
            int startY = (getHeight() - boardH) / 2;

            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    int cx = startX + BOARD_PADDING + c * CELL_SIZE;
                    int cy = startY + BOARD_PADDING + r * CELL_SIZE;
                    g2.setColor(new Color(245, 245, 245));
                    g2.fillOval(cx + 5, cy + 5, CELL_SIZE - 10, CELL_SIZE - 10);
                }
            }

            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    if (board[r][c] != 0) {
                        int cx = startX + BOARD_PADDING + c * CELL_SIZE;
                        int cy = startY + BOARD_PADDING + r * CELL_SIZE;
                        drawDisc(g2, cx + 5, cy + 5, CELL_SIZE - 10, board[r][c]);
                    }
                }
            }

            if (isAnimating) {
                int cx = startX + BOARD_PADDING + animCol * CELL_SIZE;
                drawDisc(g2, cx + 5, (int) animY + 5, CELL_SIZE - 10, animPlayer);
            }

            Shape boardRect = new RoundRectangle2D.Double(startX, startY, boardW, boardH, 40, 40);
            Area boardArea = new Area(boardRect);

            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    int cx = startX + BOARD_PADDING + c * CELL_SIZE;
                    int cy = startY + BOARD_PADDING + r * CELL_SIZE;
                    Shape hole = new Ellipse2D.Double(cx + 5, cy + 5, CELL_SIZE - 10, CELL_SIZE - 10);
                    boardArea.subtract(new Area(hole));
                }
            }

            g2.setColor(new Color(0x2952CC));
            g2.fill(boardArea);

            g2.setStroke(new BasicStroke(6));
            g2.setColor(new Color(0x1a3b99));
            g2.draw(boardRect);
        }

        private void drawDisc(Graphics2D g2, int x, int y, int size, int player) {
            Color c1, c2;
            if (player == 1) {
                c1 = new Color(255, 100, 100);
                c2 = new Color(180, 0, 0);
            } else {
                c1 = new Color(255, 255, 150);
                c2 = new Color(200, 150, 0);
            }

            GradientPaint gp = new GradientPaint(x, y, c1, x + size, y + size, c2);
            g2.setPaint(gp);
            g2.fillOval(x, y, size, size);

            g2.setColor(new Color(255, 255, 255, 100));
            g2.fillOval(x + (int)(size * 0.15), y + (int)(size * 0.1), (int)(size * 0.5), (int)(size * 0.3));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConnectFour game = new ConnectFour();
            game.setVisible(true);
        });
    }
}