// GFG
/*
Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]

Output: [0, 2, 3, 1, 4]
*/
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class BFSSolution {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[adj.size()]; // adj.size() returns no. of vertices.
    
        q.add(0); // add first vertex (ADD INTEGER)
        
        // visit vertices neighbourwise
        while(!q.isEmpty()) {
            int curr = q.remove();
            
            if(!vis[curr]) {
                result.add(curr);
                // traverse the current's neighbors 
                for(int i = 0; i < adj.get(curr).size(); i++) {
                    int ngbr = adj.get(curr).get(i);
                    if(!vis[ngbr]) {
                        q.add(ngbr);
                    }
                }
                vis[curr] = true; // mark as visited.
            }
        }
        return result;
    }
}