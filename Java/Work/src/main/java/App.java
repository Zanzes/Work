import java.io.IOException;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class App 
{
    public static void main(String[] args) throws InterruptedException, IOException
    {
    	TreeMap<String, PriorityQueue<Integer>> map= new TreeMap<>();
    	PriorityQueue<Integer> queueA = new PriorityQueue<>();
    	PriorityQueue<Integer> queueB = new PriorityQueue<>();
    	queueA.add(1);
    	queueA.add(2);
    	queueB.add(1);
    	queueB.add(2);
    	map.put("First", queueA);
    	map.put("Second", queueB);
    	
    	TreeMap<String, Integer> ret = MovieRatingsProcessor.removeAllRatingsBelow(map, 3);
    	Set<Entry<String, Integer>> entrySet = ret.entrySet();
    	if (entrySet.size() <= 0)
		{
    		System.out.println("NONE!");			
		}
    	for (Entry<String, Integer> entry : entrySet)
		{
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
    	
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
