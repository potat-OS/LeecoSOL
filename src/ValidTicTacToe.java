class ValidTicTacToe {
    public boolean validTicTacToe(String[] board) {
        int m = 3, n = 3;
        int xCnt = 0, oCnt = 0;
        final String XXX = "XXX", OOO = "OOO";
        boolean xWin = false, oWin = false;

        StringBuilder[] sbs = new StringBuilder[5];
        // 初始化SB
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        for (int i = 0, a = 0, b = 2; i < m; i++, a++, b--) {
            char[] chars = board[i].toCharArray();
            sbs[3].append(chars[a]); // 左对角线
            sbs[4].append(chars[b]); // 右对角线
            for (int j = 0; j < n; j++) {
                sbs[j].append(chars[j]); // 列
                xCnt += chars[j] == 'X' ? 1 : 0;
                oCnt += chars[j] == 'O' ? 1 : 0;
            }
        }
        for (int i = 0; i < board.length; i++) {
            xWin = board[i].equals(XXX) ? true : xWin;
            oWin = board[i].equals(OOO) ? true : oWin;
        }
        for (int i = 0; i < sbs.length; i++) {
            String sb = sbs[i].toString();
            xWin = sb.equals(XXX) ? true : xWin;
            oWin = sb.equals(OOO) ? true : oWin;
        }
        if ((xCnt == oCnt) || xCnt == oCnt + 1) {
            if ((xWin ^ oWin)) {
                if ((xWin && xCnt - 1 == oCnt) || (oWin && oCnt == xCnt)) {
                    return true;
                }
            } else if (xWin == false) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidTicTacToe().validTicTacToe(new String[] { "XXX", "OOX", "OOX" }));
    }
}
