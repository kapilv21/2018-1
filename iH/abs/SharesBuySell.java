package abs;

public class SharesBuySell {
	public static void main(String args[]) {
		int[] ar = new int[] { 1, 12, 19, 3, 28, 37, 6, 3, 9, 12, 45, 67, 68,
				90, 91, 92, 93, 94 }; // 18, 34, 91

		System.out.println(" max profit " + buySellShares3(ar));
		
		int[] p = {100, 80, 120, 130, 70, 60, 100, 125};
		System.out.println(" total profit multiple xacn " + buySellSharesMultipleTransactions(p));
	}

	// this is easiest and is from INterview cake - 1 Transaction
	private static int buySellShares3(int[] ar) {
		int profit = 0;
		int maxProfit = 0;
		int buy = ar[0];
		for (int j = 1; j < ar.length; j++) {
			// current price
			int currentPrice = ar[j];
			profit = currentPrice - buy;

			maxProfit = Math.max(profit, maxProfit);
			buy = Math.min(currentPrice, buy);
			// buy on above price if it is cheaper than buy
		}
		return maxProfit;
	}
	
	// MULTI transactions, we add the profit of each window
	private static int buySellSharesMultipleTransactions(int[] ar) {
		int totalProfit = 0;
		for (int j = 1; j < ar.length; j++) {
			int currentProfit = ar[j] - ar[j-1];
			if(currentProfit > 0) {
				totalProfit += currentProfit;
			}
		}
		return totalProfit;
	}

}
