public class Main
{

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        list.AddToBack(4);
        list.AddToFront(3);
        list.AddToFront(2);
        list.AddToFront(1);
        list.AddToBack(5);

        PrintList(list);

        list.Clear();

        list.AddToFront(4);
        list.AddToFront(2);
        list.InsertAt(1,0);
        list.InsertAt(3,2);
        list.InsertAt(5,4);

        PrintList(list);

        list.RemoveAt(3);

        PrintList(list);

        System.out.println();
        System.out.println(list.ValueAt(7));
    }

    public static void PrintList(LinkedList list)
    {

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
}
