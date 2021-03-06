package com.leetcode.graph.medium;

// Given a reference of a node in a connected undirected graph.
//
// Return a deep copy (clone) of the graph.
//
// Each node in the graph contains a val (int) and a list (List[Node]) of its ne
// ighbors.
//
//
// class Node {
//    public int val;
//    public List<Node> neighbors;
// }
//
//
//
//
// Test case format:
//
// For simplicity sake, each node's value is the same as the node's index (1-ind
// exed). For example, the first node with val = 1, the second node with val = 2, a
// nd so on. The graph is represented in the test case using an adjacency list.
//
// Adjacency list is a collection of unordered lists used to represent a finite
// graph. Each list describes the set of neighbors of a node in the graph.
//
// The given node will always be the first node with val = 1. You must return th
// e copy of the given node as a reference to the cloned graph.
//
//
// Example 1:
//
//
// Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
// Output: [[2,4],[1,3],[2,4],[1,3]]
// Explanation: There are 4 nodes in the graph.
// 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
// 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
// 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
// 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
//
//
// Example 2:
//
//
// Input: adjList = [[]]
// Output: [[]]
// Explanation: Note that the input contains one empty list. The graph consists o
// f only one node with val = 1 and it does not have any neighbors.
//
//
// Example 3:
//
//
// Input: adjList = []
// Output: []
// Explanation: This an empty graph, it does not have any nodes.
//
//
// Example 4:
//
//
// Input: adjList = [[2],[1]]
// Output: [[2],[1]]
//
//
//
// Constraints:
//
//
// 1 <= Node.val <= 100
// Node.val is unique for each node.
// Number of Nodes will not exceed 100.
// There is no repeated edges and no self-loops in the graph.
// The Graph is connected and all nodes can be visited starting from the given n
// ode.
//
// Related Topics Depth-first Search Breadth-first Search Graph
// 👍 2111 👎 1450

// leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.*;

public class CloneGraph_133 {
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    Map<Node, Node> visited = new HashMap<>();
    Node result = new Node(node.val);
    visited.put(node, result);

    Deque<Node> stack = new ArrayDeque<>();
    stack.push(node);

    while (!stack.isEmpty()) {
      Node curr = stack.pop();
      Node copyCurr = visited.get(curr);

      for (Node n : curr.neighbors) {
        if (!visited.containsKey(n)) {
          visited.put(n, new Node(n.val));
          stack.push(n);
        }
        copyCurr.neighbors.add(visited.get(n));
      }
    }
    return result;
  }

  private static class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}
/*
 O(n + m) Runtime: 26 ms, faster than 84.58% of Java online submissions for Clone Graph.
 O(n) Memory Usage: 39.1 MB, less than 12.08% of Java online submissions for Clone Graph.
 where:
 n- number of nodes
 m - number of edges
*/
// leetcode submit region end(Prohibit modification and deletion)
