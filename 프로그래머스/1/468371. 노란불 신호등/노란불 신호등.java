class Solution {
    public int solution(int[][] signals) {
     int n = signals.length;
        long L = 1;
        for (int i = 0; i < n; i++) {
            int C = signals[i][0] + signals[i][1] + signals[i][2];
            L = lcm(L, C);
        }
        for (long t = 1; t <= L; t++) {
            boolean allYellow = true;
            for (int i = 0; i < n; i++) {
                int g = signals[i][0], y = signals[i][1], r = signals[i][2];
                int C = g + y + r;
                int pos = (int) ((t - 1) % C); // 0-based position in cycle
                if (!(pos >= g && pos < g + y)) {
                    allYellow = false;
                    break;
                }
            }
            if (allYellow) return (int) t;
        }
        return -1;
    }

    private static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return a / gcd(a, b) * b;
    }
}