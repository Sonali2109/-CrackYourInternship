class Solution
{
    static String max;

    public static String swap(String str, int i, int j) {
        char x = str.charAt(i);
        char y = str.charAt(j);
        String left = str.substring(0,i);
        String  mid = str.substring(i+1,j);
        String right = str.substring(j+1);
        return left + y + mid + x + right;
    }

    public static void helper(String str, int k, int i) {
        if (str.compareTo(max) > 0) {
            max = str;
        }

        if (k == 0 || i == str.length()) {
            return;
        }

        char g = str.charAt(i);
        for (int j = i + 1; j < str.length(); j++) {
            if (str.charAt(j) > g) {
                g = str.charAt(j);
            }
        }

        for (int j = i + 1; j < str.length(); j++) {
            if (str.charAt(j) == g && str.charAt(j) > str.charAt(i)) {
                str = swap(str, i, j);
                helper(str, k - 1, i + 1);
                str = swap(str, i, j);
            }
        }

        helper(str, k, i + 1);  
    }

    public static String findMaximumNum(String str, int k) {
        max = str;
        helper(str, k, 0);
        return max;
    }
}
