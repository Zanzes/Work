class Field
{
    PVector[][] field;
    int cols,rows,size,size_H;
    
    public Field(int w,int h,int s)
    {
        size = s;
        size_H = size / 2;
        cols = w/size;
        rows = h/size;
        
        field = new PVector[cols][rows];
        
        ellipseMode(RADIUS);
        
        for(int y = 0;y < rows;y++)
        {
            for(int x = 0;x < cols;x++)
            {
                noStroke();
                int a = toPixA(x);
                int b = toPixA(y);
                PVector r = PVector.random2D().setMag(size_H);
                stroke(0);
                line(a-r.x,b-r.y,a+r.x,b+r.y);
                field[x][y]=r;
            }
        }
    }
    
    int toPix(int x)
    {
        return size*x;
    }
    
    int toPixA(int x)
    {
        return (size*(x-1))+size_H;
    }
    
    PVector getForce(float x,float y)
    {
        return field[int(x)/size][int(y)/size];
    }
}