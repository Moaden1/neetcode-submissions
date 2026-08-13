class Solution {
    public boolean isValidSudoku(char[][] board) {
        // board[i][j] is a digit 1-9 or '.'
        
        // row checks
        
        // todo: map for 3x3
        for (int i = 0; i < board.length; i++) {
            HashMap<Integer, Integer> horzMap = newTable();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (horzMap.get(board[i][j] - '0') < 1) {
                        return false;
                    }
                    horzMap.put(board[i][j] - '0', horzMap.get(board[i][j] - '0') - 1);
                }
            }
        }
        // vertical checking/snaking
        for (int i = 0; i < board[0].length; i++) { //col
            HashMap<Integer, Integer> vertMap = newTable();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.') {
                    if (vertMap.get(board[j][i] - '0') < 1) {
                        return false;
                    }
                    vertMap.put(board[j][i] - '0', vertMap.get(board[j][i] - '0') - 1);
                }
            }
        }

        // 3x3 checks
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                HashMap<Integer, Integer> map = newTable();
                for (int k = i; k <= i+2; k++) {
                    for (int l = j; l <= j+2; l++) {
                        if (board[k][l] != '.') {
                            if (map.get(board[k][l] - '0') < 1) {
                                return false;
                            }
                            map.put(board[k][l] - '0', map.get(board[k][l] - '0') - 1);
                        }
                    }
                }
            }
        }
        return true;
    }

    public HashMap<Integer, Integer> newTable() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= 9; i++) {
            map.put(i, 1);
        }
        return map;
    }
} 