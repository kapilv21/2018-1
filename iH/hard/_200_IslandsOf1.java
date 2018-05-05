package  GI.hard;

public class _200_IslandsOf1 {
public static void main(String[] args) {
	char[][] grid = new char[][]{{'1','1','1','1','0'},
	{'1','1','0','0','0'},
	{'0','0','1','0','1'}};
	System.out.println((numIslands(grid)));
}
	static int numIslands(char[][] grid) {
	    int count=0;
	    for(int i=0;i<grid.length;i++)
	        for(int j=0;j<grid[0].length;j++){
	            if(grid[i][j]=='1'){
	                dfs(grid,i,j);
	                count++;
	            }
	        }
	    return count;
	}
	static void dfs(char[][] grid,int i, int j){
	    //if(i>=0 && j>=0 && i<grid.length && j<grid[0].length&&grid[i][j]=='1'){
		if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0'){
			return;
		}
	        grid[i][j]='0';
	        dfs(grid, i + 1, j);
	        dfs(grid, i - 1, j);
	        dfs(grid, i, j + 1);
	        dfs(grid, i, j - 1);
	    //}
	}
}
