import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GraphUtils
{
	
	public static int minDistance(Graph graph, String src, String dest)
	{
		if (graph == null || src == null || dest == null || !graph.containsElement(src) || !graph.containsElement(dest))
			return -1;
		Node node = graph.getNode(src);
		Node target = graph.getNode(dest);
		LinkedList<Node> visited = new LinkedList<>();
		LinkedList<Node> remaining = new LinkedList<>();
		if (node == target)
			return 0;
		remaining.add(node);
		int i = 0;
		while (!remaining.isEmpty())
		{
			i++;
			@SuppressWarnings("unchecked")
			LinkedList<Node> level = (LinkedList<Node>) remaining.clone();
			for (Node rem : level)
			{
				remaining.remove(rem);
				visited.add(rem);
				Set<Node> nodes = targets(graph, rem);
				for (Node active : nodes)
				{
					if (active == target)
						return i;
					if (!visited.contains(active) && !remaining.contains(active))
						remaining.add(active);
				}
			}
		}
		return -1;
	}
	
	public static Set<Node> targets(Graph graph, Node n)
	{
		Set<Edge> eSet = graph.getNodeEdges(n);
		LinkedList<Node> nodes = new LinkedList<>();
		for (Edge edge : eSet)
			nodes.add(edge.getDestination());
		return new HashSet<Node>(nodes);
	}
	
	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance)
	{
		if (distance <= 0 || src == null || graph == null || !graph.containsElement(src))
			return null;
		
		Node node = graph.getNode(src);
		LinkedList<Node> remaining = new LinkedList<>();
		LinkedList<Node> visited = new LinkedList<>();
		remaining.add(node);
		
		while (remaining.size() > 0 && distance + 1 > 0)
		{
			LinkedList<Node> newRemaining = new LinkedList<>();
			for (Node n : remaining)
			{
				if (!visited.contains(n) && n != node)
					visited.add(n);
				for (Node node2 : targets(graph, n))
					if (!visited.contains(node2))
						newRemaining.add(node2);
			}
			remaining.addAll(newRemaining);
			distance--;
		}
		
		Set<String> set = new HashSet<String>();
		for (Node n : visited)
			set.add(n.element);
		
		return set;
	}
	
	public static boolean isHamiltonianPath(Graph g, List<String> values)
	{
		if (g == null || values == null || values.size() < 2)
			return false;
		LinkedList<Node> visited = new LinkedList<>();
		for (int i = 0; i < values.size(); i++)
		{
			Node b = g.getNode(values.get(i));
			if (b == null)
				return false;
			if (i != values.size() - 1)
			{
				if (visited.contains(b))
					return false;
			}
			else if (b != visited.getFirst())
				return false;
			if (visited.size() != 0)
			{
				Node a = visited.peekLast();
				if (!targets(g, a).contains(b))
					return false;
			}
			visited.add(b);
			
		}
		if (visited.size() != g.numNodes+1)
			return false;
		return true;
	}
}
