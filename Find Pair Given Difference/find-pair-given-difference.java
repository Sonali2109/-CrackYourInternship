class Solution {
    static int findPair(int n, int diff, int[] arr) {
        // Create a HashSet to store array elements
        java.util.HashSet<Integer> set = new HashSet<>();
        
        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            // Check if the pair with the given difference exists
            if (set.contains(arr[i] - diff) || set.contains(arr[i] + diff)) {
                return 1;
            }
            // Add the current element to the set
            set.add(arr[i]);
        }
        
        return -1;
    }
}
