import java.util.LinkedList;

public class LinkedListUtils
{

    public static void insertSorted(LinkedList<Integer> list, int value)
    {
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) > value)
            {
                list.add(i, value);
                return;
            }
        list.addLast(value);
    }

    public static void removeMaximumValues(LinkedList<String> list, int N)
    {
    	for (int i = 0;i < N;i++)
    	{
    	String x = null;
	    	for (String string : list)
			{
				if (string.compareTo(x) > 0)
				{
					x = string;
				}
			}
    	}
    }

    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two)
    {

        return true; // this line is here only so this code will compile if you don't modify it
    }
}
