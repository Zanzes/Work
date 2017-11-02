class Vehicle
{
    float maxSpeed = 2;
    float maxForce = 0.01;
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
        vel.add(acc);
        acc = new PVector();
        vel.limit(maxSpeed);
        pos.add(vel);
    }
    
    public void display()
    {
        fill(255);
        stroke(255);
        ellipseMode(RADIUS);
        ellipse(pos.x,pos.y,r,r);
        fill(255,0,0);
        PVector n = target.copy();
        n.sub(pos).normalize();
        applyForce(n);
    }
}