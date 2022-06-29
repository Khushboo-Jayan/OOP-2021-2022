package ie.tudublin;

import processing.core.PApplet;

public class Amo extends PApplet {

    public Amo(float x, float y, YASC yasc)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        halfW = w / 2.0f;
        this.yasc = yasc;
    }

    void render()
    {
        rectMode(CENTER);
        yasc.rect(x, y, 20, 20);
    }
}
