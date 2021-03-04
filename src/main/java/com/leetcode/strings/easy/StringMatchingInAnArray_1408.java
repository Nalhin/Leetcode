package com.leetcode.strings.easy;

// Given an array of string words. Return all strings in words which is substring
// of another word in any order.
//
// String words[i] is substring of words[j], if can be obtained removing some ch
// aracters to left and/or right side of words[j].
//
//
// Example 1:
//
//
// Input: words = ["mass","as","hero","superhero"]
// Output: ["as","hero"]
// Explanation: "as" is substring of "mass" and "hero" is substring of "superhero
// ".
// ["hero","as"] is also a valid answer.
//
//
// Example 2:
//
//
// Input: words = ["leetcode","et","code"]
// Output: ["et","code"]
// Explanation: "et", "code" are substring of "leetcode".
//
//
// Example 3:
//
//
// Input: words = ["blue","green","bu"]
// Output: []
//
//
//
// Constraints:
//
//
// 1 <= words.length <= 100
// 1 <= words[i].length <= 30
// words[i] contains only lowercase English letters.
// It's guaranteed that words[i] will be unique.
// Related Topics String
// 👍 281 👎 56

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatchingInAnArray_1408 {
  public List<String> stringMatching(String[] words) {
    Set<String> set = new HashSet<>();

    for (String str : words) {
      for (String upper : words) {
        if (!str.equals(upper) && str.contains(upper)) {
          set.add(upper);
        }
      }
    }

    return new ArrayList<>(set);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
