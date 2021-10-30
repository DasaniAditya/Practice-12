// Rotting Oranges

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int fresh = 0;
        int time = 0;
        int[][] dirs = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                } else if(grid[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }
        if(fresh == 0) {
            return 0;
        }
        
        while(!queue.isEmpty()) {
            int sz = queue.size();
            for(int i = 0 ; i < sz / 2; i ++) {
                int r = queue.poll();
                int c = queue.poll();
                for(int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length 
                       && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.add(nr);
                        queue.add(nc);
                    }
                }
            }
            time++;
        }
        if(fresh == 0) {
            return time-1;
        } else {
            return -1;
        }
    }
}


// Tic-Tac-Toe Winner

class Solution {
    public String tictactoe(int[][] moves) {  
        int[] rows = new int[3];
        int[] cols = new int[3];
        int d1 = 0;
        int d2 = 0;
        
        for(int i = 0 ; i < moves.length; i++) {
            int[] current = moves[i];
            int currentRow = current[0];
            int currentCol = current[1];
            
            if(i % 2 == 0) {
                if(currentRow == currentCol) {
                    d1++;
                }
                if(currentRow + currentCol == 2) {
                    d2++;
                }
                rows[currentRow]++;
                cols[currentCol]++;
                if(rows[currentRow] == 3 || cols[currentCol] == 3 || d1 == 3 || d2 == 3) {
                    return "A";
                }
            } else {
                if(currentRow == currentCol) {
                    d1--;
                }
                if(currentRow + currentCol == 2) {
                    d2--;
                }
                rows[currentRow]--;
                cols[currentCol]--;
                if(rows[currentRow] == -3 || cols[currentCol] == -3 || d1 == -3 || d2 == -3) {
                    return "B";
                }
            }
        }
        if(moves.length == 9) {
            return "Draw";
        } else {
            return "Pending";
        }
    }
}
