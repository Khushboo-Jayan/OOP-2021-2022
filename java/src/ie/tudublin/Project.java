package ie.tudublin;

public class Project {
    background(0);
                strokeWeight(2);
                for (int i = 0; i < ab.size(); i+= 10) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    float r = map(i, 0, 0.5f, 100, 2000);
                    float f = lerpedBuffer[i] * halfH * 4.0f;
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);        
                    line(0, i, lerpedBuffer[i] * halfH * 4, i);
                    line(width, i, width - (lerpedBuffer[i] * halfH * 4), i);
                    line(i, 0, i, lerpedBuffer[i] * halfH * 4);
                    line(i, height, i, height - (lerpedBuffer[i] * halfH * 4));
                    // circle(cx, cy, r);
                    circle(i, halfH + f, 5);
                    circle(i, halfH - f, 5);    
}
