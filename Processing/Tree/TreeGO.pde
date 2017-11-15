class TreeGO extends GameObject
{    
    public TreeGO() { }
    
    public TreeGO(PVector initial)
    {
        super(initial);
    }
    
    public void display()
    {
        pushMatrix();
        ellipse(0,0,r(),r());
        popMatrix();
    }
    
    void buildTree()
    {
        translate(loc.x,loc.y);
        branch(200);
    }
    
    void branch(float len)
    {
        float a = map(mouseX,0,width,0,PI/2);
        stroke(0);
        line(0,0,0,-len);
        translate(0,-len);
        
        float nl = (len/4)*2;
        
        if (len > 5)
        {
            pushMatrix();
            rotate(a);
            branch(nl);
            popMatrix();
            
            pushMatrix();
            rotate(-a);
            branch(nl);
            popMatrix();
        }
        else
        {
            pushMatrix();
            noFill();
            stroke(200,0,0);
            ellipse(0,0,r(),r());
            popMatrix();
        }
    }
}