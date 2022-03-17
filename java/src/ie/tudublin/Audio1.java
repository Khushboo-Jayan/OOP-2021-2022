package ie.tudublin;

import ddf.minim.*;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    public void settings(){
        size(1024, 500);
    }
    
    public void setup(){
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
    }

    float y = height/2;
    float smoothedY=y;
    public void draw(){
        background(0);
        stroke(255);
        colorMode(HSB);
        float halfH = height/2;
        for(int i =0; i< ab.size(); i++){
            float c = map(i, 0, ab.size(), 0, 255);
            float avg = (ab.get(i));
            stroke(c, 255, 255);
            //line(i, halfH, i, halfH + ab.get(i) * 500);         //by default the range goes through -1 to +1 hence we multiply by 500 to get big values
            // stroke(255);
            // fill(100,255,255);
            // circle(width/2, halfH, avg *500);
        }


        
        y += random(-10,10);
        circle(100, y, 50);
        smoothedY = lerp(smoothedY, y, 0.1f);
        circle(200, smoothedY, 50);
       
    }
}
