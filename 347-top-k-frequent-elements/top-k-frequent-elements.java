class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Find the frequency of each number
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int n : nums)
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> topKElements = new PriorityQueue<>(
                (e1, e2) -> e1.getValue() - e2.getValue());

        // Go through all numbers of the numFrequencyMap and push them into
        // topKElements, which will have
        // the top k frequent numbers. If the heap size is more than k, we remove the
        // smallest (top) number.
        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            topKElements.add(entry);
            if (topKElements.size() > k) {
                topKElements.poll();
            }
        }

        // Create a list of top k numbers
        int[] topNumbers = new int[k];

        int i = 0;
        while (!topKElements.isEmpty()) {
            topNumbers[i] = topKElements.poll().getKey();
            i++;
        }

        return topNumbers;
    }
}