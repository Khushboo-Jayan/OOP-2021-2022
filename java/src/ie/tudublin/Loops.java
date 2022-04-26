package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

    int mode =1;
    float cx;
    float cy;

    public void settings(){
        size(500,500);
    }

    public void setup(){
        colorMode(HSB);
        cx = width / 2;
        cy = height / 2; 
    }
    public void draw(){
        switch(mode){
            case 0:
                //fixed 10 bars
                    // background(0);
                    // float bars = width/50;
                    // float calWidth = width/bars;
                    // for(int i = 0; i< bars; i++){ 
                    //     rectMode(CORNER);
                    //     noStroke();
                    //     float col = map(i, 0, bars, 0, 255);
                    //     fill(col,255,255);
                    //     rect(map(i, 0, bars, 0, width), 0, calWidth, height);
                    // }
                //using mouseX
                    background(0);
                    float bars = map(mouseX, 0, width, 0, 600);
                    float calWidth = width/bars;
                    for(int i = 0; i< bars; i++){
                        rectMode(CORNER);
                        noStroke();
                        float col = map(i, 0, bars, 0, 255);
                        fill(col,255,255);
                        rect(map(i, 0, bars, 0, width), 0, calWidth, height);
                    }
                break;
            
            case 1:
                background(0);    
                // float squares = map(mouseX, 0, width, 0, 600);
                // float squareSize = width/squares;
                // for(int j =0; j  height; j+=squareSize){
                //     for(int i = 0; i< squares; i++){
                //         rectMode(CORNER);
                //         noStroke();
                //         float col = map(i, 0, squares, 0, 255);
                //         fill(col,255,255);
                //         rect(map(i, 0, squares, 0, width), j, squareSize, squareSize);
                //     }
                // }    
                // break;
                fill(50, 255, 255);                                    
                if (mouseX < cx && mouseY < cy)
                {
                    rect(0, 0, cx, cy);
                }
                else if (mouseX > cx && mouseY < cy)
                {
                    rect(cx, 0, cx, cy);
                }
                else if (mouseX < cx && mouseY > cy)
                {
                    rect(0, cy, cx, cy);
                }
                else
                {
                    rect(cx, cy, cx, cy);
                }
                break;
            
        }
    }
}
