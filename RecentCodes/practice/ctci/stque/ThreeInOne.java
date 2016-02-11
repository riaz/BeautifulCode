package practice.ctci.stque;

public class ThreeInOne {
	// Program to implement three stacks using a single array
	int masterArr[];
	St1 st1;
	St2 st2;
	St3 st3;

	ThreeInOne(int n) { // enter the size of each stack
		masterArr = new int[n * 3];
		st1 = new St1();
		st2 = new St2();
		st3 = new St3();
	}

	class St1 {
		int top = 0;

		public void push(int data) {
			masterArr[top] = data;
			top += 3;
		}

		public int pop() {
			if (top == 0)
				return -1; // fail condition
			else {
				int data = masterArr[top - 3];
				this.top = this.top - 3;
				return data;
			}
		}
	}

	class St2 {
		int top = 1;

		public void push(int data) {
			masterArr[top] = data;
			top += 3;
		}

		public int pop() {
			if (top == 1)
				return -1; // fail condition
			else {
				int data = masterArr[top - 3];
				top -= 3;
				return data;
			}
		}
	}

	class St3 {
		int top = 2;

		public void push(int data) {
			masterArr[top] = data;
			top += 3;
		}

		public int pop() {
			if (top == -1)
				return -1; // fail condition
			else {
				int data = masterArr[top - 3];
				top -= 3;
				return data;
			}
		}
	}

	public static void main(String[] args) {
		ThreeInOne stack = new ThreeInOne(10);

		// Output: 30 20 50 40 10
		stack.st1.push(10);
		stack.st1.push(20);
		stack.st1.push(30);
		System.out.print(stack.st1.pop() + " ");
		System.out.print(stack.st1.pop() + " ");
		stack.st1.push(40);
		stack.st1.push(50);
		System.out.print(stack.st1.pop() + " ");
		System.out.print(stack.st1.pop() + " ");
		System.out.print(stack.st1.pop() + " ");

		System.out.println();
		
		// Output: 31 21 51 41 11
		stack.st2.push(11);
		stack.st2.push(21);
		stack.st2.push(31);
		System.out.print(stack.st2.pop() + " ");
		System.out.print(stack.st2.pop() + " ");
		stack.st2.push(41);
		stack.st2.push(51);
		System.out.print(stack.st2.pop() + " ");
		System.out.print(stack.st2.pop() + " ");
		System.out.print(stack.st2.pop() + " ");

		System.out.println();
		
		// Output: 32 22 52 42 12
		stack.st3.push(12);
		stack.st3.push(22);
		stack.st3.push(32);
		System.out.print(stack.st3.pop() + " ");
		System.out.print(stack.st3.pop() + " ");
		stack.st3.push(42);
		stack.st3.push(52);
		System.out.print(stack.st3.pop() + " ");
		System.out.print(stack.st3.pop() + " ");
		System.out.print(stack.st3.pop() + " ");

		System.out.println();

		
	}

}
