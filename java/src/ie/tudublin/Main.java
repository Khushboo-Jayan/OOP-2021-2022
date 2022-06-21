package ie.tudublin;

public class Main
{

    //if statements 
    public static void ifStatement()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new IfStatement());
    }


    //loops
    public static void loops()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Loops());
    }


    //week 3 visualization
    public static void week3()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Week3());
    }


    //automatic + mousepressed star
    public static void star()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Star());
    }

    //charts and graphs
    public static void week5()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Week5());
    }

    //Audio Files
    public static void audio()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Week6());
    }

    //Game of life
    public static void lifeForm()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new ConwaysLife());
    }

    //Swarm Simulation
    public static void swarms()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new SwarmVisualisation());
    }


    public static void main(String[] args)
    {
        swarms();
    }
}