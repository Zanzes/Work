import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class MovieRatingsProcessor
{
	
	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings)
	{
		return getAlphabeticalMoviesAboveRating(movieRatings, Integer.MIN_VALUE);
	}
	
	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating)
	{
		
		ArrayList<String> strings = new ArrayList<String>();
		try
		{
			Set<java.util.Map.Entry<String, PriorityQueue<Integer>>> entrySet = movieRatings.entrySet();
			for (java.util.Map.Entry<String, PriorityQueue<Integer>> entry : entrySet)
				if (entry.getValue().peek() > rating)
					strings.add(entry.getKey());
		}
		catch (Exception e)
		{}
		return strings;
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating)
	{
		TreeMap<String, Integer> map = new TreeMap<>();
		try
		{
			Set<java.util.Map.Entry<String, PriorityQueue<Integer>>> entrySet = movieRatings.entrySet();
			for (java.util.Map.Entry<String, PriorityQueue<Integer>> entry : entrySet)
			{
				if (entry.getValue().peek() < rating)
				{
					int i = 0;
					while (entry.getValue().peek() < rating)
					{
						entry.getValue().remove();
						i++;
					}
						map.put(entry.getKey(), i);
				}
			}
		}
		catch (Exception e)
		{}
		return map;
	}
}
