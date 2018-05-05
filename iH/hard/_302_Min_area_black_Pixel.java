package GI.hard;

public class _302_Min_area_black_Pixel {
	public static void main(String[] args) {
		char [][] image = new char[][] {
				{'0', '0', '1', '0',},
				{'0', '1', '1', '0',},
				{'0', '1', '0', '0',}
				};
		int area = minArea(image,0,2);
		System.out.println(" area is "+area);

	}
	static int top, bottom, left, right;
    static int minArea(char[][] image, int x, int y) {
        if(image.length == 0 || image[0].length == 0) return 0;
        top = bottom = x;
        left = right = y;
        dfs(image, x, y);
        System.out.println(" right "+right);
        System.out.println(" left "+left);
        System.out.println(" top "+top);
        System.out.println(" bottom "+bottom);
        return ((right - left)+1) * ((bottom - top)+1);
    }
    static void dfs(char[][] image, int x, int y){
        if(x < 0 || y < 0 || x >= image.length || y >= image[0].length ||
          image[x][y] == '0')
            return;
        image[x][y] = '0'; // mark visited black pixel as white
        top = Math.min(top, x);
        bottom = Math.max(bottom, x);
        left = Math.min(left, y);
        right = Math.max(right, y);
        dfs(image, x + 1, y);
        dfs(image, x - 1, y);
        dfs(image, x, y - 1);
        dfs(image, x, y + 1);
    }
    
    static void dfs1(char[][] image, int x, int y){
        if(x < 0 || y < 0 || x >= image.length || y >= image[0].length ||
          image[x][y] == '0')
            return;
        image[x][y] = '0'; // mark visited black pixel as white
        top = Math.min(top, x);
        bottom = Math.max(bottom, x + 1);
        left = Math.min(left, y);
        right = Math.max(right, y + 1);
        dfs(image, x + 1, y);
        dfs(image, x - 1, y);
        dfs(image, x, y - 1);
        dfs(image, x, y + 1);
    }
}
