class Solution {

    int[] delta_x={0, 0, 1, -1}; 
    int[] delta_y={1, -1, 0, 0};
    boolean[][][] visit; 

    static class Identification{
        int x;  
        int y;
        int keyCount;  
        int keyState;  
        
        public Identification(int x, int y, int keyCount, int keyState){
            this.x = x;
            this.y = y;
            this.keyCount = keyCount;
            this.keyState = keyState;
        }
    }

    public int shortestPathAllKeys(String[] grid) {

        
        int x_direction = 0;
        int y_direction = 0;

        int n = grid.length;
        int m = grid[0].length();

        int keySum = 0;
        Identification standard = null;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char ch = grid[i].charAt(j);

                if(ch == '@'){ 
                    x_direction = i;
                    y_direction = j;
                    standard =new Identification(i, j, 0, 0);
                }

                if(ch>='a'&& ch<='f')
                    keySum |= 1 << ch-'a';

            }
        }

        visit = new boolean[n][m][keySum+1];
        visit[x_direction][y_direction][0] = true; 

        Queue<Identification> queue = new LinkedList<Identification>();
        queue.add(standard);

        while (!queue.isEmpty()){

            Identification currentPos = queue.poll();

            if(currentPos.keyState == keySum)  
                return currentPos.keyCount; 
            
            for(int i=0;i<4;++i){ 
                int x_init = currentPos.x + delta_x[i]; 
                int y_init = currentPos.y + delta_y[i];

                if(x_init < 0 || y_init < 0 || x_init >= n || y_init >= m || visit[x_init][y_init][currentPos.keyState]
                        || grid[x_init].charAt(y_init) == '#')
                    continue;
                
                int keyState = currentPos.keyState;
                char ch = grid[x_init].charAt(y_init);

                if(ch>='a' && ch<='f')
                    keyState |= 1 << (ch -'a'); 
                
                if(ch >= 'A'&& ch <= 'F'){ 

                    int doorState = ch -'A';  

                    if((keyState >> doorState & 1) != 1)
                        continue;

                }
                visit[x_init][y_init][keyState] = true;  

                queue.add(new Identification(x_init, y_init, currentPos.keyCount + 1, keyState));
            }
        }
        return -1;
    }
}
