class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) 
    {
      
        bool result = _solveSudoku(board);
        // if(result == true)
        //     cout<<"Find solve"<<endl;
        // else
        //     cout<<"No Solve "<<endl;
    }
    
    bool _solveSudoku(vector<vector<char>>& board)
    {
        for(int i = 0; i < 9; ++i)
        {
            for(int j = 0 ; j < 9; ++j)
            {
                 if( board[i][j] == '.' ){
                     for(int k = 1; k <= 9; ++k){
                         board[i][j] = '0' + k;
                         if( isVaild(board,i,j) && _solveSudoku(board) )
                            return true;
                         board[i][j] = '.';
                     }
                     return false;
                 }
            }
        }

        return true;
    }
    
    bool isVaild(vector<vector<char>> &board, int x,int y)
    {
        for(int i = 0; i < 9; ++i)
        {
            if(i != y && board[x][i] == board[x][y])
                return false;
            
        }

        for(int i = 0; i < 9; ++i)
        {
            if(i != x && board[i][y] == board[x][y])
            {
                return false;
            }
        }
           
        int wid = 3*(x/3); 
        int hig = 3*(y/3); 
        for(int i = wid; i < wid + 3; ++i)
        {
            for(int j = hig; j < hig + 3; ++j)
            {
               if(i!=x && j!=y && board[i][j] == board[x][y])
               {
                   return false;
               }
            }
        } 
        return true;
    }
};
