package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0241_DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        if (isDigit(input)) {
            return Collections.singletonList(Integer.parseInt(input));
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            final char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (c) {
                            case '+':
                                result.add(l + r);
                                break;
                            case '-':
                                result.add(l - r);
                                break;
                            case '*':
                                result.add(l * r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        return result;
    }

    private static boolean isDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
