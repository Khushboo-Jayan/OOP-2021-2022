package ie.tudublin;

import processing.core.PApplet;

public class Week3 extends PApplet {

    float cx, cy;
    int mode;
    float col;
    int side;

    public void settings(){
        size(500,500);
    }

    public void setup(){
        size(500,500);
        cx = width/2;
        cy = height/2;
        colorMode(HSB);
      }

    public void draw(){
        switch(mode){
          case 0:
            background(0);
            for(int i=width; i>=0; i-=50){
              col = map(i,0,width,0,255);
              stroke(255);
              fill(col,255,255);
              ellipse(cx,cy,i,i);
            }
            break;
           case 1:
           background(0);
           int radius =50;
             for(int j=radius; j<width;j+=50){
               for (int k=radius; k<height; k+=50){
                 col = map(j-50,0,width,0,255);
                 stroke(255);
                 fill(col,255,255);
                 ellipse(j,k,50,50);
               }
             }
             break;
            case 2:
             background(0);
             side =50;
             int numbering = -5;
             rectMode(CENTER);
             for(int j=side; j<width;j+=50){
               for (int k=side; k<height; k+=50){
                 textAlign(RIGHT);
                 text(numbering, j,k);
                 noFill();
                 strokeWeight(2);
                 stroke(0,0,255);
                 rect(j,k,side,side); 
                 numbering++;
               }
               numbering++;
             }
              break;
            case 3:
              background(0);
               side =30;
               rectMode(CORNER);
               for(int j=0; j<width;j+=side){
                 for (int k=0; k<height; k+=side){
                   fill(0);
                   stroke(0, 0, 255);
                   strokeWeight(2);
                   rect(j,k,side,side); 
                 }
                 fill(102, 115, 255);
               }
                break;
            case 4:
              background(0);
              int sides = (mouseX / 50);
                      float theta = TWO_PI / (float) sides;
                      float r = 200;
                      stroke(255);
                      for(int i = 1 ; i <= sides ; i ++)
                      {
                          float x1 = sin(theta * (i - 1)) * r;
                          float y1 = cos(theta * (i - 1)) * r;
                          float x2 = sin(theta * i) * r;
                          float y2 = cos(theta * i) * r;
                          line(cx + x1, cy + y1, cx + x2, cy + y2);         
               }
              break;
        }
      }

      public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }
}
