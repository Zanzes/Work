abstract class GameObject
{
    PVector loc;
    PVector vel = new PVector();
    PVector acc = new PVector();
    
    float w=0;
    float h=0;
    
    public GameObject()
    {
        loc = new PVector();
    }
    public GameObject(PVector initial)
    {
        loc = initial;
    }
    
    public void update()
    {
        vel.add(acc);
        acc = new PVector();
        loc.add(vel);
    }
    
    public void applyForce(PVector force)
    {
        acc.add(force);
    }
    
    public abstract void display();
    
    public float r()
    {
        return w;
    }
    
    public void r(float r)
    {
        w = r;
        h = r;
    }
    
    public void run()
    {
        update();
        display();
    }
}