package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB);
		// background(0);

		
	}
	public void draw()
	{	
	
	//class work
	stroke(255); // used to set color of lines
	background(225, 0, 0); //greyscale
	
	fill(255,255,0); // line (10, 10, 200, 200); //x1, y1, x2, y2
	circle (250, 250, 400); //cx, cy, r
	noFill();

	point(255, 255); //x, y
	
	fill(48,213,200);
	triangle(15, 400, 490, 400, 250, 5); //x1, y1, x2, y2, x3, y3
	noFill(); // noFill();
	
	fill(244, 194, 194);
	ellipse(255, 255, 200, 90);
	noFill();
	fill(0);
	circle(255, 255, 65);
	noFill();

	// //Deathly Hallows
	// stroke(255);
	// background(0); //greyscale
	// fill(0);
	// triangle(15, 379, 490, 379, 250, 5); //x1, y1, x2, y2, x3, y3
	// noFill(); // noFill();
	
	// fill(0); // line (10, 10, 200, 200); //x1, y1, x2, y2
	// circle (250, 250, 255); //cx, cy, r
	// noFill();
	// line(250,379,250,5);

	}
}
