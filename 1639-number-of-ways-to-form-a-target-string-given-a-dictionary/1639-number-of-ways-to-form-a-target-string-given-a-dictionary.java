import java.util.*;

class Solution {
    public static int numWays(String[] words, String target) {
        int len = words[0].length();
        int lt = (int) Math.pow(10, 9) + 7;

        if (len < target.length()) return 0;
        int count = 0;

        int[][] mapper = new int[len][26];

        for (String word : words) {
            for (int i = 0; i < len; i++) {
                int val = word.charAt(i) - 'a';
                mapper[i][val]++;
            }
        }

        int tarLen = target.length();
        int[] freqData = new int[target.length()];
        freqData[0] = 1;

        for (int i = 0; i < len; i++) {
            int[] tmp = Arrays.copyOf(freqData, tarLen);

            for (int j = 0; j < tarLen; j++) {
                int prevFreq = freqData[j];

                if (prevFreq == 0) continue;

                int freq = mapper[i][target.charAt(j) - 'a'];

                if (freq == 0) continue;

                int updatedFreq = (int) (((long) prevFreq * freq) % lt);

                if (j == tarLen - 1) {
                    count = (count + updatedFreq) % lt;
                } else {
                    tmp[j + 1] = (tmp[j + 1] + updatedFreq) % lt;
                }
            }
            freqData = tmp;
        }

        return count;
    }
}