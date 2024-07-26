class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[nums.length];
        int prev = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i] = prev + nums[i];
            if (sum[i] == k)
                cnt++;
            cnt += map.getOrDefault(sum[i] - k, 0);
            map.compute(sum[i], (K, v) -> v == null ? 1 : v + 1);
            prev = sum[i];
        }
        return cnt;
    }
}