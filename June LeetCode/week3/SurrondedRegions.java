/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
Two cells are connected if they are adjacent cells connected horizontally or vertically.

*/
// solution->


class Solution {
    public void solve(char[][] board) {
        
         if (board.length<1 || board[0].length <1)
             return;
        int row = board.length ,col = board[0].length;
         
        for(int i=0;i<row;++i){
            dfs(board,i,0);
            dfs(board,i,col-1);
        }
        for(int i=0;i<col;++i){
            dfs(board,0,i);
            dfs(board,row-1,i);
        }
         
        for(int i=0;i<row;++i){
            for(int j=0;j<col;++j){
                if (board[i][j]=='O') board[i][j]='X';
                if (board[i][j]=='*') board[i][j]='O';
            }
        }
        
    }
    
    public void dfs(char[][] board,int row,int col){
      
        if (board[row][col]=='O'){
            board[row][col]='*';
            if (row<board.length -1) 
                dfs(board,row+1,col);
            if (col<board[0].length -1)
                dfs(board,row,col+1);
            if (row>1) 
                dfs(board,row-1,col);
            if (col>1)
                dfs(board,row,col-1);
        }        
        
    }
    
}
