package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a start word, an end word and a dictionary of words
 * find the length of the shortest transformation from the start word to end word
 * such that
 * 1. Each word is transformed to the next word by a change in just one letter
 * 2. Each word transformed to, must be in the dictionary
 * eg, the sample given below maybe transformed as follows:
 * hit -> hot -> lot -> log -> cog
 * giving transformation length as 5.
 */

public class WordLadder {
  // approach is to do a bidrectional search and return the length the two searches meet.
  // to ensure the two searches meet, we first check that the endWord exists in list
  public static int search(String startWord, String endWord, Set<String> wordList) {
    if (!wordList.contains(endWord)) return 0;

    Set<String> beginSet = new HashSet<>();
    Set<String> endSet = new HashSet<>();
    // add both words to begin and end sets respectively
    beginSet.add(startWord); endSet.add(endWord);
    // remove from wordList to avoid duplicated search
    wordList.remove(endWord);

    int count = 1;

    while(!beginSet.isEmpty()) {
      // choose the lesser of the two trees
      if (beginSet.size() > endSet.size()) {
        Set<String> temp = beginSet;
        beginSet = endSet;
        endSet = temp;
      }

      // store children in arbitrary set
      Set<String> next = new HashSet<>();
      for (String el : beginSet) {
        // generate all one char variation of word and see if it exists in wordList
        // or has been seen in endSet
        char[] word = el.toCharArray();
        for (int i = 0; i < word.length; i++) {
          char original = word[i];
          for (char letter = 'a'; letter <= 'z'; letter++) {
            word[i] = letter;

            String newWord = String.valueOf(word);

            if (endSet.contains(newWord)) {
              return count + 1;
            }

            if (wordList.contains(newWord)) {
              next.add(newWord);
              wordList.remove(newWord);
            }
          }
          word[i] = original;
        }
      }
      beginSet = next;
      count++;
    }
    return 0;
  }

  public static void main(String[] args) {
    String[] dict = {"hot","dot","dog","lot","log", "cog"};
    String start = "hit", end = "cog";
    Set<String> wordList = new HashSet<>();

    for (String el : dict) {
      wordList.add(el);
    }

    System.out.println(WordLadder.search(start, end, wordList));
  }

}