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
                 if( board[i][j] == '.' )
                 {
                     for(int k = 1; k <= 9; ++k)
                     {
                         board[i][j] = '0' + k;
                         if( isVaild(board,i,j) && _solveSudoku(board) )
                {
                            return true;
                         }
                         //失败的话该位置再置为下一个测试值，但是先要还原原来的值，因为我们是用board的"引用",所以不能直接跳过
                         board[i][j] = '.';
                     }
                     //1~9都不满足的话,失败
                     return false;
                 }
            }
        }
        /*
            走到这里说明了一些问题：
            1.成功了,不需要做什么
            2.board中没有‘.’,这样就不会进入if循环，按理说这个时候需要再判断一次board是否是正解，但是没有判断却也没有错...
        */
        return true;
    }
    
    bool isVaild(vector<vector<char>> &board, int x,int y)
    {
        //横向
        for(int i = 0; i < 9; ++i)
        {
            if(i != y && board[x][i] == board[x][y])
            {//重复出现，非法
                return false;
            }
        }
        //纵向
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
        //成功   
        return true;
    }
};
--------------------- 
作者：_从未止步 
来源：CSDN 
原文：https://blog.csdn.net/zr1076311296/article/details/51354080 
版权声明：本文为博主原创文章，转载请附上博文链接！