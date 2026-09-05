class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long N = (long) n * n; // Total elements in the matrix

        // 1. Calculate Expected Sum and Expected Square Sum for 1 to N
        long expSum = N * (N + 1) / 2;
        long expSqSum = N * (N + 1) * (2 * N + 1) / 6;

        long actSum = 0;
        long actSqSum = 0;

        // 2. Accumulate Actual Sum and Actual Square Sum
        for (int[] row : grid) {
            for (int ele : row) {
                actSum += ele;
                actSqSum += (long) ele * ele;
            }
        }

        // 3. Form Equations: d1 = y - x, d2 = y^2 - x^2
        long d1 = actSum - expSum;       // y - x
        long d2 = actSqSum - expSqSum;   // y^2 - x^2

        long sumXY = d2 / d1;            // y + x

        // 4. Solve for y (Repeating) and x (Missing)
        int y = (int) ((d1 + sumXY) / 2);
        int x = (int) (y - d1);

        // 5. Return [Repeating, Missing]
        return new int[]{y, x};
    }
}