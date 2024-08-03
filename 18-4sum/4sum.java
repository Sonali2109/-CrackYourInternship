class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> hset = new HashSet<>();

        Arrays.sort(nums);

        int n = nums.length;

        int i = 0, j = 0, k = 0, m = 0;
        for(;i<n-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if (sum4(nums[i], nums[i + 1], nums[i + 2], nums[i + 3]) > target) break;
            if (sum4(nums[i], nums[n - 1], nums[n - 2], nums[n - 3]) < target) continue;
            j = i+1;
            while(j<n-2) {
                k = j+1;
                m = n-1;
                while(k < m) {
                    long sum = sum4(nums[i], nums[j], nums[k], nums[m]);
                    if(sum == target) {
                        List<Integer> arr = new ArrayList<>();
                        arr.add(nums[i]); arr.add(nums[j]); arr.add(nums[k]); arr.add(nums[m]);
                        hset.add(arr);
                        k++; m--;
                    } else if(sum > target) {
                        m--;
                    } else {
                        k++;
                    }
                }
                j++;
            }
        }
        ans.addAll(hset);
        return ans;
    }

    private long sum4(int a, int b, int c, int d) {
        return (long) a + b + c + d;
    }
}