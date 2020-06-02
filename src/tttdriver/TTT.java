/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tttdriver;


    import javax.swing.JOptionPane; 

public class TTT 
{
    JOptionPane pane;
    private String[][] board;
    private int turn;
 
    
    public TTT()
    {
        pane  = new JOptionPane();
        board = new String[3][3];
        turn = 1;
        
        for(int r = 0; r< board.length; r++)
        {
            for(int c = 0; c < board[r].length; c++)
            {
                board[r][c] = "?";
            }
        }
    }
    
    
        public String stringBoard()
    {
        String s = "            1            2            3\n";
        for(int r = 0; r< board.length; r++)
        {
            s +=  (r + 1) + "           ";
            for(int c  = 0; c < board[r].length; c++)
            {
                s += board[r][c] + "           ";
             
            }
            s += "\n";
        }
        return s;
    }
    
    public void getMove()
    {
        String player;
        Object[] pos = {"1,1","1,2","1,3","2,1",",2,2","2,3","3,1","3,2","3,3"};
        int row =0;
        int col = 0;
          
        int move = pane.showOptionDialog(null, stringBoard() + 
                "\n\nMake your move (row,col)"
        ,"Tic-Tac-Toe",
        JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,pos,null);
      
         
        for(int i = 0; i < move; i++)
        {
            col++;
            if(col % 3 == 0)
            {        
               row++;
              col =0; 
            }
         
        }
       // System.out.println(row + "  " + col);
        
  
           
       // if(turn % 2 != 0)
        //{
         
           if(board[row][col].equals("O") == true || board[row][col].equals("X")
                   ==  true)
           { pane.showMessageDialog(null,"LOCATION TAKEN");
           
           }else
           {
            board[row][col] = "X";
            turn++; 
           }        
       // }
    
           
    }
    public void getMove2()
    {
        //if(turn % 2 == 0)        
        //{
             ///////////////////////////////////////////////////////////////////////
           
             
            int row = 0;
           int col = 0 ; 
           
           int maxScore = Integer.MIN_VALUE;
            System.out.println("CPU WENT FIRST");
           int score;
      //   do
      
        //   {           
          //  row = (int)(Math.random() *3);
            //  col=  (int)(Math.random() * 3);          
           
          for(int r  = 0; r < 3; r++)
          {
              for(int c = 0; c < 3;c++)
              {
                 if(board[r][c].equals("?"))
                 {
                    board[r][c] = "O";
                    score = miniMax(board,false);
                    board[r][c] = "?";
                    if(score > maxScore)
                    {
                    maxScore = score;
                    row = r;
                    col = c;
                    }

                 } 
                 
              }
          }
          
            
             
            //  }while(board[row][col].equals("X") == true 
              //     ||board[row][col].equals("O") == true);                 
            board[row][col] = "O";
                    
           turn++; 
           
            //////////////////////////////////////////////////////////////////
        //}
        // pane.showMessageDialog(null,stringBoard());  
    }
   
    public int miniMax(String[][] board, boolean maximizing)
    {  
        int bestScore;
       int score;
      int count =0;
      
        if(getWin() != 10)
        {
            for(int r=0;r < 3; r++)
            {
                for(int c= 0; c < 3;c++)
                {
                    if(board[r][c].equals("?"))
                    {
                        count++;
                    }
                }
            }
            if(getWin()== 2)
            {
                return 1 * (count+ 1);
             
            }else if(getWin() == -1)
            {
                return -1 * (count +1);
               
            }else
                return 0; 
            
        }
 
    
       
        ////////////////////////    
       
       
       if(maximizing == true)
       {
           bestScore = Integer.MIN_VALUE;

         for(int r  = 0; r < 3; r++)
          {
              for(int c = 0; c< 3;c++)
              {
                 if(board[r][c].equals("?"))
                 {
                  board[r][c] = "O";
                  score = miniMax(board,false);
                  board[r][c] = "?";
                   if(score > bestScore)
                    {
                    bestScore = score;
                   } 
              }
          }
       }     
        
        return bestScore;
    }else
       {
              bestScore = Integer.MAX_VALUE;

         for(int r  = 0; r < 3; r++)
          {
              for(int c = 0; c< 3;c++)
              {
                 if(board[r][c].equals("?"))
                 {
                  board[r][c] = "X";
                  score = miniMax(board,true);
                   board[r][c] = "?";
                   if(score < bestScore)
                    {
                    bestScore = score;
                   } 
              }
          }
       
       }
         return bestScore;
       }  
    
    }
       
   
    public int getWin()
    {      
            int winner =10;
         
           for(int r =0; r < 3; r++)
           {
               if(board[r][0].equals("O")&&board[r][1].equals("O")&&board[r][2].equals("O"))
                  {
                     return 2;
                     
                  }
               
           }
           for(int r =0; r < 3; r++)
           {
            
                if(board[r][0].equals("X")&&board[r][1].equals("X")&&board[r][2].equals("X"))
                  {
                    return -1; 
                  }
           }
            for(int c =0; c < 3; c++)
           {
            
                if(board[0][c].equals("O")&&board[1][c].equals("O")&&board[2][c].equals("O"))
                  {
                     return 2; 
                  }
           }
               for(int c =0; c < 3; c++)
           {
            
                if(board[0][c].equals("X")&&board[1][c].equals("X")&&board[2][c].equals("X"))
                  {
                    return-1; 
                  }
           } if( board[0][0].equals("O")&&
                board[1][1].equals("O")&&
                board[2][2].equals("O")
                   )
              
           {
               return 2;
           }else if( board[0][0].equals("X")&&
                board[1][1].equals("X")&&
                board[2][2].equals("X")
                   )
              
           {
             return -1;
           }else
             if( board[0][2].equals("X")&&
                board[1][1].equals("X")&&
                board[2][0].equals("X")
                   )
              
           {
               return  -1;
           }else
               if( board[0][2].equals("O")&&
                board[1][1].equals("O")&&
                board[2][0].equals("O")
                   )
              
           {
               winner = 2;
           }
           boolean isempty = false;
          for(int r = 0; r < 3; r++)
          {for(int c = 0; c < 3; c++)
            {
                if(board[r][c].equals("?"))
                {
                    isempty = true;
                }
            }
          }
                   
           if(winner != 2 && winner!= -1 && turn < 10 && isempty == true)
           {
               winner = 10;
              
           }else 
               return 0;
           
        //  System.out.println(winner);
           return winner;
                   
    }
    
    
    
    public  void play()
    {
   
        while(turn < 10  && getWin() == 10 )
        {
          //  System.out.println(turn);
       
       getWin(); 
       // getWin(); 
       
       getMove();
        getWin();
       // System.out.println(getWin());
     if(turn != 10)
     {
         getMove2();
     }
        }
        if(getWin() == -1)
        {
            pane.showMessageDialog(null,stringBoard() + "\nPLAYER 1 WINS");
        }else if(getWin() == 2)
        {
            pane.showMessageDialog(null,stringBoard() + "\nCPU WINS");
           
        }else if(getWin() == 0)
            pane.showMessageDialog(null,stringBoard() + "\nITS A TIE");
            
    }
    // THIS IS THE FINAL COPY

    
}
