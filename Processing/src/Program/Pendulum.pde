public class Pendulum
{
	PVector	origin;
	PVector	position;
	float	aVel;
	float	aAcc;
	float	rope;
	float	angle			= PConstants.PI / 2;
	float	angularVelocity	= 0.01f;
	
	public Pendulum(PVector origin, float rope)
	{
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
	
	public void display()
	{
		stroke(255);
		fill(255, 0, 0);
		line(origin.x, origin.y, position.x, position.y);
		ellipseMode(PConstants.CENTER);
		fill(255);
		noStroke();
		ellipse(position.x, position.y, 50, 50);
	}

    public PVector getBobPos()
    {
        return position;
    }
	
}