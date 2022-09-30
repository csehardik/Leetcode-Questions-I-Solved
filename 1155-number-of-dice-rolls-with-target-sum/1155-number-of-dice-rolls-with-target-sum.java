class Solution {
    public int numRollsToTarget(int n, int k, int target) {
     
        return totalWays(n,k,target,new HashMap<String,Integer>());
        
    }
    private int totalWays(int n, int f, int targetSum,HashMap<String,Integer>memo)
	{

		if (n == 0 && targetSum == 0)
		{
			return 1;
		}

		if (n == 0 || targetSum <= 0)
		{
			return 0;
		}

		// if (dp.get(n).get(targetSum) != -1)
		// {
			// return dp.get(n).get(targetSum);
		// }
        
        String currentKey = Integer.toString(n)+'-'+Integer.toString(targetSum);
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);

		int tempAns = 0;
		int ways = 0;
		int mod = 1000000007;
		for (int i = 1; i <= f; i++)
		{
			tempAns = totalWays(n - 1, f, targetSum - i, memo) % mod;
			   // ways=ways%mod;
			   // ways=(ways+tempAns)%mod;

			ways = (ways + tempAns) % mod;
		}
		// return dp.get(n).set(targetSum, ways);
        
        memo.put(currentKey,ways);
        return memo.get(currentKey);
	}
}