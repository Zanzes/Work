import java.io.IOException;

public class App 
{
    public static void main(String[] args) throws InterruptedException, IOException
    {
    	String[] arg = new String[1];
    	arg[0] = "books.txt";
    	Main.main(arg);
    }
    
    static void br()
    {
    	System.out.println();
    }

    public static void PrintList(LinkedList list) throws InterruptedException, IOException
    {
    	PrintList(list, true);
    }
    
    public static void PrintList(LinkedList list,boolean clear) throws InterruptedException, IOException
    {
    	if (clear)
		{
		}
        LinkedList.Node n = list.head;
        int index=0;

        System.out.println("Head: " + list.head.value);
        System.out.println();

        do
        {
            System.out.println(n.value + " at index " + index++);
            n = n.next;
        } while (n != null);

        System.out.println();
        System.out.println("Tail: " + list.tail.value);
        System.out.println();
        System.out.println("Count : " + list.getCount());

    }
    
    public static void PrintList(java.util.LinkedList<Integer> list)
    {
        System.out.println("Head: " + list.getFirst());
        System.out.println();

        int length = list.size();
        
		for (int i = 0; i < length; i++)
		{
			int value = list.get(i);
            System.out.println(value + " at index " + i);
		}

        System.out.println();
        System.out.println("Tail: " + list.getLast());
        System.out.println();
        System.out.println("Count : " + length);

    }
}
