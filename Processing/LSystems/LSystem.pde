class LSystem extends GameObject
{
    String generation;
    HashMap<Character, String> LSystemRules = new HashMap<Character, String>();
    
    public LSystem(String genX)
    {
        this(new PVector(),genX);
    }    
    public LSystem(PVector initial,String genX)
    {
        super(initial);
        generation = genX;
    }
    
    void display()
    {
    }
    
    void nextGen()
    {
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < generation.length();i++)
        {
            Character  ch = generation.charAt(i);
            sb.append(LSystemRules.getOrDefault(ch,ch.toString()));
        }
        generation = sb.toString();
    }
}