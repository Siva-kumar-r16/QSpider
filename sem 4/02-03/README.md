# QSpider Notes – 02-03

## Topics Practiced

- Basic Java program structure
- Console output
- `main()` method
- `Scanner`
- `Random`
- Conditional statements
- Loops
- Arrays
- Game logic
- Java Swing
- Event handling
- Keyboard controls
- Graphics
- Collision detection
- Game states
- Minimax
- Alpha-Beta pruning

---

## 1. Basic Java Program – `abc.java`

The `abc.java` program is a simple introduction to Java program execution.

```java
class abc{
   public static void main(String[] args){
      System.out.println("Siva is fire");
   }
}
```

### Important Points

- `class abc` creates a class.
- `main()` is the starting point of the program.
- `System.out.println()` prints text on the console.
- Java execution starts from the `main()` method.

---

## 2. Number Guessing Game – `GuessNumber.java`

This program generates a random number between 1 and 100 and asks the user to guess it.

### Main Concepts

- `Scanner` is used to take user input.
- `Random` generates the secret number.
- A loop continues until the number is guessed.
- The program keeps track of the number of attempts.
- Conditions are used to tell the user whether the guess is higher or lower.

### Important Logic

```java
int numberToGuess = random.nextInt(100) + 1;
```

`nextInt(100)` generates a value from `0` to `99`. Adding `1` changes the range to `1` to `100`.

The program uses a variable such as:

```java
int numberOfTries = 0;
```

to count attempts.

### What to Learn

The important idea is combining random number generation, user input, loops, and conditions into one working program.

---

## 3. Rock Paper Scissors – `RockPaperScissorsBestOf3.java`

This is a console-based Rock Paper Scissors game.

The game is **Best of 3**, so the first player to win two rounds wins the game.

### Choices

```java
String[] choices = {"Rock", "Paper", "Scissors"};
```

The user enters:

```text
1. Rock
2. Paper
3. Scissors
```

The computer selects a random choice.

### Game Logic

Rock beats Scissors.

Paper beats Rock.

Scissors beats Paper.

If both choices are the same, the round is a draw.

### Important Concepts

- `Scanner`
- `Random`
- String arrays
- `while` loop
- `if-else`
- Score tracking
- Input validation

The loop continues while neither player has reached 2 wins:

```java
while (playerScore < 2 && computerScore < 2)
```

---

## 4. Connect Four – `ConnectFour.java`

This is a graphical Connect Four game created using Java Swing.

### Main Technologies Used

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
```

### Board

The program uses:

```java
private static final int ROWS = 6;
private static final int COLS = 7;
```

So the game board has 6 rows and 7 columns.

### Main Concepts

- `JFrame`
- Swing components
- Mouse/event handling
- 2D graphics
- Board representation
- Player turns
- Win checking
- Random computer behavior
- Game state handling

The GUI represents the board visually and allows players to interact with the game.

### Important Learning

This program is a larger example of combining Java programming logic with a graphical interface.

---

## 5. Pong Game – `Main.java`

`Main.java` contains a graphical Pong-style game.

The program uses Java AWT/Swing graphics and keyboard controls.

### Main Classes

The file contains:

- `Main`
- `GamePanel`
- `Paddle`
- `Ball`

### Game Constants

```java
private static final int WIDTH = 1000;
private static final int HEIGHT = 600;
private static final int PADDLE_WIDTH = 15;
private static final int PADDLE_HEIGHT = 100;
private static final int BALL_SIZE = 20;
private static final int WINNING_SCORE = 5;
```

### Game Features

- Two paddles
- Moving ball
- Score tracking
- Paddle collision
- Wall collision
- Game menu
- Game-over screen
- Restart using Enter
- Increasing ball speed after paddle collision

### Important Logic

The ball changes its vertical direction when it reaches the top or bottom of the play area.

Paddle collision is checked using the ball and paddle bounds.

The game ends when one player reaches the winning score.

### Helper Classes

#### `Paddle`

Stores the paddle position and size and provides movement and drawing methods.

#### `Ball`

Stores the ball position, size, and velocity.

The `reset()` method places the ball back at the starting position and gives it a random starting direction.

---

## 6. Tic-Tac-Toe – `TicTacToe.java`

This is a graphical Human vs Computer Tic-Tac-Toe game.

The program uses Java Swing and an AI based on Minimax with Alpha-Beta pruning.

### Main GUI Components

- `JFrame`
- `JPanel`
- `JButton`
- `JLabel`
- `JOptionPane`

The board is represented using:

```java
private char[][] board;
```

The players are represented by:

```java
private static final char PLAYER_X = 'X';
private static final char PLAYER_O = 'O';
private static final char EMPTY = '-';
```

### Human Move

When the user clicks an empty button, the program places `X` on the board.

After the human move, the computer gets its turn.

### Computer Move

The computer checks possible moves and uses the `minimax()` method to select a move.

### Minimax

Minimax evaluates possible future game states.

The program uses:

```java
private static final int WIN_SCORE = 10;
private static final int LOSE_SCORE = -10;
```

The AI tries to maximize its score while assuming the human player tries to minimize it.

### Alpha-Beta Pruning

The `minimax()` method also receives:

```java
int alpha, int beta
```

These values allow branches that cannot improve the result to be skipped.

This reduces unnecessary searching.

### Win Checking

The program checks:

- Rows
- Columns
- Main diagonal
- Other diagonal

It also checks whether the board is full to identify a draw.

---

# Assignment / Homework

1. Write a simple Java program that prints your name, department, and hobby.
2. Create a number guessing game with a limited number of attempts.
3. Modify Rock Paper Scissors to support Best of 5.
4. Create a simple Tic-Tac-Toe console version without Swing.
5. Practice using a 2D array to represent a game board.
6. Try adding another rule or feature to one of the games practiced today.
7. Explain the difference between `Random` and `Scanner`.
8. Explain the purpose of the `main()` method.
9. Explain how Minimax selects a move in Tic-Tac-Toe.
10. Explain why Alpha-Beta pruning can reduce the number of states evaluated.

---

# Quick Revision

### Java Input

```java
Scanner sc = new Scanner(System.in);
```

### Random Number

```java
Random random = new Random();
```

### Main Method

```java
public static void main(String[] args)
```

### Array

```java
String[] choices = {"Rock", "Paper", "Scissors"};
```

### Swing

Swing is used to create graphical user interfaces in Java.

### Minimax

Minimax evaluates possible moves by considering future game states.

### Alpha-Beta Pruning

Alpha-Beta pruning skips branches that cannot affect the final decision.
