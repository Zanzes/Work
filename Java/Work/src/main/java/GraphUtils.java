
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
		int i =0;
		while (!remaining.isEmpty())
		{
			i++;
			@SuppressWarnings("unchecked")
			LinkedList<Node> level = (LinkedList<Node>) remaining.clone();
			for (Node rem : level)
			{
				remaining.remove(rem);
				visited.add(rem);
				Set<Node> nodes = targets(graph,rem);
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
		
		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it
	}
	
	public static boolean isHamiltonianPath(Graph g, List<String> values)
	{
		
		/* IMPLEMENT THIS METHOD! */
		
		return true; // this line is here only so this code will compile if you don't modify it
	}
	
}
