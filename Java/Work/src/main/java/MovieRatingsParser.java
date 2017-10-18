
/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser
{
	
	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings)
	{
		TreeMap<String, PriorityQueue<Integer>> map = new TreeMap<>();
		try
		{
			for (UserMovieRating userMovieRating : allUsersRatings)
			{
				if (userMovieRating.movie.length() > 0)
				{
					userMovieRating.movie = userMovieRating.movie.toLowerCase();
					if (userMovieRating.userRating >= 0)
					{
						if (map.containsKey(userMovieRating.movie))
							map.get(userMovieRating.movie).add(userMovieRating.userRating);
						else
						{
							PriorityQueue<Integer> queue = new PriorityQueue<>();
							queue.add(userMovieRating.userRating);
							map.put(userMovieRating.movie, queue);
						}
					}
				}
			}
		}
		catch (Exception e)
		{}
		return map;
	}
	
}
