Pendulum pendulum;
int numV = 20;
Vehicle vehicle[] = new Vehicle[numV];

public void settings()
{
    size(800,600);
}

public void setup()
{
	pendulum = new Pendulum(new PVector(width / 2,0), 300);
    for (int i = 0;i<numV;i++)
        vehicle[i] = new Vehicle(new PVector(0,height/2),random(2,16),random(0.05,1.6));    
}

public void draw(){
    background(0);
    pendulum.update();
    pendulum.display();
    PVector bob = pendulum.getBobPos();
    for (int i = 0;i<numV;i++)
    {
        vehicle[i].setTarget(bob);
        vehicle[i].update();
        vehicle[i].display();        
    }
}