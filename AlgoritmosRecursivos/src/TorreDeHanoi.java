import java.util.ArrayDeque;
import java.util.Deque;

class Tower {
	private String name; 
	private Deque<Integer> stack = new ArrayDeque<>();
	public Tower(String name) {
		this.name = name; 
	}
	public int remove() {
		return stack.pop();
	}
	public void put(int x) {
		if (!stack.isEmpty() && x >= stack.peek())
			throw new IllegalStateException("Disco maior em cima do menor. " + name + ": " + x + " - " + stack.peek());
		stack.push(x);
	}
	public int size() {
		return stack.size();
	}
	public String toString() {
		return name;
	}
}

public class TorreDeHanoi {

	public static void main(String[] args) {
		hanoi(5);
	}

	private static void hanoi(int count) {
		Tower A = new Tower("A");
		Tower B = new Tower("B");
		Tower C = new Tower("C");
		
		for (int i = count; i > 0; i--)
			A.put(i);
		
		hanoi_move(count, A, B, C);
	}
	
	private static void hanoi_move(int count, Tower a, Tower b, Tower c)
	{
		if (count > 1) {
			hanoi_move(count - 1, a, c, b);
			move(a,c);
			hanoi_move(count - 1, b, a, c);
		} else {
			move(a,c);
		}
	}

	private static void move(Tower a, Tower c) {
		int v = a.remove();
		c.put(v);
		System.out.println("Movendo " + v + " de " + a + " para " + c);
	}

}
