package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {
    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };
    String[] months = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };

    int mode = 2;

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        for (int i = 0; i < rainfall.length; i++) {
            println(rainfall[i] + "\t" + months[i]);
        }

        // for(float r:rainfall){ //enhanced for loop or foreach
        // println(r);
        // }

        // calculate the least amount of rainfall
        float minimum = rainfall[0];
        float maximmum = rainfall[0], sum = 0.0f;
        String maximmumMonth = months[0];
        String minimumMonth = months[0];
        for (int i = 0; i < rainfall.length; i++) {
            if (rainfall[i] < minimum) {
                minimum = rainfall[i];
                minimumMonth = months[i];
            }
            if (rainfall[i] > maximmum) {
                maximmum = rainfall[i];
                maximmumMonth = months[i];
            }
            sum = sum + rainfall[i];
        }

        float averageRainfall = sum / (rainfall.length + 1);

        System.out.println("\n\nMinimum rainfall was " + minimum + " in month of " + minimumMonth);
        System.out.println("\n\nMaximum rainfall was " + maximmum + " in month of " + maximmumMonth);
        System.out.println("\n\nAverage rainfall was " + averageRainfall);
        System.out.println("\n\nSum of rainfall was " + sum);
        //finish rainfall calculation
    }

    public void draw(){
        background(0);
        colorMode(HSB);
		// //int bars = 10;
		// float bars = rainfall.length ; // changes as he cursor is hovered. 
		// float w = width / (float) bars;
		// //float colorGap = 255/(float) bars;
		// for(int i =0; i<bars; i++){
        //     noStroke();            
        //     rect(map(i, 0, bars, 0, 500), 0, w, rainfall[i]*3);
        //     fill(map(i, 0, bars, 0, 255), 255,255);
        // }
        // for(int i =0; i<rainfall.length; i++){
        //     float x = map(i, 0, rainfall.length, 0, width);
        //     // int c = (int) map(i, 0, rainfall.length, 0, 255);
        //     rect(x, height, w, -rainfall[i]);
        //     fill(map(i, 0, bars, 0, 255), 255,255);
        //     textAlign(CENTER);
        //     text(months[i], x+(w/2), height-50);
        //     }

        switch(mode){
            case 0:
            background(0);
            int bars = rainfall.length;
            float w = width / (float) bars;
            //float colorGap = 255/(float) bars;
            for(int i =0; i<bars; i++){
                noStroke();
                fill(map(i, 0, bars, 0, 255), 255,255);
                rect(map(i, 0, bars, 0, 500), height, w, -rainfall[i]*4);
            }
                break;
            case 1:
            background(0);
            colorMode(HSB);
            line(255, 255, 400, 400);
            stroke(255,0,0);
            int points = rainfall.length;
            float mw = width / (float) points;
            //float colorGap = 255/(float) bars;
            for(int i =1; i<points; i++){
                line(mw, rainfall[i-1], mw, rainfall[i]);
                stroke(255,0,0);
            }
                break;
            case 2: 
                background(0);
                float border = width*0.2f;
                //Draw axis
                stroke(255);
                line(border, border, border, height-border);
                line(border, height-border, width- border, height);
                for(int i=0; i <= 120; i++){
                    float y = map(i, 0, 120, height-border, border);
                    line(border-5, y, border, y);
                    fill(255);
                    textAlign(CENTER,CENTER);
                    text(i, border/2, y);
                }

                float w2 = width/(float) rainfall.length;

                for(int i=0; i < rainfall.length; i++){
                    float x = map(i, 0, rainfall.length, border, width);
                    float c = map(i, 0, rainfall.length, 0, 255);
                    stroke(0);
                    fill(c, 255, 255);
                    float h = map(rainfall[i], 0, 120, 0, -(height+(border*2.0f)));
                    rect(x,height-border,w2,h);
                    text(months[i], x, (w2/2), height-(border/2));
                }
                break;
            case 3:
                background(0);
                float r = mouseX;
                float cx = width/2;
                float cy = width/2;
                stroke(255);
                noFill();
                circle(cx, cy, r*2);
                float tot = 0f;
                for(float f:rainfall){
                    tot+= f;
                }
                
                float start =0f;

                for(int i=0; i<rainfall.length;i++){
                    float val = map(rainfall[i], 0, tot, 0, TWO_PI);
                    float c = map(i, 0, rainfall.length, 0, 255);
                    noStroke();
                    fill(c, 255, 255);                    
                    arc(cx,cy,r*2,r*2,start,start+val, PIE);
                    float theta = start + (val*0.5f);
                    float x = cx + cos(theta) * (r*1.2f);
                    float y = cy +sin(theta) * (r*1.2f);
                    fill(255);
                    text(months[i], x, y);
                    start = start + val;
                }               
                break;
        }       

    }
}
