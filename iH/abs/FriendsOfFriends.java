package abs;

import java.util.Arrays;

/*
 * This is finding number of friend circles
 * This is a slight variation, the problem description is confusing
 * row 0 represent all friends of student 0, so if M[01] is 1
 * means 0 and 1 are friends hence we can go to row 1 now to explore
 * all friends of 1 
 * The visited array is only maintained for rows so we dont go to same
 * row again
 * BASICALLY WE ARE FINDING HOW MANY ROWS ARE CONNECTED
 * row 
*/
public class FriendsOfFriends {
	 public static void main(String[] args) {
	        System.out.println("Hello World!");
	        int[][] m = new int[][]{{1,1,0,0,0,0},// 0 1  are friends
	                                {1,1,0,0,0,0},// 0 1 are friends
	                                {0,0,1,1,0,0},// 2 3 are fr
	                                {0,0,1,1,0,0},// 2,3 are fri
	                                {0,0,0,0,1,1},// 4 5 are friends
	                                {0,0,0,0,1,1}};// 4 5 are friends //  3 circles
            int[][] m1 = new int[][]
               {{1,1,0,0,0,0},// 0 1 
                {1,1,1,0,0,0},// 1 is f with 0 2
                {0,1,1,0,0,0},// 2 is f of 1           -- circle 1 (012)
                {0,0,0,1,0,0},// only f of itself circle 2(3)
                {0,0,0,0,1,1}, // 4 5 are f
                {0,0,0,0,1,1}};// 4 5 are f                   -- circle 3(45)
	        System.out.println(findCircleNum1(m));
	        System.out.println(findCircleNum1(m1));
	    }
	 static private int findCircleNum1(int[][] m){
		 int count=0;
		 // visited only tracks if a row is visted or not
		 boolean visited[] = new boolean[m.length];
		 for(int i=0; i<m.length-1; i++){
				 if(!visited[i]){
					 dfs(visited, m, i);
					 count++;
				 }
				 System.out.println(" .. "+i+" "+Arrays.toString(visited));
		 }
		 return count;
	 }
	 static void dfs(boolean[] visited, int[][]m, int row){
		 for(int j=0; j<m[0].length; j++){
			 if(!visited[j] && m[row][j] == 1){
				 visited[j] = true;
				 dfs(visited, m, j);
			 }
		 }
	 }
	 
}

