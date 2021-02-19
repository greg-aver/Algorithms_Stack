package org.gregory.linkedList;

import java.util.LinkedList;

public class Stack<T> {
    LinkedList<T> list;

    public Stack() {
        list = new LinkedList<T>();
    }

    public int size() {
        if (this.peek() == null) {
            return 0;
        }
        return list.size();
    }

    public T pop() {
        if (this.peek() == null) {
            return null;
        }
        return list.pop();
    }

    public void push(T val) {
        list.addFirst(val);
    }

    public T peek() {
        return list.peekFirst();
    }

    public Integer postfix() {
        Stack<Integer> operation = new Stack<Integer>();
        while (this.size() != 0) {
            String value = String.valueOf(this.pop());

            switch (value) {
                case ("*"):
                    operation.push(
                            operation.pop() * operation.pop()
                    );
                    break;
                case ("-"):
                    operation.push(
                             - operation.pop() + operation.pop()
                    );
                    break;
                case ("+"):
                    operation.push(
                        operation.pop() + operation.pop()
                    );
                    break;
                case ("="):
                    return operation.pop();
                default:
                    operation.push(Integer.valueOf(value));
                    break;
            }
        }

        return operation.pop();
    }

    public static boolean brackets(String str) {
        if (str.isEmpty()) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char symbol;
        for (int i=0; i < str.length(); i++) {
            symbol = str.charAt(i);
            if (symbol == '(') {
                stack.push(symbol);
            } else {
                if (stack.peek() == null) {
                    return false;
                }
                stack.pop();
            }
        }

        if (stack.size() == 0) {
            return true;
        }

        return false;
    }
}
