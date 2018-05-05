package GI.hard;

import java.util.LinkedList;
import java.util.Queue;

public class _317_Shortest_DIstance_From_All_Buildings {
	int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	int m, n;
	int[][] reachable;
	int[][] distMap;

	public int shortestDistance(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		m = grid.length;
		n = grid[0].length;
		int buildingCount = 0;
		distMap = new int[m][n];
		reachable = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					helper(grid, i, j);
					buildingCount++;
				}
			}
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (distMap[i][j] > 0 && reachable[i][j] == buildingCount) {
					res = Math.min(res, distMap[i][j]);
				}
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	private void helper(int[][] grid, int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });
		boolean[][] visited = new boolean[m][n];
		int dist = 1;
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				int[] point = queue.poll();
				int x = point[0], y = point[1];
				for (int[] dir : dirs) {
					int nx = x + dir[0];
					int ny = y + dir[1];
					if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny] && grid[nx][ny] == 0) {
						visited[nx][ny] = true;
						distMap[nx][ny] += dist;
						reachable[nx][ny]++;
						queue.offer(new int[] { nx, ny });
					}
				}
			}
			dist++;
		}
	}
}
