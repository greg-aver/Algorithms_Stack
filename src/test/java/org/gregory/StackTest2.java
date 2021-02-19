package org.gregory;

import org.gregory.linkedList.Stack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.gregory.linkedList.Stack.brackets;

class StackTest2 {
    Stack stackString;
    Stack stackDouble;
    Stack stackStringEmpty;
    Stack stackDoubleEmpty;


    @BeforeEach
    void setUp() {
        stackDouble = new Stack<Double>();
        stackDouble.push(1.1);
        stackDouble.push(2.2);
        stackDouble.push(3.3);
        stackDouble.push(4.4);
        stackDouble.push(5.5);

        stackString = new Stack<String>();

        stackString.push("1");
        stackString.push("2");
        stackString.push("3");
        stackString.push("4");
        stackString.push("5");

        stackDoubleEmpty = new Stack<Double>();
        stackStringEmpty = new Stack<String>();
    }

    @AfterEach
    void tearDown() {
        stackString = null;
        stackDouble = null;
        stackStringEmpty = null;
        stackDoubleEmpty = null;
    }

    @Test
    void size() {
        assertThat(stackDouble.size(), is(5));
        assertThat(stackString.size(), is(5));
    }

    @Test
    void pop() {
        assertThat(stackDoubleEmpty.size(), is(0));
        assertThat(stackDoubleEmpty.peek(), nullValue());
        assertThat(stackDoubleEmpty.pop(), nullValue());

        assertThat(stackDouble.pop(), is(5.5));
        assertThat(stackDouble.pop(), is(4.4));
        assertThat(stackDouble.pop(), is(3.3));
        assertThat(stackDouble.size(), is(2));
        assertThat(stackDouble.pop(), is(2.2));
        assertThat(stackDouble.pop(), is(1.1));
        assertThat(stackDouble.pop(), nullValue());
        assertThat(stackDouble.size(), is(0));
        assertThat(stackDouble.size(), is(stackDoubleEmpty.size()));

        assertThat(stackString.pop(), is("5"));
        assertThat(stackString.pop(), is("4"));
        assertThat(stackString.pop(), is("3"));
        assertThat(stackString.size(), is(2));
        assertThat(stackString.pop(), is("2"));
        assertThat(stackString.pop(), is("1"));
        assertThat(stackString.size(), is(0));
        assertThat(stackString.pop(), nullValue());

        assertThat(stackString.size(), is(stackStringEmpty.size()));
    }

    @Test
    void peek() {
        assertThat(stackDoubleEmpty.peek(), nullValue());
        assertThat(stackDouble.peek(), is(5.5));
        assertThat(stackDouble.size(), is(5));
        assertThat(stackString.peek(), is("5"));
        assertThat(stackString.size(), is(5));
    }

    @Test
    void getTop() {
        assertThat(stackDouble.peek(), is(5.5));
        assertThat(stackString.peek(), is("5"));
    }

    @Test
    void postfixExpression() {

        Stack<String> stackActual = new Stack<>();
        stackActual.postfix();
        stackActual.push("=");
        stackActual.push("+");
        stackActual.push("9");
        stackActual.push("*");
        stackActual.push("5");
        stackActual.push("+");
        stackActual.push("2");
        stackActual.push("8");

        assertThat(stackActual.postfix(), is(59));
    }

    @Test
    void postfixSum4() {

        Stack<String> stackActual = new Stack<>();
        stackActual.postfix();
        stackActual.push("=");
        stackActual.push("+");
        stackActual.push("+");
        stackActual.push("1");
        stackActual.push("5");
        stackActual.push("7");

        assertThat(stackActual.postfix(), is(13));
    }

    @Test
    void postfixSubtract() {

        Stack<String> stackActual = new Stack<>();
        stackActual.postfix();
        stackActual.push("=");
        stackActual.push("-");
        stackActual.push("3");
        stackActual.push("-");
        stackActual.push("5");
        stackActual.push("100");

        assertThat(stackActual.postfix(), is(92));
    }

    @Test
    void postfixMultiply() {

        Stack<String> stackActual = new Stack<>();
        stackActual.postfix();
        stackActual.push("*");
        stackActual.push("4");
        stackActual.push("3");

        assertThat(stackActual.postfix(), is(12));
    }

    @Test
    void bracketNull() {
        assertThat(brackets(""), is(false));
    }

    @Test
    void bracketNotBalanceDiscoveringMore() {
        assertThat(brackets("((())"), is(false));
        assertThat(brackets("()(("), is(false));
        assertThat(brackets("((()())"), is(false));
    }

    @Test
    void bracketCoveringMore() {
        assertThat(brackets("))((("), is(false));
        assertThat(brackets("()(("), is(false));
        assertThat(brackets("((()("), is(false));
    }

    @Test
    void bracketStartsWithClosing() {
        assertThat(brackets("))(("), is(false));
        assertThat(brackets(")(("), is(false));
        assertThat(brackets(")("), is(false));
    }

    @Test
    void bracket() {
        assertThat(brackets("(()((())()))"), is(true));
    }
}