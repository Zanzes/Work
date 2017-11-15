import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataTier {
	
	private String fileName;
	
	public DataTier(String inputSource) {
		fileName = inputSource;
	}
	
	public List<Book> getAllBooks()
	{
		java.util.LinkedList<Book> list = new java.util.LinkedList<Book>();
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new FileReader( fileName));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		if (reader != null)
		{
			String line;
			try
			{
				while ((line = reader.readLine()) != null)
				{
					String[] sp= line.split("\t");					
					list.add(new Book(sp[0], sp[1], Integer.parseInt(sp[2])));
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	
		return list;
	}
}
