import java.util.*;

/**
 * class run main game
 */
public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // game board
        Board board = new Board();

        // X first
        boolean isXTurn = true;

        while (true) {
            if (isXTurn) {
                System.out.println("X turn: ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                if (board.isValid(row, col)) {
                    board.update(row, col, isXTurn);
                    isXTurn = !isXTurn;
                    board.printBoard();
                    board.increaseCell();
                } else {
                    System.out.println("Invalid input! Please rewrite ");
                }
            } else {                                       // Y turn
                System.out.println("Y turn: ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                if (board.isValid(row, col)) {
                    board.update(row, col, isXTurn);
                    board.printBoard();
                    isXTurn = !isXTurn;
                    board.increaseCell();
                } else {
                    System.out.println("Invalid input! Please rewrite ");
                }
            }

            if (board.checkWinner().equals("no")) {
                continue;
            } else if (board.checkWinner().equals("X")) {
                System.out.println("Congratulation, X win!");
                break;
            } else if (board.checkWinner().equals("O")) {
                System.out.println("Congratulation, Y win!");
                break;
            } else if (board.checkWinner().equals("draw")) {
                System.out.println("You are draw!");
                break;
            }
        }
    }
}
