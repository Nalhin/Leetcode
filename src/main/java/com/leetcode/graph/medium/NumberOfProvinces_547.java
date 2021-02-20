package com.leetcode.graph.medium;

// There are n cities. Some of them are connected, while some are not. If city a
// is connected directly with city b, and city b is connected directly with city c,
// then city a is connected indirectly with city c.
//
// A province is a group of directly or indirectly connected cities and no other
// cities outside of the group.
//
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
// ith city and the jth city are directly connected, and isConnected[i][j] = 0 othe
// rwise.
//
// Return the total number of provinces.
//
//
// Example 1:
//
//
// Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
// Output: 2
//
//
// Example 2:
//
//
// Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
// Output: 3
//
//
//
// Constraints:
//
//
// 1 <= n <= 200
// n == isConnected.length
// n == isConnected[i].length
// isConnected[i][j] is 1 or 0.
// isConnected[i][i] == 1
// isConnected[i][j] == isConnected[j][i]
//
// Related Topics Depth-first Search Union Find
// 👍 2740 👎 170

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n*n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Provinces.
 O(n) Memory Usage: 39.8 MB, less than 78.57% of Java online submissions for Number of Provinces.
*/
public class NumberOfProvinces_547 {
  public int findCircleNum(int[][] graph) {
    boolean[] visited = new boolean[graph.length];
    int result = 0;

    for (int i = 0; i < graph.length; i++) {
      if (!visited[i]) {
        visit(i, graph, visited);
        result++;
      }
    }

    return result;
  }

  private void visit(int city, int[][] graph, boolean[] visited) {
    for (int i = 0; i < graph.length; i++) {
      if (graph[city][i] == 1 && !visited[i]) {
        visited[i] = true;
        visit(i, graph, visited);
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
