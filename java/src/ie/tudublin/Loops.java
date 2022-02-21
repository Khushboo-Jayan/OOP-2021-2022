package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{
	int mode=4;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		
	}

	float MagicMap(float a, float b, float c, float d, float e){
		float r1 = c-b;
		float r2 = e-d;
		float howFar = a-b;

		return d+((howFar / r1)*r2);
	}
	
	float offset = 0;
	
	public void draw()
	{	
		switch(mode){
			case 0:
				background(0);
				//int bars = 10;
				int bars = (int) (mouseX / 0.2f) ; // changes as he cursor is hovered. 
				float w = width / (float) bars;
				//float colorGap = 255/(float) bars;
				for(int i =0; i<bars; i++){
					noStroke();
					fill(map(i, 0, bars, 0, 255), 255,255);
					rect(map(i, 0, bars, 0, 500), 0, w, height);
				}
					break;
			case 1:
				background(0);
				int squares = (int) (mouseX / 20.0f);
				float h = width /(float) squares;
				for(int i = 0; i < squares; i++){
					noStroke();
					fill(map(i, 0, squares, 0, 255),255,255);
					float x = map(i,0,squares, 0, width);
					rect(x, x, h, h);
					rect((width - h) -x, x, h, h);
				}
				break;

			case 2: 
				//Nested loop for circles
				// colorMode(HSB, 5000, 100, 100);
				background(255);
				int circles = (int) (mouseX / 20.0f) ;
				float d = width / (float) circles;
				for (int j = 0; j<circles; j++) {
					for (int i = 0; i <circles; i++) {
					noStroke();
					float c = map(i+j,0,circles*2,0,255);
					//fill((x*10)+bars2, 100, 100);
					fill(c,255,255);
					float x = map(i,0,circles-1, d/2.0f, width -(d/2.0f));
					float y = map(j,0,circles-1, d/2.0f,width-(d/2.0f));
					circle(x,y,d);
					//circle(x+25, y+25, 50);
					}
				}
				break;
			case 3:
				background(0);
				colorMode(RGB);
				float border = width *0.1f;
				for (int i = -5; i<=5; i++){
					float x = map(i, -5, 5, border, width-border);
					stroke(0,255,0);
					line(x,border,x,height-border);
					line(border, x, width-border,x);
					fill(255);
					text(i,x,border*0.5f);
					text(i, border*0.5f, x);
				}
				break;
			case 4:
				background(0);
				colorMode(RGB);
				stroke(255);
				float cx = width/2;
				float cy = height/2;
				int sides = (int) map(mouseX, 0, width, 0, 20);
				for(int i =0; i<sides; i++){
					float theta = map(i, 0, sides, 0, TWO_PI);
					float x = cx + sin(theta);
					float y = cy + cos(theta);
					circle(x, y, 20);
				}
				break;
				// //inline circles
				// background(0);
				// int circles = (int) (mouseX / 20.0f);
				// int d = (int) (width /(float) circles);
				// for (int i =0; i< circles; i++){
				// 	noStroke();
				// 	fill(map(i,0,circles, 0,255),255,255);
				// 	circle(map(i,0,circles-1,d/2.0f, width-(d/2.0f),height/2, d));
				// }
				
				
					// map(a,b,c,d,e)
					// a = inputValue
					// b, -c
					

		// 		// background(0);
		// 		// int bars = mouseX; // changes as he cursor is hovered. 
		// 		// float w = width / (float) bars;
		// 		// //float colorGap = 255/(float) bars;
		// 		// for(int i =0; i<bars; i++){
		// 		// 	noStroke();
		// 		// 	fill(map(i, 0, bars, 0, 255), 255,255);
		// 		// 	rect(map(i, 0, bars, 0, 500), 0, w, height);
		// 		// }
		// }
		//multiple rectangles in a row
		// background(255);
		// fill(50);
		// stroke(255);
		// strokeWeight(2);
		// int pos = 50;
		// int wid = 50;
		// int quant = floor( width / wid );
		// colorMode(HSB,quant,100,100);
		// for( int i=0; i<quant; i++){
		// 	fill(i,100,100);
		// 	rect(i*pos,0,wid,height);
		// 	ellipse(i*pos + wid/2, 100, wid, wid);
		// }
		

		// //Concentric circles
		// colorMode(HSB, 5000, 100, 100);
		// for (int x = 0; x<500; x+=50) {
		// 	for (int y = 0; y <500; y+=50) {
		// 	stroke(0);
		// 	strokeWeight(1);
		// 	fill((x*8)+y, 100, 100);
		// 	circle(255, 255, 400-x);
   		// 	 }
  		// }


		
		}

	}
}
