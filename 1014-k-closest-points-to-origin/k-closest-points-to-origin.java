class Solution {
    public int[][] kClosest(int[][] points, int k) {
        

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)-> Long.compare(b.sqDist,a.sqDist));

        // Calculate squared distances for each point and add to maxHeap
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            long sqDist = (long) x * x + (long) y * y;
            maxHeap.offer(new Pair(x, y, sqDist));

            // If heap size exceeds k, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Extract k closest points from maxHeap
        int[][] res = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            Pair pair = maxHeap.poll();
            res[index][0] = pair.x;
            res[index][1] = pair.y;
            index++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        int[][] result = solution.kClosest(points, k);
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }

    class Pair {
        int x;
        int y;
        long sqDist;

        Pair(int x, int y, long sqDist) {
            this.x = x;
            this.y = y;
            this.sqDist = sqDist;
        }
    }
}