class Solution {
    static final int MOD = 1_000_000_007;
    int n;
    long[] segVal;
    int[] segCnt;
    long[] pow10;

    public int[] sumAndMultiply(String s, int[][] queries) {
        n = s.length();

        long[] prefSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefSum[i + 1] = prefSum[i] + (s.charAt(i) - '0');
        }

        pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        segVal = new long[4 * n];
        segCnt = new int[4 * n];
        build(s, 1, 0, n - 1);

        int q = queries.length;
        int[] answer = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0], r = queries[i][1];

            long sum = prefSum[r + 1] - prefSum[l];
            long[] res = query(1, 0, n - 1, l, r);
            long xMod = res[0];

            answer[i] = (int) ((xMod % MOD) * (sum % MOD) % MOD);
        }

        return answer;
    }

    private void build(String s, int node, int l, int r) {
        if (l == r) {
            int digit = s.charAt(l) - '0';
            if (digit != 0) {
                segVal[node] = digit;
                segCnt[node] = 1;
            } else {
                segVal[node] = 0;
                segCnt[node] = 0;
            }
            return;
        }
        int mid = (l + r) / 2;
        build(s, 2 * node, l, mid);
        build(s, 2 * node + 1, mid + 1, r);
        combineInto(node, 2 * node, 2 * node + 1);
    }

    private void combineInto(int node, int leftNode, int rightNode) {
        long lv = segVal[leftNode], rv = segVal[rightNode];
        int lc = segCnt[leftNode], rc = segCnt[rightNode];
        segVal[node] = (lv * pow10[rc] + rv) % MOD;
        segCnt[node] = lc + rc;
    }

    private long[] combine(long[] left, long[] right) {
        long val = (left[0] * pow10[(int) right[1]] + right[0]) % MOD;
        long cnt = left[1] + right[1];
        return new long[]{val, cnt};
    }

    private long[] query(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) {
            return new long[]{0, 0};
        }
        if (ql <= l && r <= qr) {
            return new long[]{segVal[node], segCnt[node]};
        }
        int mid = (l + r) / 2;
        long[] leftRes = query(2 * node, l, mid, ql, qr);
        long[] rightRes = query(2 * node + 1, mid + 1, r, ql, qr);
        return combine(leftRes, rightRes);
    }
}