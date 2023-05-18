package edu.sdsu.cs160l.datastructure;

import java.util.Stack;

// TODO implement the below function (2 points)
//  use Test Class to test your implementation
public class Parenthesis {
    /**
     * @param brackets contains a sequence of Characters '(' or ')'
     *                 eg : '((()))' is valid
     *                 '())' is invalid
     *                 ')(' is invalid
     *                 Check the test class for more examples
     * @return true is the brackets are balanced else false
     */
    public boolean isBalanced(String brackets) {
        Stack<Character> stack = new Stack<>();
        for (char c : brackets.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
