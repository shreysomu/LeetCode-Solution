
class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        // Step 1: Compute distance from nearest thief
        int[][] dist = new int[n][n];
        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            for (int[] d : dir) {

                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n &&
                        dist[nx][ny] == -1) {

                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        int low = 0;
        int high = 2 * n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canReach(dist, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    private boolean canReach(int[][] dist, int safe) {

        int n = dist.length;

        if (dist[0][0] < safe)
            return false;

        boolean[][] vis = new boolean[n][n];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            if (x == n - 1 && y == n - 1)
                return true;

            for (int[] d : dir) {

                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 &&
                        nx < n && ny < n &&
                        !vis[nx][ny] &&
                        dist[nx][ny] >= safe) {

                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}

