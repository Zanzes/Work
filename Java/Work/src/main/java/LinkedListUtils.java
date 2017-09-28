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
		if (list == null)
		{
			return;
		}
		int runs = N;
		int size = list.size();
		if (size < runs)
		{
			runs = size;
		}
		for (int i = 0; i < runs; i++)
		{
			String x = "";
			for (String string : list)
			{
				if (string.compareTo(x) > 0)
				{
					x = string;
				}
			}

			while(list.remove(x));
		}
	}

	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two)
	{
		if (one == null)
		{
			return false;
		}
		if (two == null)
		{
			return false;
		}
		int oneLen = one.size();
		int twoLen = two.size();
		if (oneLen < 1)
		{
			return false;
		}
		if (twoLen < 1)
		{
			return false;
		}
		for (int i = 0; i < oneLen; i++)
		{
			boolean same = false;
			if (two.get(0) == one.get(i))
			{
				if (oneLen - i < twoLen)
				{
					return false;
				}
				for (int j = 0; j < twoLen; j++)
				{
					if (two.get(j) == one.get(i + j))
					{
						same = true;
					}
					else
					{
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
