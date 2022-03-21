package ie.tudublin;

import ddf.minim.*;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio2 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;  //microphone
    AudioBuffer ab; //every ssample from audio frame

    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    FFT fft;


    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void settings()
    {
        size(1024, 1000);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix; 
        // ap = minim.loadFile("Choli.mp3", 1024);
        // ap.play();
        // ab = ap.mix;
        colorMode(HSB);

        fft = new FFT(1024, 44100);

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];
    }

    float off = 0;

    public void draw()
    {
        background(0);
        colorMode(RGB);
        stroke(255);
        float freq = 0f;
        float maxIndex = 0;
        float halfH = height/2;
        for(int i =0; i<ab.size(); i++){
            line(i, halfH, i, halfH + ab.get(i) * halfH);
            
        }
        
        fft.window(FFT.HAMMING);
        fft.forward(ab);

        stroke(0,255,0);
        for(int j =0; j< fft.specSize(); j++){
            line(j, 0, j,fft.getBand(j)*10);
            if (fft.getBand(j) > maxIndex){
                maxIndex = j;
            }
        }

        textSize(20);
        fill(255);
        freq = fft.getFreq(maxIndex);
        text("Freq: "+ freq, 100,200);
        
        }
        


        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

    }  
      

