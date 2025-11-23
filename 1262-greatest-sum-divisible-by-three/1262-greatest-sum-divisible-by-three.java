class Solution {
    public int maxSumDivThree(int[] nums) {
        int total = 0;
        List<Integer> mod1 = new ArrayList<>();
        List<Integer> mod2 = new ArrayList<>();

        for (int n : nums) {
            total += n;
            if (n % 3 == 1) mod1.add(n);
            else if (n % 3 == 2) mod2.add(n);
        }

        if (total % 3 == 0) return total;

        Collections.sort(mod1);
        Collections.sort(mod2);

        int r = total % 3;
        int option1 = Integer.MIN_VALUE;
        int option2 = Integer.MIN_VALUE;

        if (r == 1) {
            if (mod1.size() >= 1) option1 = total - mod1.get(0);
            if (mod2.size() >= 2) option2 = total - mod2.get(0) - mod2.get(1);
        } else {
            if (mod2.size() >= 1) option1 = total - mod2.get(0);
            if (mod1.size() >= 2) option2 = total - mod1.get(0) - mod1.get(1);
        }

        return Math.max(option1, option2);
    }
}
