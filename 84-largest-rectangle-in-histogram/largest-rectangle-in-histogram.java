import java.util.*;

public class Solution {
    public int largestRectangleArea(int[] heights) {

        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];

        int[] sl = smallestOnLeft(heights);
        int[] sr = smallestOnRight(heights);
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int curArea = heights[i] * (sr[i] - sl[i] - 1);
            maxArea = Math.max(maxArea, curArea);
        }

        return maxArea;
    }

    static int[] smallestOnLeft(int[] h) {
        int n = h.length;
        int[] sl = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && h[stack.peek()] >= h[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sl[i] = -1;
            } else {
                sl[i] = stack.peek();
            }

            stack.push(i);
        }

        return sl;
    }

    static int[] smallestOnRight(int[] h) {
        int n = h.length;
        int[] sr = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && h[stack.peek()] >= h[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sr[i] = n;
            } else {
                sr[i] = stack.peek();
            }

            stack.push(i);
        }

        return sr;
    }
}
