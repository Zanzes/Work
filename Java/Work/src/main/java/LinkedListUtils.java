import java.util.LinkedList;

public class LinkedListUtils
{

    public static void insertSorted(LinkedList<Integer> list, int value)
    {
    	if (list == null)
		{
    		list = new LinkedList<Integer>();
    		list.add(value);
			return;
		}
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
    	for (int i = 0; i < one.size(); i++)
		{
			int a = one.get(i);
			boolean same = false;
			if (two.get(0) == a)
			{
				for (int j = 0; j < two.size(); j++)
				{
					if (two.get(j) == one.get(i+j))
					{
						same = true;
					}
					else {
						same = false;
						break;
					}
				}
				if (same)
				{
					return true;
				}
			}
		}
    	return false;
    }
}
