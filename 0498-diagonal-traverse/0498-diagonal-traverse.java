class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length; // Number of rows
        int n = mat[0].length; // Number of columns

        List<List<Integer>> diagonals = new ArrayList<>();

        // Initialize lists for each diagonal
        for (int i = 0; i < m + n - 1; i++) {
            diagonals.add(new ArrayList<>());
        }

        // Group elements by their diagonal index (i + j)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diagonals.get(i + j).add(mat[i][j]);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        boolean flip = true;

        // Process each diagonal
        for (List<Integer> diagonal : diagonals) {
            if (flip) {
                Collections.reverse(diagonal); // Reverse every alternate diagonal
            }
            resultList.addAll(diagonal); // Add elements to the result
            flip = !flip;
        }

        // Convert the result to an array
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
