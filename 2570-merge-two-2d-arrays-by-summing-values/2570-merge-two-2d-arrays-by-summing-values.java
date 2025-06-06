class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Process nums1
        for (int[] pair : nums1) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + pair[1]);
        }

        // Process nums2
        for (int[] pair : nums2) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + pair[1]);
        }

        // Convert TreeMap to 2D array
        int[][] result = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }

        return result;
    }
}
