package GI;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class C_WallsAndGates {

	public static void main(String[] args) throws Exception{
        int[][] A = {{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};
        for(int i =0 ; i<A.length; i++){
        	for(int j=0; j< A[0].length; j++){
        		if(A[i][j] == 0){
        			// visited to be declared here so that for every '0' a new visited is
        			// created, else we cannot find min distance to any room
        			boolean[][] visited = new boolean[A.length][A[0].length];
        			wallsAndGatesDFS(i,j, A, A[i][j], visited);
        		}
        	}
        }
        for (int[] row : A){
            System.out.println(Arrays.toString(row));
         }
    }

	public static void wallsAndGatesDFS(int i, int j, int[][] rooms, int val, boolean[][] visited){
		if(i< 0 || i>rooms.length-1 || j<0 || j>rooms[0].length-1 || rooms[i][j] == -1 || visited[i][j]){
			return;
		}
		visited[i][j] = true;
		//rooms[i][j] = rooms[i][j] == Integer.MAX_VALUE ? val+1 :  Math.min(val+1, rooms[i][j]);
		rooms[i][j] = Math.min(val+1, rooms[i][j]);
		wallsAndGatesDFS(i, j-1, rooms, rooms[i][j], visited);
		wallsAndGatesDFS(i, j+1, rooms, rooms[i][j], visited);
		wallsAndGatesDFS(i-1, j, rooms, rooms[i][j], visited);
		wallsAndGatesDFS(i+1, j, rooms, rooms[i][j], visited);
	}
	//IMP: since we have all 0 s in q, it will make sure we updated the min value, w/0 using visited array
    public static void wallsAndGatesBFS(int[][] rooms) {
        Queue<Cell> queue = new ArrayDeque<>();
        for(int i = 0; i < rooms.length; i ++){
            for(int j = 0; j < rooms[0].length; j ++){
                if(rooms[i][j] == 0){ //treat each co-ordinates of gate as a source
                    Cell cell = new Cell(i, j);
                    queue.offer(cell);
                }
            }
        }
        while(!queue.isEmpty()){
            Cell top = queue.poll();
            for(int i = 0; i < 4; i++){
                int newR = top.r + R[i];
                int newC = top.c + C[i];
                if(newR >= 0 && newC >= 0 && newR < rooms.length && newC < rooms[0].length){
                    if(rooms[newR][newC] == Integer.MAX_VALUE){
                        rooms[newR][newC] = rooms[top.r][top.c] + 1;
                        queue.offer(new Cell(newR, newC));
                    }
                }
            }
        }
    }
    private static final int[] R = {0, 0, 1, -1};
    private static final int[] C = {1, -1, 0, 0};
    
}
class Cell{
    int r, c;
    Cell(int r, int c){
        this.r = r;
        this.c = c;
    }
}