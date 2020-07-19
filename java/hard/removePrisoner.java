package hard;

/**return all paths to an end node, visiting each node other than the start
node, once; eg
          [1]  [2]  [3]  [4 -> end
          [5]  [6]  [7]  [8]
          [9]  [10] [11] [12]
 start -> 13] [14] [15] [16]

has 8 paths :
[
[13, 9, 13, 14, 10, 6, 5, 1, 2, 3, 7, 11, 15, 16, 12, 8, 4, ]
[13, 9, 13, 14, 10, 11, 15, 16, 12, 8, 7, 6, 5, 1, 2, 3, 4, ]
[13, 9, 13, 14, 15, 16, 12, 8, 7, 11, 10, 6, 5, 1, 2, 3, 4, ]
[13, 9, 13, 14, 15, 16, 12, 11, 10, 6, 5, 1, 2, 3, 7, 8, 4, ]
[13, 14, 13, 9, 5, 1, 2, 3, 7, 6, 10, 11, 15, 16, 12, 8, 4, ]
[13, 14, 13, 9, 5, 1, 2, 6, 10, 11, 15, 16, 12, 8, 7, 3, 4, ]
[13, 14, 13, 9, 10, 6, 5, 1, 2, 3, 7, 11, 15, 16, 12, 8, 4, ]
[13, 14, 13, 9, 10, 11, 15, 16, 12, 8, 7, 6, 5, 1, 2, 3, 4, ]
]
 */
import java.util.*;

class Main {
  static private LinkedList<Deque<Integer>> res;
  static private int start;
  static private int end;
  static private int[][] grid;

  static public LinkedList<Deque<Integer>> allPossibleWays(int[][] input) {
    // defensive copy of grid
    grid = new int[input.length][input[0].length];
	  for (int i = 0; i < grid.length; i++) {
		  for (int j = 0; j < grid[0].length; j++) {
			  grid[i][j] = input[i][j];
		  }	
	  }
	  res = new LinkedList<>();
	  final int[] left_bottom = { grid.length - 1, 0 };
	  start = grid[grid.length - 1][0];
	  end = grid[0][grid[0].length - 1];
    dfs(left_bottom, new LinkedList<>(), new boolean[input.length][input[0].length]);
    return res;
  }

  static private void dfs(int[] cell, Deque<Integer> path, boolean[][] visited) {
	  final int row = cell[0]; int col = cell[1];
	  final int current = grid[row][col];
	  visited[row][col] = true;
    path.push(current);

	  if (current == end) {
      if (path.size() >= grid.length * grid.length) {
        Deque<Integer> cur_path = new LinkedList<>();
        for (Integer el : path) {
          cur_path.add(el);
        }
        res.add(cur_path);
      } else {
        path.pop();
        visited[row][col] = false;
        return;
      }
    }

	  // dfs into each of the 4 neighs
	  for (int x = -1; x < 2; x++) {
		  for (int y = -1; y < 2; y++) {
			  if (x == y || x == -y) continue; // eliminate diagonal sections
			  int next_row = row + x, next_col = col + y;
        
        if (!isValid(next_row, next_col)) continue;
        
        if (!visited[next_row][next_col] || grid[next_row][next_col] == start) {
          int[] next_cell = {next_row, next_col};
				  dfs(next_cell, path, visited);
			  }
		  }	
    }
    visited[row][col] = false;
    path.pop();
  }
  
  static private boolean isValid(final int row,final int col) {
  	if (row >= 0 && row < grid.length && col >= 0 && col < grid.length) return true;
	  return false;
  }
  static public void main( String args[] ) {
    int[][] input = new int[4][4];
    int count = 1;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        input[i][j] = count++;
      }
    }
    LinkedList<Deque<Integer>> res = Main.allPossibleWays(input);
    System.out.println("[");
    for (Deque<Integer> deque : res) {
      System.out.print("[");
      for (int i = 0; i <= 16; i++) {
        System.out.print(deque.pollLast());
        System.out.print(", ");
      }
      System.out.println("]");
    }
    System.out.println("]");
  }
}

/**

visited = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

result = [ [], [], .... [] ]

[1]  [2]  [3]  [4 ->
[5]  [6]  [7]  [8]
[9]  [10] [11] [12]
[13] [14] [15] [16]

13 -> 9 -> 13 -> 14 -> 

13 -> 14 -> 13 -> 9 ->

neigh = 4;

start = 13
start_cell = [3,0]

end = 4
end_cell = [0, 3]

visited = new boolean[4][4];
// up left down
res = [];

[1]  [2]  [3]  [4 ->
[5]  [6]  [7]  [8]
[9]  [10] [11] [12]
[13] [14] [15] [16]

    (3, 0)
dfs(cell, path, grid):
  row, col = cell
  visited[row][col] = true;
  path.append(cell)
  if (grid[row, col] == 4 and path.size() == 16) {
    res.add(path.clone());
  }

  for x in range(-1, 2):
    for y in range(-1, 2):
      (-1, -1), (-1, 0), (-1, 1)
      (0, -1),  (0, 0),  (0, 1)
      (1, -1),  (1, 0),  (1, 1)
      if x == y or x == -y:
        continue
      new_r = r + x
      new_c = c + y
      if 0 <= new_r < len(grid) and 0 <= new_c < len(grid[0]):
       if !isVisited(new_r, new_c) or grid[new_r][new_c] == 13:
          dfs([new_r, new_c], path, grid)

  path.pop();
  visited[row][col] = false;
  if grid[row][col] == 13 return res;
}

*/