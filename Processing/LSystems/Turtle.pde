class Turtle extends GameObject
{
    float len;
    float angle;
    
    public Turtle(float len, float angle) { this(new PVector(),len,angle); }    
    public Turtle(PVector initial, float len, float angle)
    {
        super(initial);
        this.len = len;
        this.angle = angle;
    }
    
    void create(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            switch(s.charAt(i))
            {
                case 'F':
                case 'a':
                    paint(len);
                break;
                case 'G':
                case 'b':
                    move(len);
                break;
                case '+':
                    right(angle);
                break;
                case '-':
                    left(angle);
                break;
                case '[':
                    save();
                break;
                case ']':
                    load();
                break;
            }
        }
    }

    void changeLen(float percent)
    {
        len *= percent;
    }
    
    void display()
    {
        ellipse(0,0,r(),r());
    }
    
    void move(float d)
    {
        translate(0,-d);
    }
    
    void paint(float d)
    {
        stroke(0);
        strokeWeight(1);
        line(0,0,d,0);
        translate(d,0);
    }
    
    void left(float r)
    {
        rotate(-r);
    }
    
    void right(float r)
    {
        rotate(r);
    }
        
    void save()
    {
        pushMatrix();
    }
    
    void load()
    {
        popMatrix();
    }
}