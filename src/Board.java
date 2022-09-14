public class Board {

    final static int X = 3;

    private Cell[][] board;
    private int cellFilled = 0;

    public Cell[][] getBoard() {
        return board;
    }

    public void increaseCell() {
        cellFilled++;
    }

    public Board() {
        this.board = new Cell[X][X];
        for (int i = 0;  i < X; i++) {
            for (int j = 0; j < X; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public boolean isValid(int row, int col) {
        if (row < 0 || row >= X) {
            return false;
        }
        if (col < 0 || col >= X) {
            return false;
        }
        return board[row][col].getStatus() == CellStatus.EMPTY;
    }

    public void update(int row, int col, boolean isXTurn) {
        if (isXTurn) {
            board[row][col].setStatus(CellStatus.X);
        } else {
            board[row][col].setStatus(CellStatus.O);
        }
    }

    public void printBoard() {
        for (int i = 0; i < X; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < X; j++) {
                if (board[i][j].getStatus() != CellStatus.EMPTY) {
                    line.append("[").append(board[i][j].getStatus().toString()).append("]");
                } else {
                    line.append("[ ]");
                }
            }
            System.out.println(line);
        }
    }

    public String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> board[0][0].getStatus().toString() + board[0][1].getStatus().toString()
                        + board[0][2].getStatus().toString();
                case 1 -> board[1][0].getStatus().toString() + board[1][1].getStatus().toString()
                        + board[1][2].getStatus().toString();
                case 2 -> board[2][0].getStatus().toString() + board[2][1].getStatus().toString()
                        + board[2][2].getStatus().toString();
                case 3 -> board[0][1].getStatus().toString() + board[1][1].getStatus().toString()
                        + board[2][1].getStatus().toString();
                case 4 -> board[0][2].getStatus().toString() + board[1][2].getStatus().toString()
                        + board[2][2].getStatus().toString();
                case 5 -> board[0][0].getStatus().toString() + board[1][0].getStatus().toString()
                        + board[2][0].getStatus().toString();
                case 6 -> board[0][0].getStatus().toString() + board[1][1].getStatus().toString()
                        + board[2][2].getStatus().toString();
                case 7 -> board[0][2].getStatus().toString() + board[1][1].getStatus().toString()
                        + board[2][0].getStatus().toString();
                default -> "";
            };

            // check winner
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            } else if (cellFilled == 9) {
                return "draw";
            }
        }
        return "no";
    }
}
