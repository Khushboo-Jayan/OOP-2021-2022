package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet{

   Player p;
   Player p2;
   Amo a1;


    public void setup()
    {
        p = new Player(100, 100, 50, this);
        p2 = new Player(300, 250, 100, this);

        a1  = new Amo(random(width), random(height));
    }

    public void settings()
    {
        size(500,500);
    }

    public void draw()
    {
        background(0);
        Amo.render();
        p.update();
        p.render();	
        p2.update();
        p2.render();
    }    
}