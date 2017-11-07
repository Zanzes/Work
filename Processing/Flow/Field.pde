class Field
{
    PVector field[][];
    int col,row,colWidth,rowWidth;
    
    public Field()
    {
        colWidth = 20;
        rowWidth = 20;
        col = width / colWidth;
        row = height / rowWidth;
        field= new PVector[col][row];
        
        for(int y = 0;y < row;y++)
        {
            for(int x = 0;x < col;x++)
            {
                field[x][y] = new PVector(random(0,colWidth),random(0,rowWidth)).setMag(20);
            }
        }
    }
    
    public int getX(int x)
    {
        return x*colWidth;
    }
    public int getY(int y)
    {
        return y*rowWidth;
    }
    
    public void drawField()
    {
        for(int y = 0;y < row;y++)
        {
            for(int x = 0;x < col;x++)
            {
                PVector v = field[x][y];
                line(getX(x),getY(y),getX(x)+v.x,getY(y)+v.y);
            }
        }
    }
    
    
}