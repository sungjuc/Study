package lec.l20;

public class LLStackTest {
	public static void main(String[] args) {
		LLStack<String> stack = new LLStack<String>();
		stack.push("one");
		stack.push("two");
		stack.push("three");
		System.out.println(LLStackUtils.size(stack));
		System.out.println(LLStackUtils.sizeRecursive(stack));
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}