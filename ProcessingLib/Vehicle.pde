class VehicleGO extends GameObject
{
    float maxforce;
    float maxspeed;

    VehicleGO( PVector l, float ms, float mf)
    {
        super(l.copy());
        r(12);
        maxspeed = ms;
        maxforce = mf;
        acc = new PVector(0, 0);
        vel = new PVector(maxspeed, 0);
    }
    
    public void run()
    {
        update();
        borders();
        display();
    }
    
    PVector getNormalPoint(PVector p, PVector a, PVector b)
    {
        PVector ap = PVector.sub(p, a);
        PVector ab = PVector.sub(b, a);
        ab.normalize();
        ab.mult(ap.dot(ab));
        PVector normalPoint = PVector.add(a, ab);
        return normalPoint;
    }
    
    PVector separate (ArrayList boids)
    {
        float desiredseparation = r()*2;
        PVector steer = new PVector(0, 0, 0);
        int count = 0;
        for (int i = 0 ; i < boids.size(); i++)
        {
            VehicleGO other = (VehicleGO) boids.get(i);
            float d = PVector.dist(loc, other.loc);
            if ((d > 0) && (d < desiredseparation))
            {
                PVector diff = PVector.sub(loc, other.loc);
                diff.normalize();
                diff.div(d);
                steer.add(diff);
                count++;
            }
        }
        if (count > 0)
        {
            steer.div((float)count);
        }
        
        if (steer.mag() > 0)
        {
          steer.normalize();
          steer.mult(maxspeed);
          steer.sub(vel);
          steer.limit(maxforce);
        }
        return steer;
    }
    
    void update()
    {
        vel.add(acc);
        vel.limit(maxspeed);
        loc.add(vel);
        acc.mult(0);
    }
  
    PVector seek(PVector target)
    {
        PVector desired = PVector.sub(target, loc);        
        desired.normalize();
        desired.mult(maxspeed);
        PVector steer = PVector.sub(desired, vel);
        steer.limit(maxforce);
        return steer;
    }
    
    void arrive(PVector target)
    {
        PVector desired = PVector.sub(target,loc);
        float d = desired.mag();
        
        if (d < 100) {
          float m = map(d,0,100,0,maxspeed);
          desired.setMag(m);
        } else {
          desired.setMag(maxspeed);
        }
        
        PVector steer = PVector.sub(desired,vel);
        steer.limit(maxforce);
        applyForce(steer);
    }

    void display()
    {
        fill(75);
        stroke(0);
        pushMatrix();
        translate(loc.x, loc.y);
        ellipse(0, 0, r(), r());
        popMatrix();
    }
    
    void borders()
    {
        if (loc.x < -r()) loc.x = width+r();
        if (loc.x > width+r()) loc.x = -r();
    }
}