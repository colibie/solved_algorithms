package medium;

import java.util.*;

class Main {
  public static boolean canFinish(int numCourses, int[][] prerequisites) {

    HashMap<Integer, Set<Integer>> courseList = new HashMap<>();
    boolean[] visited = new boolean[numCourses];

    for (int i = 0; i < prerequisites.length; i++) {
      int[] edge = prerequisites[i];
      if (courseList.containsKey(edge[0])) {
        courseList.get(edge[0]).add(edge[1]);
      } else {
        Set<Integer> courseNeighs = new HashSet<>();
        courseNeighs.add(edge[1]);
        courseList.put(edge[0], courseNeighs);
      }
    }

    for (int i = 0; i < numCourses; i++) {
      if (!dfs(i, visited, courseList))
        return false;
    }
    return true;
  }
  static boolean dfs(int course, boolean[] visited,
                     HashMap<Integer, Set<Integer>> courseList) {
    if (!courseList.containsKey(course))
      return true;
    if (visited[course])
      return false;

    visited[course] = true;
    if (courseList.containsKey(course)) {
      for (int neigh : courseList.get(course)) {
        if (!dfs(neigh, visited, courseList))
          return false;
      }
    }
    visited[course] = false;
    return true;
  }

  static public void main(String args[]) {
    int numCourses = 2;
    int[][] prerequisites = {{1, 0}, {0, 1}};
    boolean test = Main.canFinish(numCourses, prerequisites);
    System.out.println(test);
  }
}

/**

https://leetcode.com/problems/course-schedule/

3
[[1,0],[2,1]]
[[1, 0], [2, 1]]

     2
      |
      1
     /
    0

There are a total of numCourses courses you have to take, labeled from 0 to
numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to
first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it
possible for you to finish all courses?


Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is
possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take
course 0 you should
             also have finished course 1. So it is impossible.


Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency
matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5

*/
/*
https://www.youtube.com/watch?v=ddTC4Zovtbc&t=2s

https://www.youtube.com/watch?v=0LjVxtLnNOk
your voice and video went out

// [1, 0]
   [0, 1]
   []
// 1 -> 0 -> 1 = return false

0 --> 1
1--> 0

5
outdegrees
0: {1, 2} = 2
1: {3, 4} = 2
3: {4, 2} = 2

indegrees
0: 0
[[0, 1], [0, 2], [1, 3], [1, 4], [3, 4], [3, 2]]

           0              1
         /   \          /
        1     2        0
       /  \  /
      4 -- 0


// track keep of elements in the stack, that's element's we are still visiting
courses
0: {1, 2}
1: {3, 4}
3: {4, 2}

if el has been visited, return false;; we are trying to visit an already course
visited = [0, 1, 4];
inRecursiveStack = [] // keep tracks of elements

[1, 0][0, 1]
1: {0}
0: {1}


public boolean canFinish(int numCourses, int[][] prerequisites) {

    }

  // provide value for new key which is absent
        // using computeIfAbsent method
        map.computeIfAbsent(40, k -> "Sanjeet");

// courses: 1, 0
for (int course: courses.getKeys()) {
  if (!dfs(course)) return false;
}
return true;

visited = [1, 0]
*/
