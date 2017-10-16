import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Analyzer
{
	public static List<Sentence> readFile(String filename)
	{
		java.util.LinkedList<Sentence> list = new java.util.LinkedList<Sentence>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			for (String line; (line = br.readLine()) != null;)
			{
				Sentence out;
				if ((out = toSentence(line)) != null)
					list.add(out);
			}
		}
		catch (Exception e)
		{
			
		}
		return list;
	}
	
	public static Sentence toSentence(String line)
	{
		if (line.length() <= 2)
			return null;
		int splitIndex = -1;
		if (line.charAt(1) == ' ' && Character.isDigit(line.charAt(0)))
			splitIndex = 1;
		else if (line.charAt(2) == ' ' && line.charAt(0) == '-' && Character.isDigit(line.charAt(1)))
			splitIndex = 2;
		if (splitIndex > 0)
		{
			String sInt = line.substring(0, splitIndex);
			String sTxt = line.substring(splitIndex + 1, line.length());
			int rInt = Integer.parseInt(sInt);
			if (3 > rInt && rInt > -3)
				return new Sentence(rInt, sTxt);
		}
		return null;
	}
	
	public static Set<Word> allWords(List<Sentence> sentences)
	{
		LinkedList<Word> list = new LinkedList<Word>();
		try
		{
			for (Sentence sentence : sentences)
			{
				if (sentence == null)
					continue;
				list.addAll(getWords(sentence));
			}
		}
		catch (Exception e)
		{}
		return new HashSet<Word>(list);
	}
	
	public static List<Word> getWords(Sentence sentence)
	{
		LinkedList<Word> list = new LinkedList<Word>();
		StringTokenizer tokenizer = new StringTokenizer(sentence.text);
		while (tokenizer.hasMoreTokens())
		{
			String tok = tokenizer.nextToken().toLowerCase();
			if (Character.isAlphabetic(tok.charAt(0)))
			{
				Word w = new Word(tok);
				if (list.indexOf(w) != -1)
				{
					w.count++;
					w.total += sentence.score;
				}
				else
				{
					w.count = 1;
					w.total = sentence.score;
					list.add(w);
				}
			}
		}
		return list;
	}
	
	public static Map<String, Double> calculateScores(Set<Word> words)
	{
		HashMap<String, Double> map = new HashMap<String, Double>();
		if (words != null && words.size() > 0)
			for (Word word : words)
				if (word != null)
					map.put(word.text, (double) word.total / word.count);
		return map;
		
	}
	
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence)
	{
		double score = 0;
		int devisor = 0;
		if (sentence != null && wordScores != null)
		{
			StringTokenizer tokenizer = new StringTokenizer(RemoveInvalid(sentence));
			devisor = tokenizer.countTokens();
			while (tokenizer.hasMoreTokens())
			{
				String token = tokenizer.nextToken();
				if (wordScores.containsKey(token))
					score += (double)wordScores.get(token) / devisor;
			}
		}
		return score;
	}
	
	static String RemoveInvalid(String input)
	{
		StringTokenizer tokenizer = new StringTokenizer(input);
		String out = "";
		while (tokenizer.hasMoreTokens())
		{
			String token = tokenizer.nextToken().toLowerCase();
			if (Character.isAlphabetic(token.charAt(0)))
				out += token + " ";
		}
		return out.trim();
	}
	
	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
