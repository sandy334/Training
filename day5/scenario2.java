//chess game
import java.util.Scanner;

class ChessSquare {
    int row, col;
    String piece;
    ChessSquare right, down;

    public ChessSquare(int intRow, int intCol, String piece) {
        this.row = intRow;
        this.col = intCol;
        this.piece = piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public String color() {
        return isEmpty() ? null : piece.substring(0, 1); // "w" or "b"
    }

    public String type() {
        return isEmpty() ? null : piece.substring(1); // "P", "K", etc.
    }
}

class ChessBoard {
    ChessSquare head;
    String currentTurn = "w";

    public ChessBoard() {
        createBoard();
    }

    private void createBoard() {
        ChessSquare[] rowHeads = new ChessSquare[8];
        for (int i = 0; i < 8; i++) {
            rowHeads[i] = new ChessSquare(i, 0, null);
            ChessSquare current = rowHeads[i];
            for (int j = 1; j < 8; j++) {
                current.right = new ChessSquare(i, j, null);
                current = current.right;
            }

            if (i > 0) {
                ChessSquare upper = rowHeads[i - 1];
                ChessSquare lower = rowHeads[i];
                while (upper != null && lower != null) {
                    upper.down = lower;
                    upper = upper.right;
                    lower = lower.right;
                }
            }
        }
        head = rowHeads[0];
        initializePieces();
    }

    private void initializePieces() {
        String[] backRow = {"R", "N", "B", "Q", "K", "B", "N", "R"};
        for (int i = 0; i < 8; i++) {
            setPiece(0, i, "b" + backRow[i]);
            setPiece(1, i, "bP");
            setPiece(6, i, "wP");
            setPiece(7, i, "w" + backRow[i]);
        }
    }

    public void setPiece(int row, int col, String piece) {
        ChessSquare square = getSquare(row, col);
        if (square != null) square.piece = piece;
    }

    public ChessSquare getSquare(int row, int col) {
        ChessSquare current = head;
        for (int i = 0; i < row; i++) current = current.down;
        for (int j = 0; j < col; j++) current = current.right;
        return current;
    }

    public boolean move(String from, String to) {
        int[] fromRC = parsePosition(from);
        int[] toRC = parsePosition(to);

        if (fromRC == null || toRC == null) return false;

        ChessSquare fromSq = getSquare(fromRC[0], fromRC[1]);
        ChessSquare toSq = getSquare(toRC[0], toRC[1]);

        if (fromSq.isEmpty()) {
            System.out.println("No piece at source.");
            return false;
        }

        if (!fromSq.color().equals(currentTurn)) {
            System.out.println("It's not your turn.");
            return false;
        }

        if (!isLegalMove(fromSq, toSq)) {
            System.out.println("Illegal move.");
            return false;
        }

        // Execute move
        toSq.piece = fromSq.piece;
        fromSq.piece = null;
        System.out.println("Moved " + toSq.piece + " from " + from + " to " + to);

        // Switch turn
        currentTurn = currentTurn.equals("w") ? "b" : "w";
        return true;
    }

    private int[] parsePosition(String pos) {
        if (pos.length() != 2) return null;
        char file = pos.charAt(0);
        char rank = pos.charAt(1);
        int col = file - 'a';
        int row = 8 - (rank - '0');
        if (row < 0 || row > 7 || col < 0 || col > 7) return null;
        return new int[]{row, col};
    }

    public void printBoard() {
        ChessSquare row = head;
        System.out.println("  a  b  c  d  e  f  g  h");
        int rank = 8;
        while (row != null) {
            ChessSquare col = row;
            System.out.print(rank-- + " ");
            while (col != null) {
                System.out.print((col.piece == null ? "--" : col.piece) + " ");
                col = col.right;
            }
            System.out.println();
            row = row.down;
        }
        System.out.println("Current turn: " + (currentTurn.equals("w") ? "White" : "Black"));
    }

    private boolean isPathClear(ChessSquare from, ChessSquare to) {
        int rowDiff = Integer.compare(to.row, from.row);
        int colDiff = Integer.compare(to.col, from.col);

        int r = from.row + rowDiff;
        int c = from.col + colDiff;

        while (r != to.row || c != to.col) {
            if (!getSquare(r, c).isEmpty()) return false;
            r += rowDiff;
            c += colDiff;
        }
        return true;
    }

    private boolean isLegalMove(ChessSquare from, ChessSquare to) {
        if (to.color() != null && from.color().equals(to.color())) return false;

        int dr = to.row - from.row;
        int dc = to.col - from.col;
        String type = from.type();

        switch (type) {
            case "P":
                int direction = from.color().equals("w") ? -1 : 1;
                if (dc == 0 && to.isEmpty()) {
                    if (dr == direction) return true;
                    if ((from.row == 6 && direction == -1 || from.row == 1 && direction == 1) && dr == 2 * direction)
                        return getSquare(from.row + direction, from.col).isEmpty();
                } else if (Math.abs(dc) == 1 && dr == direction && to.color() != null && !to.color().equals(from.color())) {
                    return true; // diagonal capture
                }
                break;
            case "R":
                if (dr == 0 || dc == 0) return isPathClear(from, to);
                break;
            case "N":
                return (Math.abs(dr) == 2 && Math.abs(dc) == 1) || (Math.abs(dr) == 1 && Math.abs(dc) == 2);
            case "B":
                if (Math.abs(dr) == Math.abs(dc)) return isPathClear(from, to);
                break;
            case "Q":
                if (dr == 0 || dc == 0 || Math.abs(dr) == Math.abs(dc)) return isPathClear(from, to);
                break;
            case "K":
                return Math.abs(dr) <= 1 && Math.abs(dc) <= 1;
        }
        return false;
    }
}

public class scenario2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessBoard board = new ChessBoard();
        board.printBoard();

        while (true) {
            System.out.print("Enter move (e.g., e2 e4) or 'exit': ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("exit")) break;

            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid format. Use e.g., e2 e4");
                continue;
            }

            board.move(parts[0], parts[1]);
            board.printBoard();
        }
        System.out.println("Game over.");
    }
}
