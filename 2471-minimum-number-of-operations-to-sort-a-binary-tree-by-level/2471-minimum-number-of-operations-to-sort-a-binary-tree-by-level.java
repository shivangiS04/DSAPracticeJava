/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int countSwaps(List<Integer> values) {
        int swaps = 0;
        List<Integer> sorted = new ArrayList<>(values);
        Collections.sort(sorted);

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < values.size(); i++) {
            indexMap.put(values.get(i), i);
        }

        for (int i = 0; i < values.size(); i++) {
            if (!values.get(i).equals(sorted.get(i))) {
                swaps++;
                int existingPos = indexMap.get(sorted.get(i));

                indexMap.put(values.get(i), existingPos);
                indexMap.put(sorted.get(i), i);

                Collections.swap(values, i, existingPos);
            }
        }

        return swaps;
    }

    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int swaps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> values = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                values.add(current.val);

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            swaps += countSwaps(values);
        }

        return swaps;
    }
}
