class Driver extends Visible
{
    float maxSpeed = 10;
    float maxForce = 0.1;
    float closestDistance = 100;
    
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
        if (!isStatic)
        {
            vel.add(acc);
            acc = new PVector();
            pos.add(vel);
        }
    }
    
    public void seek(PVector target)
    {
        PVector desierd = PVector.sub(target,pos);
        float mag = desierd.mag();
            if (mag > maxSpeed)
            {
                desierd.setMag(maxSpeed);
            }
        if (mag > closestDistance)
        {
        }
        else
        {
            vel.normalize();
        }
            PVector steering = PVector.sub(desierd,vel);
            steering.limit(maxForce);
            applyForce(steering);
    }
    
    public void display()
    {
        println(pos);
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
    
    public PVector getBreake()
    {
        return PVector.sub(pos,vel);
    }
}