package medium;

import java.util.*;

public class WordBreak {
  public static boolean solve(List<String> wordDict, String s) {
    Set<String> dict = new HashSet<>(wordDict);
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();

    queue.add(0);
    visited.add(0);

    while (!queue.isEmpty()) {
      StringBuilder cur = new StringBuilder();
      // keep the index of valid words in the queue for further processing
      int curIdx = queue.poll();      
      
      for (int i = curIdx + 1; i <= s.length(); i++) {
        cur.append(s.charAt(i-1));
        if (visited.contains(i)) continue;

        if (dict.contains(cur.toString())) {
          // if the reached the end and we have valid words, then voila!
          if (i == s.length()) return true;

          // if not, add to queue and mark as visited so as not to process again
          queue.add(i);
          visited.add(i);
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    List<String> wordDict = new LinkedList<>();
    wordDict.add("apple");
    wordDict.add("pen");
    // wordDict.add("cat");
    // wordDict.add("cats");
    // wordDict.add("sand");
    // wordDict.add("and");
    // wordDict.add("dog");
    // String s = "catsandog";
    String s = "applepenapple";
    System.out.println(WordBreak.solve(wordDict, s));
  }
}