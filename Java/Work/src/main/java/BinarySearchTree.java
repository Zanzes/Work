public class BinarySearchTree<E extends Comparable<E>>
{
	class Node
	{
		E		value;
		Node	leftChild	= null;
		Node	rightChild	= null;
		
		Node(E value) {
			this.value = value;
		}
		
		@Override
		public boolean equals(Object obj)
		{
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			@SuppressWarnings("unchecked")
			Node other = obj instanceof BinarySearchTree.Node ? (BinarySearchTree<E>.Node) obj : null;
			return other.value.compareTo(value) == 0 && other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}
	
	protected Node root = null;
	
	protected void visit(Node n)
	{
		System.out.println(n.value);
	}
	
	public boolean contains(E val)
	{
		return contains(root, val);
	}
	
	protected boolean contains(Node n, E val)
	{
		if (n == null)
			return false;
		
		if (n.value.equals(val))
		{
			return true;
		}
		else if (n.value.compareTo(val) > 0)
		{
			return contains(n.leftChild, val);
		}
		else
		{
			return contains(n.rightChild, val);
		}
	}
	
	public boolean add(E val)
	{
		if (root == null)
		{
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}
	
	protected boolean add(Node n, E val)
	{
		if (n == null)
		{
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0)
		{
			return false; // this ensures that the same value does not appear more than once
		}
		else if (cmp < 0)
		{
			if (n.leftChild == null)
			{
				n.leftChild = new Node(val);
				return true;
			}
			else
			{
				return add(n.leftChild, val);
			}
		}
		else
		{
			if (n.rightChild == null)
			{
				n.rightChild = new Node(val);
				return true;
			}
			else
			{
				return add(n.rightChild, val);
			}
		}
	}
	
	public boolean remove(E val)
	{
		return remove(root, null, val);
	}
	
	protected boolean remove(Node n, Node parent, E val)
	{
		if (n == null)
			return false;
		
		if (val.compareTo(n.value) == -1)
		{
			return remove(n.leftChild, n, val);
		}
		else if (val.compareTo(n.value) == 1)
		{
			return remove(n.rightChild, n, val);
		}
		else
		{
			if (n.leftChild != null && n.rightChild != null)
			{
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			}
			else if (parent == null)
			{
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			else if (parent.leftChild == n)
			{
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			else
			{
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}
	
	protected E maxValue(Node n)
	{
		if (n.rightChild == null)
		{
			return n.value;
		}
		else
		{
			return maxValue(n.rightChild);
		}
	}
	
	public Node findNode(E val)
	{
		if (val != null)
			return findNode(val, root);
		return null;
	}
	
	public Node findNode(E val, Node relativeRoot)
	{
		if (relativeRoot.value == val)
			return relativeRoot;
		
		if (relativeRoot.value.compareTo(val) < 0)
			if (relativeRoot.rightChild != null)
				return findNode(val, relativeRoot.rightChild);
			
		if (relativeRoot.value.compareTo(val) > 0)
			if (relativeRoot.leftChild != null)
				return findNode(val, relativeRoot.leftChild);
			
		return null;
	}
	
	protected int depth(E val)
	{
		return depth(val, root, 0);
	}
	
	protected int depth(E val, Node n, int d)
	{
		if (val != null)
		{
			if (n.value == val)
				return d;
			else
			{
				d++;
				if (n.value.compareTo(val) < 0)
				{
					if (n.rightChild != null)
						return depth(val, n.rightChild, d);
				}
				else if (n.leftChild != null)
					return depth(val, n.leftChild, d);
			}
		}
		return -1;
	}
	
	protected int height(E val)
	{
		Node node = findNode(val);
		if (node == null)
			return -1;
		return height(node);
	}
	
	protected int height(Node n)
	{
		if (n.value == null)
			return -1;
		
		int l = n.leftChild != null ? height(n.leftChild) : -1;
		int r = n.rightChild != null ? height(n.rightChild) : -1;
		int th = l > r ? l : r;
		th++;
		return th;
	}
	
	protected boolean isBalanced(Node n)
	{
		if (n == null || findNode(n.value) == null)
			return false;
		
		int l = n.leftChild != null ? height(n.leftChild) : 0;
		int r = n.rightChild != null ? height(n.rightChild) : 0;
		int d = l - r;
		if (d < 0)
			d = -d;
		if (d < 2)
			return true;
		
		return false;
	}
	
	public boolean isBalanced()
	{
		return isBalancedLoop(root);
	}
	
	public boolean isBalancedLoop(Node n)
	{
		if (isBalanced(n))
		{
			boolean l = true, r = true;
			if (n.leftChild != null)
				l = isBalancedLoop(n.leftChild);
			
			if (n.rightChild != null)
				r = isBalancedLoop(n.rightChild);
			if (r && l)
			{
				return true;
			}
		}
		return false;
		
	}
	
}
