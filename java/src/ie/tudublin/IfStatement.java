package ie.tudublin;

import processing.core.PApplet;

public class IfStatement extends PApplet {
    int mode=2;

    public void settings(){
        size(500,500);
    }

    public void setup(){
        colorMode(RGB);
    }
    public void draw(){
        switch(mode){
            case 0:
            background(0);
                rectMode(CORNER);
                fill(0,50,255);
                if(mouseX < width/2){
                    rect(0, 0, width/2, height);
                }
                if(mouseX > width/2){
                    rect(width/2, 0, width/2, height);
                }
                break;
            case 1:
                background(0);
                rectMode(CORNER);
                fill(0,50,255);
                if(mouseX < width/2 && mouseY<height/2){
                    rect(0, 0, width/2, height/2);
                }
                if(mouseX > width/2 && mouseY <height/2){
                    rect(width/2, 0, width/2, height/2);
                }
                if(mouseX < width/2 && mouseY > height/2){
                    rect(0, height/2, width/2, height/2);
                }
                if(mouseX > width/2 && mouseY > height/2){
                    rect(width/2, height/2, width/2, height/2);
                }
                break;
            case 2:
                background(0);
                rectMode(CENTER);
                rect(width/2, height/2, width/2, height/3);
                fill(0,50,255);
                if(mouseX > width/2 - (width/2)/2 && mouseX < width/2+width/2 && mouseY > height/2 - (height/2)/2 && mouseY < height/2+height/2 ){
                    fill(255,0,0);
                }
                break;
        }
    }
}

