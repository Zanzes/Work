import java.io.IOException;

public class App 
{
    public static void main(String[] args) throws InterruptedException, IOException
    {
    	Graph graph =new DirectedGraph();
    	Node newNode = new Node("first");
		graph.addNode(newNode);
    	Node newNode2 = new Node("second");
		graph.addNode(newNode2);
    	Node newNode3 = new Node("third");
		graph.addNode(newNode3);
    	Node newNode4 = new Node("fourth");
		graph.addNode(newNode4);
    	Node newNode5 = new Node("fifth");
		graph.addNode(newNode5);
    	Node newNode6 = new Node("sixth");
		graph.addNode(newNode6);
		graph.addEdgeFromTo(newNode, newNode2);
		graph.addEdgeFromTo(newNode2, newNode3);
		graph.addEdgeFromTo(newNode3, newNode4);
		graph.addEdgeFromTo(newNode4, newNode5);
		graph.addEdgeFromTo(newNode3, newNode5);
		graph.addEdgeFromTo(newNode, newNode6);
		graph.addEdgeFromTo(newNode6, newNode5);
		System.out.println(GraphUtils.minDistance(graph, newNode.element, newNode5.element));
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
