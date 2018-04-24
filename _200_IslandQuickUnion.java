package hard;

import java.util.Arrays;

public class _200_IslandQuickUnion {

	public static void main(String[] args) {
			char[][] grid = new char[][]{
			{'1','1','1','1','0'},
			{'1','1','0','0','0'},
			{'0','0','1','0','1'}};
			//UnionFind uf = new UnionFind(grid);
			// how count works? total 1s = 8, while we make union in above case we have 5 1s in connection so 8-5 =3 is answer
			System.out.println((UnionFind.numIslands(grid)));
	}
	}
	class UnionFind {
		static int count; // # of connected components
		static int[] parent;
		int[] rank;
		// initialize parent[i] = i, and count 1s in the Matrix
		public UnionFind(char[][] grid) { // for problem 200
			count = 0;
			int rowLen = grid.length;
			int colLen = grid[0].length;
			parent = new int[rowLen * colLen];
			rank = new int[rowLen * colLen];
			for (int row = 0; row < rowLen; ++row) {
				for (int col = 0; col < colLen; ++col) {
					if (grid[row][col] == '1') {
						parent[row * colLen + col] = row * colLen + col;
						++count; // we count all cells with value 1
					}
					rank[row * colLen + col] = 0;
				}
			}
			System.out.println(" count at init is "+count+ " \narr is "+Arrays.toString(parent));
		}

		public int find(int i) { // path compression
			if (parent[i] != i)
				parent[i] = find(parent[i]);
			return parent[i];
		}

		public void union(int x, int y) { // union with rank
			int rootx = find(x);// find parent of x
			int rooty = find(y);// find parent of y
			if (rootx != rooty) {
				if (rank[rootx] > rank[rooty]) {// to optimize tree height we do this check to associate one root to other
					parent[rooty] = rootx;
				} else if (rank[rootx] < rank[rooty]) {
					parent[rootx] = rooty;
				} else {
					parent[rooty] = rootx;
					rank[rootx] += 1;
				}
				--count; // logic of count is explained in main method
			}
		}

		public int getCount() {
			return count;
		}
	

	static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int rowLen = grid.length;
		int colLen = grid[0].length;
		int num_islands = 0;
		UnionFind uf = new UnionFind(grid);
		for (int row = 0; row < rowLen; ++row) {
			for (int col = 0; col < colLen; ++col) {
				if (grid[row][col] == '1') {
					grid[row][col] = '0';
					if (row - 1 >= 0 && grid[row - 1][col] == '1') {
						uf.union(row * colLen + col, (row - 1) * colLen + col);
					}
					if (row + 1 < rowLen && grid[row + 1][col] == '1') {
						uf.union(row * colLen + col, (row + 1) * colLen + col);
						System.out.println(" union  "+row+" , "+col+ " \narr is "+Arrays.toString(parent));
					}
					if (col - 1 >= 0 && grid[row][col - 1] == '1') {
						uf.union(row * colLen + col, row * colLen + col - 1);
						System.out.println(" union  "+row+" , "+col+ " \narr is "+Arrays.toString(parent));
					}
					if (col + 1 < colLen && grid[row][col + 1] == '1') {
						uf.union(row * colLen + col, row * colLen + col + 1);
						System.out.println(" union  "+row+" , "+col+ " \narr is "+Arrays.toString(parent));
					}
				}
			}
		}

		return uf.getCount();
	}
}
