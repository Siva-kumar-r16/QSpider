import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {

    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final char EMPTY = '-';

    private JButton[][] buttons;
    private JLabel statusLabel;
    private JButton newGameButton;

    private char[][] board;
    private boolean xTurn;
    private boolean gameOver;

    private static final int WIN_SCORE = 10;
    private static final int LOSE_SCORE = -10;

    public TicTacToe() {
        setTitle("Tic-Tac-Toe: Human vs Perfect AI");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        board = new char[3][3];
        buttons = new JButton[3][3];
        xTurn = true;
        gameOver = false;

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(40, 44, 52));
        statusLabel = new JLabel("Your Turn (X)");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        statusLabel.setForeground(Color.WHITE);
        topPanel.add(statusLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3, 5, 5));
        boardPanel.setBackground(Color.BLACK);
        boardPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;

                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setBackground(Color.WHITE);
                
                final int row = i;
                final int col = j;
                
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        humanMove(row, col);
                    }
                });
                
                boardPanel.add(buttons[i][j]);
            }
        }
        add(boardPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(40, 44, 52));
        newGameButton = new JButton("New Game");
        newGameButton.setFont(new Font("Arial", Font.BOLD, 16));
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        bottomPanel.add(newGameButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    private void humanMove(int row, int col) {
        if (xTurn && !gameOver && board[row][col] == EMPTY) {
            
            board[row][col] = PLAYER_X;
            buttons[row][col].setText(String.valueOf(PLAYER_X));
            buttons[row][col].setForeground(new Color(50, 150, 255));
            
            if (checkGameState()) {
                return;
            }

            xTurn = false;
            statusLabel.setText("Computer Thinking...");
            
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    computerMove();
                }
            });
        }
    }

    private void computerMove() {
        if (gameOver) return;

        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    board[i][j] = PLAYER_O;
                    
                    int score = minimax(board, 0, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    
                    board[i][j] = EMPTY;

                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = i;
                        bestCol = j;
                    }
                }
            }
        }

        if (bestRow != -1 && bestCol != -1) {
            board[bestRow][bestCol] = PLAYER_O;
            buttons[bestRow][bestCol].setText(String.valueOf(PLAYER_O));
            buttons[bestRow][bestCol].setForeground(new Color(255, 100, 100));
            
            if (!checkGameState()) {
                xTurn = true;
                statusLabel.setText("Your Turn (X)");
            }
        }
    }

    private int minimax(char[][] board, int depth, boolean isMaximizing, int alpha, int beta) {
        char winner = checkWinner();
        if (winner == PLAYER_O) {
            return WIN_SCORE - depth;
        }
        if (winner == PLAYER_X) {
            return LOSE_SCORE + depth;
        }
        if (isBoardFull()) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = PLAYER_O;
                        int score = minimax(board, depth + 1, false, alpha, beta);
                        board[i][j] = EMPTY;
                        bestScore = Math.max(score, bestScore);
                        
                        alpha = Math.max(alpha, bestScore);
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            return bestScore;
        } 
        else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = PLAYER_X;
                        int score = minimax(board, depth + 1, true, alpha, beta);
                        board[i][j] = EMPTY;
                        bestScore = Math.min(score, bestScore);
                        
                        beta = Math.min(beta, bestScore);
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            return bestScore;
        }
    }

    private boolean checkGameState() {
        char winner = checkWinner();
        
        if (winner != EMPTY) {
            gameOver = true;
            String message = (winner == PLAYER_X) ? "You Win!" : "Computer Wins!";
            statusLabel.setText(message);
            disableBoard();
            JOptionPane.showMessageDialog(this, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        
        if (isBoardFull()) {
            gameOver = true;
            statusLabel.setText("It's a Draw!");
            JOptionPane.showMessageDialog(this, "It's a Draw!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        
        return false;
    }

    private char checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != EMPTY && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] != EMPTY && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return board[0][j];
            }
        }

        if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }

        if (board[0][2] != EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }

        return EMPTY;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private void disableBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setFocusable(false);
            }
        }
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
                buttons[i][j].setText("");
                buttons[i][j].setFocusable(true);
            }
        }
        xTurn = true;
        gameOver = false;
        statusLabel.setText("Your Turn (X)");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TicTacToe game = new TicTacToe();
                game.setVisible(true);
            }
        });
    }
}