package lec.l20;

public class LLStackUtils {
	public static int size(Stack<String> s){
		int count = 0;

		LLStack<String> temp = new LLStack<String>();

		while(!s.isEmpty()) {
			temp.push(s.pop());
			count++;
		}

		while(!temp.isEmpty()) {
			s.push(temp.pop());
		}

		return count;
	}

	public static int sizeRecursive(Stack<String> s) {
		if(s.isEmpty())
			return 0;
		else {
			String x = s.pop();
			int n = sizeRecursive(s);
			s.push(x);
			return n + 1;
		}
	}
}