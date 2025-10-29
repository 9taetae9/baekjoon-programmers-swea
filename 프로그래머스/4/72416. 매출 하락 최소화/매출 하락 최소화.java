
import java.util.*;

class Solution {
	List<Integer>[] tree;
	int[] sales;
	int[][] dp;

	public int solution(int[] sales, int[][] links){
		this.sales = sales;
		int n = sales.length;

		tree = new ArrayList[n+1];
		for(int i=1; i <= n; i++){
			tree[i] = new ArrayList<>();
		}

		for(int[] link : links){
			tree[link[0]].add(link[1]);
		}

		dp = new int[n+1][2];
		dfs(1);

		return Math.min(dp[1][0], dp[1][1]);
	}

	private void dfs(int node){
		//리프 노드
		if(tree[node].isEmpty()){
			dp[node][0] = 0;
			dp[node][1] = sales[node - 1];
            return ;
		}

		dp[node][1] = sales[node - 1];
		int sum = 0;
		boolean hasSelected = false;
		int minDiff = Integer.MAX_VALUE;

		for(int child : tree[node]){
			dfs(child);
			int cost0 = dp[child][0];
			int cost1 = dp[child][1];

			int minCost = Math.min(cost0, cost1);
			
			sum += minCost;
			dp[node][1] += minCost;

			if(cost1 <= cost0){
				hasSelected = true;
			}else{
				minDiff = Math.min(minDiff, cost1 - cost0);
			}			
		}

		if(hasSelected){
			dp[node][0] = sum;
		}else{
			dp[node][0] = sum + minDiff;
		}
	}
}