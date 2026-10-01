import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored) {}

        JFrame frame = new JFrame("Pro Pong");
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class GamePanel extends JPanel {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private static final int PADDLE_WIDTH = 15;
    private static final int PADDLE_HEIGHT = 100;
    private static final int BALL_SIZE = 20;
    private static final int WINNING_SCORE = 5;

    private Paddle paddle1;
    private Paddle paddle2;
    private Ball ball;
    private int score1 = 0;
    private int score2 = 0;

    private enum GameState { MENU, PLAYING, GAMEOVER }
    private GameState state = GameState.MENU;
    private String winnerText = "";
    private Timer gameLoop;
    
    private Color bgColor = new Color(18, 18, 18);
    private Color fgColor = new Color(240, 240, 240);
    private Color accentColor = new Color(0, 204, 255);

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(bgColor);
        setFocusable(true);

        paddle1 = new Paddle(30, HEIGHT / 2 - PADDLE_HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle2 = new Paddle(WIDTH - 30 - PADDLE_WIDTH, HEIGHT / 2 - PADDLE_HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT);
        ball = new Ball(WIDTH / 2, HEIGHT / 2, BALL_SIZE);

        setupKeyBindings();

        gameLoop = new Timer(1000 / 60, e -> update());
        gameLoop.start();
    }

    private void setupKeyBindings() {
        bindKey("W", "p1Up", () -> paddle1.setDy(-paddle1.getSpeed()), () -> paddle1.setDy(0));
        bindKey("S", "p1Down", () -> paddle1.setDy(paddle1.getSpeed()), () -> paddle1.setDy(0));
        bindKey("UP", "p2Up", () -> paddle2.setDy(-paddle2.getSpeed()), () -> paddle2.setDy(0));
        bindKey("DOWN", "p2Down", () -> paddle2.setDy(paddle2.getSpeed()), () -> paddle2.setDy(0));
        bindKey("ENTER", "enter", () -> handleEnter(), null);
    }

    private void bindKey(String key, String name, Runnable onPressed, Runnable onReleased) {
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), name + "Pressed");
        getActionMap().put(name + "Pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { onPressed.run(); }
        });

        if (onReleased != null) {
            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released " + key), name + "Released");
            getActionMap().put(name + "Released", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) { onReleased.run(); }
            });
        }
    }

    private void handleEnter() {
        if (state == GameState.MENU || state == GameState.GAMEOVER) {
            score1 = 0;
            score2 = 0;
            ball.reset();
            paddle1.setY(HEIGHT / 2 - PADDLE_HEIGHT / 2);
            paddle2.setY(HEIGHT / 2 - PADDLE_HEIGHT / 2);
            state = GameState.PLAYING;
        }
    }

    private void update() {
        if (state != GameState.PLAYING) {
            repaint();
            return;
        }

        paddle1.move(HEIGHT);
        paddle2.move(HEIGHT);
        ball.move();

        if (ball.getY() - ball.getSize() / 2 <= 0 || ball.getY() + ball.getSize() / 2 >= HEIGHT) {
            ball.reverseY();
        }

        checkPaddleCollision(paddle1, true);
        checkPaddleCollision(paddle2, false);

        if (ball.getX() < 0) {
            score2++;
            checkWin();
            ball.reset();
        } else if (ball.getX() > WIDTH) {
            score1++;
            checkWin();
            ball.reset();
        }

        repaint();
    }

    private void checkPaddleCollision(Paddle p, boolean isLeft) {
        if (ball.getBounds().intersects(p.getBounds())) {
            double hitPoint = (ball.getY() - (p.getY() + p.getHeight() / 2)) / (p.getHeight() / 2);
            double angle = hitPoint * (Math.PI / 4);
            
            double currentSpeed = Math.sqrt(ball.getDx() * ball.getDx() + ball.getDy() * ball.getDy());
            double newSpeed = Math.min(currentSpeed * 1.05, 20.0);

            int direction = isLeft ? 1 : -1;
            ball.setDx(direction * newSpeed * Math.cos(angle));
            ball.setDy(newSpeed * Math.sin(angle));
            
            ball.setX(isLeft ? p.getX() + p.getWidth() + ball.getSize()/2 : p.getX() - ball.getSize()/2);
        }
    }

    private void checkWin() {
        if (score1 >= WINNING_SCORE) {
            state = GameState.GAMEOVER;
            winnerText = "PLAYER 1 WINS";
        } else if (score2 >= WINNING_SCORE) {
            state = GameState.GAMEOVER;
            winnerText = "PLAYER 2 WINS";
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (state == GameState.PLAYING || state == GameState.GAMEOVER) {
            drawPlayfield(g2d);
            paddle1.draw(g2d, fgColor);
            paddle2.draw(g2d, fgColor);
            ball.draw(g2d, accentColor);
        }

        if (state == GameState.MENU) {
            drawMenu(g2d);
        } else if (state == GameState.GAMEOVER) {
            drawGameOver(g2d);
        }
    }

    private void drawPlayfield(Graphics2D g2d) {
        g2d.setColor(new Color(255, 255, 255, 30));
        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, 0));
        g2d.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
        
        g2d.setColor(new Color(255, 255, 255, 50));
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 120));
        FontMetrics fm = g2d.getFontMetrics();
        g2d.drawString(String.valueOf(score1), WIDTH / 4 - fm.stringWidth(String.valueOf(score1)) / 2, 120);
        g2d.drawString(String.valueOf(score2), 3 * WIDTH / 4 - fm.stringWidth(String.valueOf(score2)) / 2, 120);
    }

    private void drawMenu(Graphics2D g2d) {
        g2d.setColor(accentColor);
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 80));
        drawCenteredString(g2d, "PRO PONG", HEIGHT / 3);
        
        g2d.setColor(fgColor);
        g2d.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        drawCenteredString(g2d, "Press ENTER to Start", HEIGHT / 2 + 50);
    }

    private void drawGameOver(Graphics2D g2d) {
        g2d.setColor(new Color(0, 0, 0, 150));
        g2d.fillRect(0, 0, WIDTH, HEIGHT);
        
        g2d.setColor(accentColor);
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 60));
        drawCenteredString(g2d, winnerText, HEIGHT / 2 - 30);
        
        g2d.setColor(fgColor);
        g2d.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        drawCenteredString(g2d, "Press ENTER to Play Again", HEIGHT / 2 + 30);
    }

    private void drawCenteredString(Graphics2D g2d, String text, int y) {
        FontMetrics fm = g2d.getFontMetrics();
        int x = (WIDTH - fm.stringWidth(text)) / 2;
        g2d.drawString(text, x, y);
    }
}

class Paddle {
    private double x, y, width, height;
    private double dy = 0;
    private double speed = 8.0;

    public Paddle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move(int screenHeight) {
        y += dy;
        if (y < 10) y = 10;
        if (y + height > screenHeight - 10) y = screenHeight - height - 10;
    }

    public void draw(Graphics2D g2d, Color color) {
        g2d.setColor(color);
        g2d.fill(new RoundRectangle2D.Double(x, y, width, height, 10, 10));
    }

    public java.awt.geom.Rectangle2D getBounds() {
        return new java.awt.geom.Rectangle2D.Double(x, y, width, height);
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public double getSpeed() { return speed; }
    public void setY(double y) { this.y = y; }
    public void setDy(double dy) { this.dy = dy; }
}

class Ball {
    private double x, y, size;
    private double dx, dy;
    private double initialSpeed = 7.0;
    private Random random = new Random();
    private double startX, startY;

    public Ball(double x, double y, double size) {
        this.startX = x;
        this.startY = y;
        this.size = size;
        reset();
    }

    public void reset() {
        this.x = startX;
        this.y = startY;
        
        double angle = (random.nextDouble() * Math.PI / 2) - Math.PI / 4; 
        if (random.nextBoolean()) {
            angle += Math.PI;
        }
        
        this.dx = initialSpeed * Math.cos(angle);
        this.dy = initialSpeed * Math.sin(angle);
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public void draw(Graphics2D g2d, Color color) {
        g2d.setColor(color);
        g2d.fill(new Ellipse2D.Double(x - size / 2, y - size / 2, size, size));
        
        g2d.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 50));
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        g2d.fill(new Ellipse2D.Double(x - size, y - size, size * 2, size * 2));
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
    }

    public java.awt.geom.Rectangle2D getBounds() {
        return new java.awt.geom.Rectangle2D.Double(x - size / 2, y - size / 2, size, size);
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getSize() { return size; }
    public double getDx() { return dx; }
    public double getDy() { return dy; }
    public void setX(double x) { this.x = x; }
    public void setDx(double dx) { this.dx = dx; }
    public void setDy(double dy) { this.dy = dy; }
    public void reverseY() { this.dy = -this.dy; }
}