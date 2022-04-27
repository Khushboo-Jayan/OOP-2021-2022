package ie.tudublin;

import processing.core.PApplet;

public class ConwaysLife extends PApplet {
    float side = 4;
    int col;
    int row;
    int[][] board;
    int mode;
    
    
    public void settings(){
        size(500,500);
    }

    public void setup(){
         col = (int) (500/side);
         row = (int) (500/side);
         board = new int[col][row];
         frameRate(24);

         for(int y=0; y<row; y++){
             for(int x=0; x<col; x++){
                 board[x][y] = (int)random(2);
             }
         }
    }

    public void draw(){
        background(0);
            int[][] next = new int[col][row];
            for(int y=1; y<row-1; y++){
                for(int x=1; x<col-1; x++){
                    int neighbours = countNeighbours(x,y);
                    next[x][y] = ruleOfLife(board[x][y], neighbours);
                }//inner for loop
            }//outer for loop
            board = next;
            drawBoard();        
        }//end draw

    //count the number of neighbours
    int countNeighbours(int x, int y){
        int localNeighbours =0;
        for(int i= -1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                localNeighbours +=board[x+j][y+i];
            }//inner for loop
        }//outer for loop
        localNeighbours -= board[x][y];
        return localNeighbours;
    }//end of count neighbour function

    //ruleOfLife function
    int ruleOfLife(int status, int localNeighbours){
        if(status == 1 && localNeighbours > 3){
            return 0;      //overpopulation
        }

        else if(status == 1 && localNeighbours<2){
            return 0; 
        }

        else if(status == 0 && localNeighbours==3){
            return 1; //reproduction 
        }

        else{
            return status; //return the status of lifeform
        }
    }//end of ruleOfLife function

    //drawing the board
    void drawBoard(){
        for(int y=0; y<row; y++){
            for(int x=0; x<col; x++){
                if(board[x][y] == 1){
                    colorMode(RGB);
                    fill(0,255,0);
                }    
                else{
                    colorMode(HSB);
                    fill(0);
                }
                rect(x*side,y*side,side,side);
            }//inner for loop
        }//outer for loop
    }

    //mousePressed
    public void mousePressed(){
        int cellX = (int) (mouseX / side);
        int cellY = (int) (mouseX/side);
        board[cellX][cellY] = 1-board[cellX][cellY];
    }

    public void keyPressed() {
        // the value of mode will be the number of the
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
        if(keyCode == ' '){
            for(int y=0; y<row; y++){
                for(int x=0; x<col; x++){
                    board[x][y] = (int)random(2);
                }
            }
        }
    }
}
