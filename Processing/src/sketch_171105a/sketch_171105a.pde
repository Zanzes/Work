Field f;
Driver v;

void setup()
{
    size(800,600);
    background(255);
    f =new Field(width,height,20);
    v = new Driver(new PVector(width/2,height/2));
}

void draw()
{
    v.update();
    v.display();
    v.applyForce(f.getForce(v.pos.x,v.pos.y));
}