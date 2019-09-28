package proyecto.inteligentes;

public class Cube {
	private char[][] back;
	private char[][] down;
	private char[][] front;
	private char[][] left;
	private char[][] right;
	private char[][] up;

	public Cube() {

	}

	public Cube(char[][] back, char[][] down, char[][] front, char[][] left, char[][] right, char[][] up) {
		super();
		this.back = back;
		this.down = down;
		this.front = front;
		this.left = left;
		this.right = right;
		this.up = up;
	}

	public char[][] getBack() {
		return back;
	}

	public void setBack(char[][] back) {
		this.back = back;
	}

	public char[][] getDown() {
		return down;
	}

	public void setDown(char[][] down) {
		this.down = down;
	}

	public char[][] getFront() {
		return front;
	}

	public void setFront(char[][] front) {
		this.front = front;
	}

	public char[][] getLeft() {
		return left;
	}

	public void setLeft(char[][] left) {
		this.left = left;
	}

	public char[][] getRight() {
		return right;
	}

	public void setRight(char[][] right) {
		this.right = right;
	}

	public char[][] getUp() {
		return up;
	}

	public void setUp(char[][] up) {
		this.up = up;
	}

}
