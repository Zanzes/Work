TreeGO t;
PVector Center;

void setup()
{
    size(640,480);
    t = new TreeGO(new PVector(width/2,height));
    t.r(5);
    Center = new PVector(width/2,height/2);
}

void draw()
{
    background(255);
    t.run();
    t.buildTree();
}