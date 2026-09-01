class Solution {
    static class State {
        int r, c, energy, mask, steps;

        State(int r, int c, int energy, int mask, int steps) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
            this.steps = steps;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        int[][] id = new int[m][n];
        for (int[] row : id) {
            Arrays.fill(row, -1);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    sr = r;
                    sc = c;
                } else if (ch == 'L') {
                    id[r][c] = litterCount++;
                }
            }
        }

        int target = (1 << litterCount) - 1;

        if (target == 0) {
            return 0;
        }

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        Queue<State> q = new ArrayDeque<>();

        visited[sr][sc][energy][0] = true;
        q.offer(new State(sr, sc, energy, 0, 0));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.mask == target) {
                return cur.steps;
            }

            if (cur.energy == 0) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                char cell = classroom[nr].charAt(nc);

                if (cell == 'X') {
                    continue;
                }

                int newEnergy = cur.energy - 1;
                int newMask = cur.mask;

                if (cell == 'L') {
                    newMask |= 1 << id[nr][nc];
                }

                if (cell == 'R') {
                    newEnergy = energy;
                }

                if (!visited[nr][nc][newEnergy][newMask]) {
                    visited[nr][nc][newEnergy][newMask] = true;

                    q.offer(new State(
                        nr,
                        nc,
                        newEnergy,
                        newMask,
                        cur.steps + 1
                    ));
                }
            }
        }

        return -1;
    }
}