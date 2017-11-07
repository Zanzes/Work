abstract class GameObject
{
    public boolean isStatic = false;
    public PVector pos = new PVector();
    public PVector vel = new PVector();
    public PVector acc = new PVector();
    public float width=0;
    public float height=0;;
    
    public GameObject()
    {
        pos = new PVector();
    }
    
    public GameObject(PVector initial)
    {
        pos = initial;
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
    
    public float r()
    {
        return width/2;
    }
    
    public void applyForce(PVector force)
    {
        if (!isStatic)
            acc.add(force);
    }
}