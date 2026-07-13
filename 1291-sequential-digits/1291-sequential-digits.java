class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        List<Integer> res = new ArrayList<>();
        
        for (int length = 2; length <= 9; length++) {
            for (int start = 0; start <= 9 - length; start++) {
                int num = Integer.parseInt(s.substring(start, start + length));
                if (num >= low && num <= high) {
                    res.add(num);
                }
            }
        }
        return res;
    }
}