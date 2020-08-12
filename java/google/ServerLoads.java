package google;

class Main {
  public static int serverLoads(int[] loads) {
    int loadSum = 0;
    for (int load : loads) {
      loadSum += load;
    }
    return serverLoadsHelper(loads, 0, loadSum, loadSum, 0);
  }
  
  private static int serverLoadsHelper(int[] loads, int idx, int loadSum, int min, int server1Sum) {
    if (idx == loads.length) return min;
    
    int curMin = min;
    
    for (int i = idx; i < loads.length; i++) {
      server1Sum += loads[i];
      curMin = Math.min(curMin, Math.abs(loadSum - 2*server1Sum));
      curMin = serverLoadsHelper(loads, idx+1, loadSum, curMin, server1Sum);
      server1Sum -= loads[i];
    }
    
    return curMin;
  }
  static public void main( String args[] ) {
    int[] input = new int[]{1,1,1,1,9};
    System.out.println(Main.serverLoads(input));
  }
}

/*
There are some processes that need to be executed. 
Amount of a load that process causes on a server that runs it, 
is being represented by a single integer. 
Total load caused on a server is the sum of the loads of all the processes that run on that server. 
You have at your disposal two servers, on which mentioned processes can be run. 
Your goal is to distribute given processes between those two servers in the way that, 
absolute difference of their loads will be minimized.

Given an array of n integers, of which represents loads caused by successive processes, 
return the minimum absolute difference of server loads.

Example 1:

Input: [1, 2, 3, 4, 5]
Output: 1
Explanation:
We can distribute the processes with loads [1, 2, 4] to the first server and [3, 5] to the second one,
so that their total loads will be 7 and 8, respectively, and the difference of their loads will be equal to 1.

server1 = 0, server2 = 0

[1, 1, 1, 1, 1, 9]
15
[1, 2, 3, 4, 5]
    ^
[1,3]

15
[1, 2, 3, 4, 5]
    ^
    
                      [1, 5, 3, 6]
                      
                                   
                                1|                       5|          3|          6|
                         5|     3|      6|          3|      6|       6|
                      3|   |6   6|                  6|
                      6|            
                      
                      
             1st lvl => {[1] [5] [3] [6]}
                  
             2nd lvl => {[1,5] [1,3] [1,6] | [5,3] [5,6] | [3,6]}
             
             3rd lvl => {[1,5,3] [1,5,6] [1,3,6] | [5,3,6]}
             
             4th lvl => {[]} neglect

from sys import maxsize

class Solution:
  def findMin(self, loads, start, totalLoads, sumServer2):
    if start >= len(loads):
      return
    
    for i in range(start, len(loads)):
      sumServer2 += loads[i]
      self.min = min(self.min, abs(totalLoads - 2*sumServer2))
      self.findMin(loads, i+1, totalLoads, sumServer2)
      sumServer2 -= loads[i]

  def serverLoads(self, loads):
    self.min = maxsize
    totalLoad = sum(loads)
    self.findMin(loads, 0, totalLoad, 0)
    return self.min
  
loads = [1, 2, 3, 4, 5]
loads = [7, 6, 2, 2, 9]
# loads = [9]
s = Solution()

                              
                              
                              
                              
                              
                              
                               5
                             2| 3| 
                             3  2
                          x 3|
                            0
    
                                   [1, 2, 3]
                               
                                      {}
                                 /          \
                                {1}          {}
                               /    \      /    \
                           {1,2}   {1}    {2}    {}
                           /   \  /   \  /  \   /   \
                           
              1st {1,2,3} {1,2} {1,3} {1} {2,3} {2}   {3}    {}
              2nd   x      {3}   {2} {2,3} {1} {1,3} {1,2}   x
                              
*/
