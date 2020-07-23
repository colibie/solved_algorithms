package stacks;

import java.util.Scanner;

// Describe how you could use a single array to implement three stacks.

// We can divide the array in three equal parts and allow the individual stack to grow in that limited space

class FixedMultiStack {
    private int noOfStacks = 3;
    private int stackCapacity;
    private int[] values, sizes;

    //the cosntructor
    public FixedMultiStack(int stackSize){
        //stackSize shows number of elements in each stack
        stackCapacity = stackSize;
        values = new int[stackSize * noOfStacks]; //the value of each element
        sizes = new int[noOfStacks]; //the current size of each stack
    }

    //push value onto stack
    /*throws FullStackException*/
    public void push(int stackNum, int value) throws Exception{
        // check if we have space for the el
        if (isFull(stackNum)) throw new Exception("Stack is full");
        sizes[stackNum]++; //increase size of stack
        values[indexOfTop(stackNum)] = value; //update top value;  
    }

    //pop from stack
    public int pop(int stackNum) throws Exception {
        if (isEmpty(stackNum)) throw new Exception("Stack is empty");

        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
        
    }

    // return top element
    public int peek(int stackNum) throws Exception{
        if (isEmpty(stackNum)) throw new Exception("Stack is empty");
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    private int indexOfTop(int stackNum){
        int offset = stackNum * stackCapacity; //eg 1 * 10 = 10
        int size = sizes[stackNum]; //eg sizes[1] = 3
        return offset + size - 1; //10 + 3 - 1 = 12
    }

    public void printValues(){
        for (int i : values) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int stackSize = Integer.parseInt(s.nextLine());
        FixedMultiStack stack = new FixedMultiStack(stackSize);

        while (s.hasNextLine()){
            String[] input = s.nextLine().split("\\s");
            // input has the stack num, the character pop or push or peek
            int stackNum = Integer.parseInt(input[0]);
            String action = input[1];
    

            switch(action) {
                case "pop": {
                    try {
						System.out.println(stack.pop(stackNum));
					} catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    stack.printValues();
                    break;
                }
                case "push": {
                    int value = Integer.parseInt(input[2]);
                    try {
						stack.push(stackNum, value);
					} catch (Exception e) {
						System.out.println(e.getMessage());
                    }
                    stack.printValues();
                    break;
                }
                case "peek": {
                    try {
						System.out.println(stack.peek(stackNum));
					} catch (Exception e) {
						System.out.println(e.getMessage());
                    }
                    stack.printValues();
                    break;
                }
                default: System.out.println("Pls enter a valid input: peek, pop, push");
            }
        }
        
        s.close();
    }
}