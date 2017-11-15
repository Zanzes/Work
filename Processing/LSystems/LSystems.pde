LSystem ls;
Turtle t;
PVector Center;
PVector BottomCenter;
int mode=1; // 1 -> Tree, 2 -> Squares, 3 -> Triangles, 4 -> Inside, 5 -> RT

void setup()
{    
    size(800,800);
    background(255);
    Center = new PVector(width/2,height/2);
    BottomCenter = new PVector(width/2,height);
    ls = new LSystem(BottomCenter,"F");
    ls.r(5);
    
    switch (mode)
    {
        case 1:
            TreeA();
        break;
        case 2:
            SquaresA();
        break;
        case 3:
            TrianglesA();
        break;
        case 4:
            InsideA();
        break;
        case 5:
            RTA();
        break;
    }
}

void draw()
{
    background(255);
    
    switch (mode)
    {
        case 1:
            TreeB();
        break;
        case 2:
            SquaresB();
        break;
        case 3:
            TrianglesB();
        break;
        case 4:
            InsideB();
        break;
        case 5:
            RTB();
        break;
    }
}

void mousePressed()
{
    if(mouseButton != RIGHT)
        println(ls.generation);
    else
    {
        ls.nextGen();
        t.changeLen(0.5);
    }
    redraw();
}

void TreeA()
{
    t = new Turtle(height*.3, radians(25));
    t.r(5);
    ls.LSystemRules.put('F', "FF+[+F-F-F]-[-F+F+F]");
}

void TreeB()
{
    translate(width/2,  height);
    rotate(-PI/2);
    t.create(ls.generation);
}

void SquaresA()
{
    ls.LSystemRules.put('F', "F-F+F+F-F");
    t = new Turtle(height/6, radians(90));
    t.r(5);
}

void SquaresB()
{
    translate(0, height*.9); 
    t.create(ls.generation);
}

void TrianglesA()
{
    ls.LSystemRules.put('F', "F-F+F+F-F");
    t = new Turtle(width*.8, radians(120));
    t.r(5);
}

void TrianglesB()
{
    translate(width*.1, height*0.95);
    t.create(ls.generation);
}

void InsideA()
{
    ls = new LSystem(BottomCenter,"F-F-F-F");
    t = new Turtle(width*.1, PI/2);
    t.r(5);
    ls.LSystemRules.put('F', "F[F]-F+F[--F]+F-F");
}

void InsideB()
{
    translate(0,  height);
    t.create(ls.generation);
}

void RTA()
{
    ls = new LSystem(BottomCenter,"F--F--F");
    t = new Turtle(width*2, PI/3);
    t.r(5);
    ls.LSystemRules.put('F',"F--F--F--G");
    ls.LSystemRules.put('G',"GG");
}
void RTB()
{
    translate(width*.8,  height);
    t.create(ls.generation);
}