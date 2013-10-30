public class TestBench_2_4 {
	public static int[] fullAdder (int op1, int op2, int carryIn) {
			// same as a fullAdder in IC
			// input op1 op2 carryIn
			// output carryOut sum
		int result = op1 + op2 + carryIn;	
		int sum = result % 10;
		int carryOut = result / 10;
		int[] output = new int[] {carryOut, sum};
		return output;
	}
	
	public static MyNode add(MyNode op1, MyNode op2) {
		if ((op1 == null) && (op2 == null)) return new MyNode(0);	// null + null = 0
		
		MyNode op1Bit = op1, op2Bit = op2, sumHead = null;	
			// initialize ptr refer to current digiit in op1/2
			// sumHead is the head to sum list
		int[] sumCarry = new int[] {0, 0};  // sC[0] -> carry sC[1] -> sum
			// initialize 1-bit sum carry
			// carryIn from previous bit addition would be remembered & used here
		
			// At least 1 non-null op reach here
			// Initialize sumHead
		if (op1Bit == null) {
			sumHead = new MyNode(op2Bit.getValue());	// null + num = num
			op2Bit = op2Bit.getNext();
		} else if (op2Bit == null) {					// num + null = num
			sumHead = new MyNode(op1Bit.getValue());
			op1Bit = op1Bit.getNext();
		} else {										// num + num = sum
			sumCarry = TestBench_2_4.fullAdder(op1Bit.getValue(), op2Bit.getValue(), sumCarry[0]);
			sumHead = new MyNode(sumCarry[1]);
			op1Bit = op1Bit.getNext();
			op2Bit = op2Bit.getNext();
		}		
		
		while ((op1Bit != null) && (op2Bit != null)) {	// num + num until one op is used up
			sumCarry = TestBench_2_4.fullAdder(op1Bit.getValue(), op2Bit.getValue(), sumCarry[0]);
			sumHead = sumHead.appendHead(sumCarry[1]);	// remember to refresh head!!! Otherwise keep refreshing the node before head.
			op1Bit = op1Bit.getNext();
			op2Bit = op2Bit.getNext();
		}
		
			// At least 1 null op reach here
		if (op1Bit != null) {	// if find 1 non-null op, remember it as op2
			op2Bit = op1Bit;
		}
		while (op2Bit != null) {	// if 1 non-null op
			sumCarry = TestBench_2_4.fullAdder(0, op2Bit.getValue(), sumCarry[0]);
			sumHead = sumHead.appendHead(sumCarry[1]);
			op2Bit = op2Bit.getNext();
		}
		
		return sumHead;
	}
	
	public static void main (String[] args) {
		int[] num1 = new int[] {1, 2, 3, 4};
		int[] num2 = new int[] {9, 9, 1};
		int[] num3 = null;
		MyNode op1 = TestBench_2_2.createTestList(num1);
		MyNode op2 = TestBench_2_2.createTestList(num2);
		MyNode op3 = TestBench_2_2.createTestList(num3);
		
		System.out.printf("\nop1 + op2 = ");
		MyNode sum12 = TestBench_2_4.add(op1, op2);
		sum12.printList();
		System.out.printf("\nop2 + op2 = ");
		MyNode sum22 = TestBench_2_4.add(op2, op2);
		sum22.printList();
		System.out.printf("\nop3 + op2 = ");
		MyNode sum32 = TestBench_2_4.add(op3, op2);
		sum32.printList();
		System.out.printf("\nop3 + op3 = ");
		MyNode sum33 = TestBench_2_4.add(op3, op3);
		sum33.printList();
	}
}
