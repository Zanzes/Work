PVector mPos;

public void MouseData()
{
    mPos = new PVector(mouseX,mouseY);
}

public void write(Object data)
{
    if (data instanceof String)
        System.out.println(data);
    else
        System.out.println(data.toString());
}