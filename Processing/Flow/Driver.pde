class Driver extends Visible
{
    float maxSpeed = 0.1;
    float maxForce = 0.1;
    
    public Driver()
    {
        super();
    }
    
    public Driver(PVector initial)
    {
        super(initial);
    }
    
    public void update()
    {
        applyForce(PVector.sub(mPos,pos).normalize());
        if (!isStatic)
        {
            vel.add(acc);
            acc = new PVector();
            pos.add(vel);
        }
    }
    
    public void display()
    {
        float theta = vel.heading() + radians(90);
        fill(127);
        stroke(0);
        pushMatrix();
        translate(pos.x,pos.y);
        rotate(theta);
        beginShape(TRIANGLES);
        vertex( 0, -(height/2));
        vertex(-r(), height/2);
        vertex( r(), height/2);
        endShape();
        popMatrix();
    }
}