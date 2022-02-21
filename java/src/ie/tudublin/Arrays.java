package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {
    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };
    String[] months = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };

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
    }

    public void draw(){
        background(0);
        colorMode(HSB);
		// //int bars = 10;
		float bars = rainfall.length ; // changes as he cursor is hovered. 
		float w = width / (float) bars;
		// //float colorGap = 255/(float) bars;
		// for(int i =0; i<bars; i++){
        //     noStroke();            
        //     rect(map(i, 0, bars, 0, 500), 0, w, rainfall[i]*3);
        //     fill(map(i, 0, bars, 0, 255), 255,255);
        // }
        for(int i =0; i<rainfall.length; i++){
            float x = map(i, 0, rainfall.length, 0, width);
            int c = (int) map(i, 0, rainfall.length, 0, 255);
            rect(x, height, w, -rainfall[i]);
            fill(map(i, 0, bars, 0, 255), 255,255);
            textAlign(CENTER);;
            text(months[i], x+(w/2), height-50);
            }
    }
}
