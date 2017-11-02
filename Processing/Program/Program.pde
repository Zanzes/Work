Pendulum pendulum;
Vehicle vehicle;

public void settings()
{
    size(800,600);
}

public void setup()
{
	pendulum = new Pendulum(new PVector(width / 2,0), 150);
    vehicle = new Vehicle(new PVector(0,height/2));
}

public void draw(){
    background(0);
    pendulum.update();
    pendulum.display();
    PVector bob = pendulum.getBobPos();
    vehicle.setTarget(bob);
    vehicle.update();
    vehicle.display();
}