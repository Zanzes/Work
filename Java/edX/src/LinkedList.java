public class LinkedList
{
	public Node	head;
	public Node	tail;
	
	private int count = 0;
	
	public void RemoveAt(int index)
	{
		if (index == 0)
		{
			head = head.next;
			count--;
			return;
		}
		Node c = head;
		for (int i = 0; i < index - 1; i++)
		{
			c = c.next;
		}
		c.next = c.next.next;
		count--;
	}
	
	public void RemoveFirst()
	{
		head = head.next;
		count--;
	}
	
	public void RemoveLast()
	{
		Node node = head;
		while (node.next != tail)
			node = node.next;
		tail = node;
		tail.next = null;
		count--;
	}
	
	public int IndexOf(int value)
	{
		Node c = head;
		int index = 0;
		
		do
		{
			if (c.value == value)
				return index;
			c = c.next;
			index++;
		} while (c != null);
		
		return -1;
	}
	
	public boolean contains(int value)
	{
		Node c = head;
		
		do
		{
			if (c.value == value)
				return true;
			c = c.next;
		} while (c != null);
		
		return false;
	}
	
	public int ValueAt(int index)
	{
		if (index < 0)
			throw new IndexOutOfBoundsException();
		Node node = head;
		
		for (int i = 0; i < index; i++)
		{
			node = node.next;
			if (node == null)
				throw new IndexOutOfBoundsException();
		}
		return node.value;
		
	}
	
	public void InsertAt(int value, int index)
	{
		Node c = head, n = new Node(value);
		
		if (index == 0)
		{
			AddToFront(value);
			return;
		}
		
		for (int i = 0; i < index - 1; i++)
		{
			c = c.next;
		}
		
		n.next = c.next;
		c.next = n;
		count++;
	}
	
	public void Clear()
	{
		count = 0;
		head = null;
		tail = null;
	}
	
	public void AddToBack(int value)
	{
		Node n = new Node(value);
		
		if (tail == null)
		{
			head = n;
			tail = n;
			count++;
			return;
		}
		
		tail.next = n;
		tail = n;
		count++;
	}
	
	
	public void AddToFront(int value)
	{
		Node n = new Node(value);
		
		if (head == null)
		{
			head = n;
			tail = n;
			count++;
			return;
		}
		
		n.next = head;
		head = n;
		count++;
	}
	
	public int getCount()
	{
		return count;
	}
	
	class Node
	{
		public int	value;
		public Node	next;
		
		public Node(int value)
		{
			this.value = value;
		}
	}


}
