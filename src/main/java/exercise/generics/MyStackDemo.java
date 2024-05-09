package exercise.generics;

import java.util.Stack;

public class MyStackDemo {
    public static void main(String[] args) {
        MyStack<String> stackStr = new MyStack<>();

        System.out.println(stackStr.isEmpty());
        stackStr.push("a");
        stackStr.push("b");
        stackStr.push("c");

        System.out.println(stackStr.pop());
        System.out.println(stackStr.peek());

        System.out.println(stackStr.isEmpty());

        stackStr.printElements();

        // + int로도 가능하게
        MyStack<Integer> stackInt = new MyStack<>();

        System.out.println(stackInt.isEmpty());
        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);

        System.out.println(stackInt.pop());
        System.out.println(stackInt.peek());

        System.out.println(stackInt.isEmpty());

        stackInt.printElements();
    }
}

class MyStack<T> {
    Stack<T> myStack = new Stack<>();

    void push(T data) {
        myStack.push(data);
    }

    T pop() {
        return myStack.pop();
    }

    T peek() {
        return myStack.peek();
    }

    boolean isEmpty() {
        return myStack.empty();
    }

    void printElements() {
        System.out.println(myStack);
    }
}