package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet{

    float x, y, w;

    void drawPlayer(float x, float y, float w){
        fill(255);
        beginShape();
        vertex(x, y);
        vertex(x - 10, y+20);
        vertex(x, y+15);
        vertex(x+10, y+20);
        endShape();
    }

    public void setup()
    {
        x = width/2;
        y = height/2;
        w = 100;
    }

    public void settings()
    {
        size(500,500);
    }

    public void draw()
    {
        background(0);
        drawPlayer(x, y, w);

    }    
}
