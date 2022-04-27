package ie.tudublin;

import processing.core.PApplet;

public class Star extends PApplet {
    

    public void settings(){
        size(500,500);
    }

    public void setup(){
        background(0);
        colorMode(HSB);
      }
    
    public void draw(){
        for(int a = 50; a < width; a+=50){
          drawStar(random(width),random(height));
        }
          delay(1000);
      }

    public void drawStar(float i, float j){
        stroke(random(255),255,255);
        strokeWeight(2);
        noFill();
        
        //method 1
        //quad(i,j,i-8,j+21,i,j+14,i+8,j+21);
        //triangle(i,j+14,i-14,j+7,i+14,j+7);
      
        //method 2
        beginShape();
        vertex(i,j-50);
        vertex(i+15,j-15);
        vertex(i+50,j);
        vertex(i+20, j+20);
        vertex(i+30,j+50);
        vertex(i,j+30);
        vertex(i-30,j+50);
        vertex(i-20,j+20);
        vertex(i-50, j);
        vertex(i-15, j-15);
        vertex(i,j-50);
        endShape();
      }
}
