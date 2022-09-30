class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1)
            return 0;
        return totalWays(obstacleGrid, 0, 0, obstacleGrid.length - 1, obstacleGrid[0].length - 1,new HashMap<String,Integer>());
    }
    public int totalWays(int[][] obstacleGrid, int down, int right, int m, int n, HashMap<String,Integer> memo)
    {
        if(down==m && right==n)
            return 1;
        if(down > m || right > n)
            return 0;
        
        String currentKey = Integer.toString(down) + "_" + Integer.toString(right);
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int downWay = 0;
        
        int rightWay = 0;
        
        if(down!=m && obstacleGrid[down+1][right]!=1)
             downWay = totalWays(obstacleGrid, down+1, right, m, n, memo);
        
        if(right!=n && obstacleGrid[down][right+1]!=1)
             rightWay = totalWays(obstacleGrid, down, right + 1, m, n, memo);
        
        memo.put(currentKey,(downWay + rightWay));
        
        return memo.get(currentKey);
    }
}