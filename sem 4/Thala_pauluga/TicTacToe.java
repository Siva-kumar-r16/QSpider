package Thala_pauluga;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        char[] board = {'1','2','3','4','5','6','7','8','9'};

        while (true) {

            // Display board
            System.out.println();
            System.out.println(board[0]+" | "+board[1]+" | "+board[2]);
            System.out.println("--+---+--");
            System.out.println(board[3]+" | "+board[4]+" | "+board[5]);
            System.out.println("--+---+--");
            System.out.println(board[6]+" | "+board[7]+" | "+board[8]);

            // Human move
            System.out.print("\nEnter your position (1-9): ");
            int move = sc.nextInt() - 1;

            if (move < 0 || move > 8 || board[move] == 'X' || board[move] == 'O') {
                System.out.println("Invalid Move!");
                continue;
            }

            board[move] = 'X';

            if (checkWinner(board, 'X')) {
                printBoard(board);
                System.out.println("\nYou Win!");
                break;
            }

            if (isDraw(board)) {
                printBoard(board);
                System.out.println("\nGame Draw!");
                break;
            }

            // Computer move
            int pcMove;
            do {
                pcMove = random.nextInt(9);
            } while (board[pcMove] == 'X' || board[pcMove] == 'O');

            board[pcMove] = 'O';
            System.out.println("\nComputer chose: " + (pcMove + 1));

            if (checkWinner(board, 'O')) {
                printBoard(board);
                System.out.println("\nComputer Wins!");
                break;
            }

            if (isDraw(board)) {
                printBoard(board);
                System.out.println("\nGame Draw!");
                break;
            }
        }

        sc.close();
    }

    static boolean checkWinner(char[] b, char p) {

        return (b[0]==p && b[1]==p && b[2]==p) ||
               (b[3]==p && b[4]==p && b[5]==p) ||
               (b[6]==p && b[7]==p && b[8]==p) ||
               (b[0]==p && b[3]==p && b[6]==p) ||
               (b[1]==p && b[4]==p && b[7]==p) ||
               (b[2]==p && b[5]==p && b[8]==p) ||
               (b[0]==p && b[4]==p && b[8]==p) ||
               (b[2]==p && b[4]==p && b[6]==p);
    }

    static boolean isDraw(char[] b) {
        for (char c : b) {
            if (c != 'X' && c != 'O')
                return false;
        }
        return true;
    }

    static void printBoard(char[] board) {
        System.out.println();
        System.out.println(board[0]+" | "+board[1]+" | "+board[2]);
        System.out.println("--+---+--");
        System.out.println(board[3]+" | "+board[4]+" | "+board[5]);
        System.out.println("--+---+--");
        System.out.println(board[6]+" | "+board[7]+" | "+board[8]);
    }
}