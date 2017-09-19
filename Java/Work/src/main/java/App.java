import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws InterruptedException, IOException
    {
        LinkedList list = new LinkedList();

        list.AddToBack(4);
        list.AddToFront(3);
        list.AddToFront(2);
        list.AddToFront(1);
        list.AddToBack(5);

        PrintList(list);
        br();

        list.Clear();

        list.AddToFront(4);
        list.AddToFront(2);
        list.InsertAt(1,0);
        list.InsertAt(3,2);
        list.InsertAt(5,4);

        PrintList(list);
        br();

        list.RemoveAt(3);

        PrintList(list);
        br();

        System.out.println(list.ValueAt(2));
        br();
        
        java.util.LinkedList<Integer> list2 = new java.util.LinkedList<Integer>();

        list2.add(1);
        list2.add(2);
        list2.add(4);

        PrintList(list2);
        br();
        
        
        PrintList(list2);        
        br();
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
