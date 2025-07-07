import java.util.*;

class ChessSquare {
    int row, col;
    String piece; // e.g. "wP", "bK"
    ChessSquare right, down;
    boolean hasMoved = false;

    ChessSquare(int r, int c, String p) {
        row = r; col = c; piece = p;
    }
    boolean isEmpty() { return piece == null; }
    String color() { return isEmpty() ? null : piece.substring(0,1); }
    String type() { return isEmpty() ? null : piece.substring(1); }
}

class Move {
    ChessSquare from, to;
    String captured, promotion;
    boolean isCastle, isEnPassant;
    Move(ChessSquare f, ChessSquare t) { from=f; to=t; }
}

public class scenario2 {
    static ChessSquare head;
    static String turn = "w";
    static List<String> history = new ArrayList<>();
    static ChessSquare enPassantTarget = null;

    public static void main(String[] args) {
        buildBoard();
        Scanner in = new Scanner(System.in);
        while (true) {
            printBoard();
            if (isCheckmate() || isStalemate()) break;
            System.out.print("Enter move (e.g. e2 e4) or 'exit': ");
            String line = in.nextLine().trim().toLowerCase();
            if (line.equals("exit")) break;
            String[] m = line.split("\\s+");
            if (m.length !=2) { System.out.println("Bad format"); continue; }
            if (playMove(m[0], m[1])) addToHistory(m[0],m[1]);
        }
        in.close();
        printBoard();
        System.out.println("Game over\nPGN:");
        System.out.println(String.join(" ", history));
    }

    static void buildBoard() {
        ChessSquare[] rows = new ChessSquare[8];
        for (int i=0; i<8; i++) {
            rows[i] = new ChessSquare(i,0,null);
            ChessSquare cur = rows[i];
            for (int j=1; j<8; j++) {
                cur.right = new ChessSquare(i, j, null);
                cur = cur.right;
            }
            if (i>0) {
                ChessSquare u = rows[i-1], d = rows[i];
                while (u!=null && d!=null) {
                    u.down=d; u=u.right; d=d.right;
                }
            }
        }
        head = rows[0];
        for (int j=0;j<8;j++) setPiece(0,j,"b"+ "RNBQKBNR".charAt(j));
        for (int j=0;j<8;j++) setPiece(1,j,"bP");
        for (int j=0;j<8;j++) setPiece(6,j,"wP");
        for (int j=0;j<8;j++) setPiece(7,j,"w"+ "RNBQKBNR".charAt(j));
    }

    static ChessSquare getSq(int r, int c) {
        ChessSquare cur = head;
        for (int i=0;i<r;i++) cur=cur.down;
        for (int j=0;j<c;j++) cur=cur.right;
        return cur;
    }

    static void setPiece(int r, int c, String p) {
        getSq(r,c).piece = p;
    }

    static void printBoard() {
        System.out.println("  a b c d e f g h");
        ChessSquare row=head; int r=8;
        while (row!=null) {
            System.out.print(r--+" ");
            ChessSquare c=row;
            while (c!=null) {
                System.out.print((c.isEmpty()?" .":c.piece)+" ");
                c=c.right;
            }
            System.out.println();
            row=row.down;
        }
        System.out.println((turn.equals("w")?"White":"Black")+" to move");
    }

    static boolean playMove(String a, String b) {
        int[] f = parse(a), t = parse(b);
        if (f==null||t==null) { System.out.println("Bad coords"); return false; }
        ChessSquare F = getSq(f[0],f[1]), T = getSq(t[0],t[1]);
        if (F.isEmpty()||!turn.equals(F.color())) { System.out.println("No your piece"); return false; }
        Move mv = new Move(F,T);
        if (!legal(F,T,mv)) { System.out.println("Illegal"); return false; }
        doMove(mv);
        turn = turn.equals("w")?"b":"w";
        enPassantTarget = mv.isEnPassant ? T : (F.type().equals("P") && Math.abs(t[0]-f[0])==2 ? T : null);
        return true;
    }

    static int[] parse(String s) {
        if (s.length()!=2) return null;
        int c = s.charAt(0)-'a', r = 8-(s.charAt(1)-'0');
        if (r<0||r>7||c<0||c>7) return null;
        return new int[]{r,c};
    }

    static boolean legal(ChessSquare F, ChessSquare T, Move mv) {
        String p = F.type(), col=F.color();
        int dr=T.row-F.row, dc=T.col-F.col;
        if (!T.isEmpty() && col.equals(T.color())) return false;

        // Pawn
        if (p.equals("P")) {
            int dir = col.equals("w")?-1:1;
            if (dc==0 && T.isEmpty()) {
                if (dr==dir || (dr==2*dir && !F.hasMoved && getSq(F.row+dir,F.col).isEmpty())) {}
                else return false;
            } else if (Math.abs(dc)==1 && dr==dir && (!T.isEmpty() || T==enPassantTarget)) {
                mv.isEnPassant = T.isEmpty();
                if (mv.isEnPassant) mv.captured = getSq(F.row, T.col).piece;
            } else return false;
        }
        // R,N,B,Q,K
        else if (p.equals("R") && (dr!=0&&dc!=0)) return false;
        else if (p.equals("B") && Math.abs(dr)!=Math.abs(dc)) return false;
        else if (p.equals("N") && !((Math.abs(dr)==1&&Math.abs(dc)==2)||(Math.abs(dr)==2&&Math.abs(dc)==1))) return false;
        else if (p.equals("Q") && !(dr==0||dc==0||Math.abs(dr)==Math.abs(dc))) return false;
        else if (p.equals("K")) {
            if (Math.abs(dc)==2 && dr==0 && canCastle(F,T,mv)) mv.isCastle=true;
            else if (!(Math.abs(dr)<=1&&Math.abs(dc)<=1)) return false;
        }

        // path clear?
        if ("RBQ".contains(p)) {
            int rstep = Integer.signum(dr), cstep = Integer.signum(dc);
            for(int r=F.row+rstep,c=F.col+cstep;r!=T.row||c!=T.col;r+=rstep,c+=cstep)
                if (!getSq(r,c).isEmpty()) return false;
        }

        mv.captured = mv.isEnPassant?mv.captured:(T.isEmpty()?null:T.piece);
        mv.promotion = (p.equals("P")&&(T.row==0||T.row==7)) ? "Q" : null;

        // Check simulation
        String oc = turn;
        doMove(mv);
        boolean inCheck = inCheck(oc);
        undoMove(mv);
        return !inCheck;
    }

    static boolean canCastle(ChessSquare F, ChessSquare T, Move mv) {
        if (F.hasMoved || inCheck(turn)) return false;
        int dir = T.col-F.col>0?1:-1;
        ChessSquare rookSq = getSq(F.row, dir>0?7:0);
        if (rookSq.isEmpty()||!rookSq.type().equals("R")||rookSq.hasMoved) return false;
        for (int c=F.col+dir;c!=rookSq.col;c+=dir) if (!getSq(F.row,c).isEmpty()) return false;
        // simulate king stepping
        for (int c=F.col; c!=T.col+dir; c+=dir) {
            doMove(new Move(F, getSq(F.row,c)));
            if (inCheck(turn)) { undoMove(new Move(getSq(F.row,c),F)); return false; }
            undoMove(new Move(getSq(F.row,c),F));
        }
        mv.to = T; return true;
    }

    static void doMove(Move m) {
        if (m.isEnPassant) getSq(m.from.row, m.to.col).piece = null;
        if (m.isCastle) {
            int dir = m.to.col-m.from.col>0?1:-1;
            ChessSquare rookFrom = getSq(m.from.row, dir>0?7:0);
            ChessSquare rookTo = getSq(m.from.row, m.from.col+dir);
            rookTo.piece = rookFrom.piece; rookTo.hasMoved=true;
            rookFrom.piece = null;
        }
        m.to.piece = m.from.piece + (m.promotion!=null ? m.promotion:"");
        m.from.piece = null;
        m.to.hasMoved = true;
    }

    static void undoMove(Move m){
        m.from.piece = m.to.piece.substring(0,2);
        getSq(m.to.row, m.to.col).piece = m.captured;
        m.from.hasMoved = true;
        if (m.isEnPassant)
            getSq(m.from.row, m.to.col).piece = m.captured;
        if (m.isCastle) {
            int dir = m.to.col-m.from.col>0?1:-1;
            ChessSquare king = getSq(m.from.row,m.from.col+dir);
            ChessSquare rdest = getSq(m.from.row, dir>0?7:0);
            rdest.piece = king.piece;
            getSq(m.from.row, m.from.col+dir).piece = null;
        }
    }

    static boolean inCheck(String col) {
        ChessSquare king=null;
        for (int r=0;r<8;r++) for (int c=0;c<8;c++){
            ChessSquare s= getSq(r,c);
            if (!s.isEmpty() && s.type().equals("K") && s.color().equals(col)) king=s;
        }
        for (int r=0;r<8;r++) for (int c=0;c<8;c++){
            ChessSquare s = getSq(r,c);
            if (!s.isEmpty() && !s.color().equals(col)) {
                Move m = new Move(s,king);
                if (legal(s,king,m)) return true;
            }
        }
        return false;
    }

    static boolean existMove(String col) {
        for (int r1=0;r1<8;r1++) for (int c1=0;c1<8;c1++){
            ChessSquare F = getSq(r1,c1);
            if (!F.isEmpty() && F.color().equals(col)){
                for (int r2=0;r2<8;r2++) for (int c2=0;c2<8;c2++){
                    ChessSquare T = getSq(r2,c2);
                    Move m = new Move(F,T);
                    if (legal(F,T,m)) return true;
                }
            }
        }
        return false;
    }

    static boolean isCheckmate() {
        if (inCheck(turn) && !existMove(turn)) {
            System.out.println((turn.equals("w")?"White":"Black") + " is checkmated!");
            return true;
        }
        return false;
    }

    static boolean isStalemate() {
        if (!inCheck(turn) && !existMove(turn)) {
            System.out.println("Stalemate!");
            return true;
        }
        return false;
    }

    static void addToHistory(String a, String b) {
        history.add((history.size()/2+1) + (history.size()%2==0?". ":"... ") + a + "-" + b);
    }
}
