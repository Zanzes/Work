Driver d;
Field f = new Field();

void settings()
{
   size(1000,600); 
}

void setup()
{
    d = new Driver(new PVector(width/2,height/2));
    d.width = 10;
    d.height = 30;
}

void draw()
{
    MouseData();
    background(255);
    
    d.update();
    d.seek(mPos);
    d.display();
    if(mouseButton == RIGHT)
    {
        d.applyForce(new PVector(1,1).normalize());
    }
    f.drawField();
}