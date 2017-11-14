abstract class Visible extends GameObject
{
    public Visible()
    {
        super();
    }
    
    public Visible(PVector initial)
    {
        super(initial);
    }
    
    public abstract void display();
}