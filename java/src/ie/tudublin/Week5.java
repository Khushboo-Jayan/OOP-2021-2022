package ie.tudublin;

import processing.core.PApplet;

public class Week5 extends PApplet {
    float cx, cy;
    int mode;
    float col;
    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    float[] rainfall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
    
    public void settings(){
        size(500,500);
    }

    public void setup(){
        cx = width/2;
        cy = height/2;
        colorMode(HSB);
    }

    public void draw(){
        switch(mode){
          case 0:{
            background(0);
            float border = width * 0.1f;
            float range = 120;
            stroke(255);
            line(border, border, border, height - border);
            line(border, height - border, width - border, height - border);     
            // Draw the vertical tick marks
                      textAlign(CENTER, CENTER);
                      colorMode(HSB);
                      //draw ticks
                      for(float f = 0; f <= range ; f += 10)
                      {
                          float y = map(f, 0, range, height - border, border);
                          line(border - 5, y, border, y);
                          fill(255);
                          text((int) f, border * 0.5f, y);
                      } 
                    //   for(int m=0; m<= rainfall.length; m+=1){
                    //       rectMode(CORNER);
                    //       rect(border, height - rainfall[m], border, border);
                    //   }  

                    float w = (width - (border * 2.0f)) / (float)rainfall.length;
                
                    for(int i = 0 ; i < rainfall.length; i ++)
                    {
                        float x = map(i, 0, rainfall.length, border, width-border);
                        float c = map(i, 0, rainfall.length, 0, 255);
                        stroke(255);
                        fill(c, 255, 255);
                        float h = map(rainfall[i], 0, 120, 0, -height + (border * 2.0f)); 
                        rect(x, height-border, w, h);
                        fill(255);
                        text(months[i], x + (w / 2), height - (border / 2));
                    }
                }
                    break; 
                case 1:{
                    background(0);
                    float border = width * 0.1f;

                    // Draw the axis
                    stroke(255);
                    line(border, border, border, height - border);
                    line(border, height - border, width - border, height - border);
                    for(int i = 0 ; i <= 120; i += 10)
                    {
                        float y = map(i, 0, 120, height - border, border);
                        line(border - 5, y, border, y);
                        fill(255);
                        textAlign(CENTER, CENTER);
                        text(i, border / 2, y);
                    }
                    float w = (width - (border * 2.0f)) / (float)rainfall.length;
                    
                    // TrendLine
                    for(int i = 1 ; i < rainfall.length; i ++)
                    {
                        
                        float x1 = map(i-1, 0, rainfall.length, border, width-border);
                        float x2 = map(i, 0, rainfall.length, border, width-border);
                        float y1 = map(rainfall[i-1], 0, 120, height - border, border); 
                        float y2 = map(rainfall[i], 0, 120, height - border, border); 
                        
                        line(x1 + (w / 2), y1, x2 + (w / 2), y2);
                        
                        text(months[i-1], x1 + (w / 2), height - (border / 2));
                
                        // To print December
                        if (i == rainfall.length - 1)
                            text(months[i], x2 + (w / 2), height - (border / 2));
        
                    }
                }
                    break;

                case 2:{
                    background(0);
                    float r = mouseX;
                    stroke(255);
                    noFill();
                    // circle(cx, cy, r * 2.0f);
                    float tot = 0;
                    for(float f:rainfall)
                    {
                        tot += f;
                    }
                    float start = 0;
                    for(int i = 0 ; i < rainfall.length ; i ++)
                    {
                        //pie chart
                        float val = map(rainfall[i], 0, tot, 0, TWO_PI);
                        float col = map(i, 0, rainfall.length, 0, 255);
                        noStroke();
                        fill(col, 255, 255);
                        arc(cx, cy, r * 2, r * 2, start, start + val, PIE);
                        start = start + val;

                        //month names
                        float theta = start + (val * 0.5f);
                        float x = cx + cos(theta) * (r * 1.2f);
                        float y = cy + sin(theta) * (r * 1.2f);
                        fill(255);
                        text(months[i], x, y);
                    }
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
