package medium;

import java.util.*;

public class TreasureHunt {

  // String API = "https://findtreasure.app/api/v1/contestants/register";
  Scanner input = new Scanner(System.in);

  public TreasureHunt() {  
    int res = BFS(); 
    System.out.print("You found ");
    System.out.print(res);
    System.out.print(" treasures");
    System.out.println();
  }

  int BFS() {
    int treasureFound = 0;
    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    System.out.println("Enter input url");
    String startUrl = input.nextLine();
    queue.add(startUrl);

    while (!queue.isEmpty()) {
      String cur = queue.poll();
      System.out.println("Visit " + cur);
      String[] curArr = cur.split("/");
      String curEnd = curArr[curArr.length - 1];
      visited.add(curEnd);
      
      System.out.println("is treasureFound? (y/n)");
      String treasure = input.nextLine();
      if (treasure.equals("y")) treasureFound++;

      System.out.println("Enter paths array");
      String[] paths = input.nextLine().split(",");

      for (int i = 0; i < paths.length; i++) {
        String[] path = paths[i].split("/");
        String end = path[path.length - 1];
        if (!visited.contains(end) && !paths[i].equals((""))) {
          queue.add(paths[i]);
        }
      }
    }
    return treasureFound;
  }
  public static void main(String[] args) {
    TreasureHunt hunt = new TreasureHunt();
  }
}
/**
"https://findtreasure.app/api/v1/games/test/8316a24e-d716-4cc5-8c28-7353e4a62079","https://findtreasure.app/api/v1/games/test/10bd1864-3657-4a85-8c92-7d46e0985115","https://findtreasure.app/api/v1/games/test/ddd3abbe-495c-484a-bc9f-fe94c1988afa","https://findtreasure.app/api/v1/games/test/3abec613-a2fe-41e9-83d2-8a62e0681e10","https://findtreasure.app/api/v1/games/test/start"     */