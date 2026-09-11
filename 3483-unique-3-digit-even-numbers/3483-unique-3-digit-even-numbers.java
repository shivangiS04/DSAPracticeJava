class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];

        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;

        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 8; c += 2) {
                    if (freq[a] == 0 || freq[b] == 0 || freq[c] == 0) {
                        continue;
                    }

                    freq[a]--;
                    freq[b]--;
                    freq[c]--;

                    if (freq[a] >= 0 && freq[b] >= 0 && freq[c] >= 0) {
                        count++;
                    }

                    freq[a]++;
                    freq[b]++;
                    freq[c]++;
                }
            }
        }

        return count;
    }
}