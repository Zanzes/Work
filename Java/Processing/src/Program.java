import processing.core.PApplet;
import processing.core.PVector;

public class Program extends PApplet
{
	Pendulum pendulum;
	
	public static void main(String[] args)
	{
		PApplet.main("Program");
	}

    public void settings(){
        size(800,600);
    }

    public void setup(){
    	pendulum = new Pendulum(this, new PVector(width / 2,0), 300);
    }

    public void draw(){
        background(0);
        pendulum.update();
        pendulum.draw();
    }
	
}
