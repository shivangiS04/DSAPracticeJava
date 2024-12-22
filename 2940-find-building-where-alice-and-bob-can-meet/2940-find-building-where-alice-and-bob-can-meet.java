import java.util.*;

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length, qn = queries.length;
        List<int[]>[] que = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            que[i] = new ArrayList<>();
        }
        PriorityQueue<int[]> h = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] res = new int[qn];
        Arrays.fill(res, -1);

        // Process each query
        for (int qi = 0; qi < qn; qi++) {
            int i = queries[qi][0], j = queries[qi][1];
            if (i < j && heights[i] < heights[j]) {
                res[qi] = j;
            } else if (i > j && heights[i] > heights[j]) {
                res[qi] = i;
            } else if (i == j) {
                res[qi] = i;
            } else { // Store deferred queries
                que[Math.max(i, j)].add(new int[] { Math.max(heights[i], heights[j]), qi });
            }
        }

        // Process deferred queries
        for (int i = 0; i < n; i++) {
            // Handle pending queries in priority queue
            while (!h.isEmpty() && h.peek()[0] < heights[i]) {
                res[h.poll()[1]] = i;
            }
            // Add new deferred queries for this building
            for (int[] q : que[i]) {
                h.add(q);
            }
        }

        return res;
    }
}
