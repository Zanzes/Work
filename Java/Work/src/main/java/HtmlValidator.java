import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator
{
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags)
	{
		Stack<HtmlTag> stack = new Stack<HtmlTag>();
		for (HtmlTag tag : tags)
			if (!tag.isSelfClosing())
				if (stack.isEmpty())
				{
					if (!tag.isOpenTag())
						return null;
					stack.push(tag);
				}
				else if (tag.matches(stack.peek()))
					stack.pop();
				else if (tag.isOpenTag())
					stack.push(tag);
				else
				{
					for (HtmlTag htmlTag : stack)
						if (htmlTag.matches(tag))
							return stack;
					return null;
				}
		return stack;
	}
	
}
