import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Pendulum
{
	PApplet	parrent;
	PVector	origin;
	PVector	position;
	float	aVel;
	float	aAcc;
	float	rope;
	float	angle			= PConstants.PI / 2;
	float	angularVelocity	= 0.01f;
	
	public Pendulum(PApplet parrent, PVector origin, float rope)
	{
		this.parrent = parrent;
		this.origin = origin;
		this.rope = rope;
		position = new PVector(origin.x, origin.y + rope);
	}
	
	public void update()
	{
		position.x = origin.x + (rope * PApplet.sin(angle));
		position.y = origin.y + (rope * PApplet.cos(angle));
		
		aAcc = -angularVelocity * PApplet.sin(angle);
		
		angle += aVel;
		aVel += aAcc;
		aVel *= 0.992;
		//aVel *= 0.983;
	}
	
	public void draw()
	{
		parrent.stroke(255);
		parrent.fill(255, 0, 0);
		parrent.line(origin.x, origin.y, position.x, position.y);
		parrent.ellipseMode(PConstants.CENTER);
		parrent.fill(255);
		parrent.noStroke();
		parrent.ellipse(position.x, position.y, 50, 50);
	}
	
}
