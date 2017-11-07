class Vehicle
{
    float maxSpeed = 8;
    float maxForce = 0.3;
    PVector pos = new PVector();
    PVector vel = new PVector();
    PVector acc = new PVector();
    PVector target;
    float r = 5;
    
    public Vehicle()
    {
        
    }
    
    public Vehicle(PVector start)
    {
        pos = start;
    }
    
    public Vehicle(PVector start,float maxSpeed,float maxForce)
    {
        pos = start;
        this.maxSpeed = maxSpeed;
        this.maxForce = maxForce;
    }
    
    public void applyForce(PVector force)
    {
        acc.add(force);
    }
    
    public void setTarget(PVector target)
    {
        this.target = target;
    }
    
    public void update()
    {
        PVector desired = PVector.sub(target,pos);
        desired.setMag(maxSpeed);
        PVector ster = PVector.sub(desired,vel);
        ster.limit(maxForce);
        applyForce(ster);
        vel.add(acc);
        acc=new PVector();
        pos.add(vel);
    }
    
    public void display()
    {
        fill(255);
        stroke(0);
        ellipseMode(RADIUS);
        ellipse(pos.x,pos.y,r,r);
        fill(255,0,0);
        PVector n = target.copy();
        n.sub(pos).normalize();
        //applyForce(n);
    }
}