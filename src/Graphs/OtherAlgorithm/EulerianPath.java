/*
You are given a 0-indexed 2D integer array pairs where pairs[i] = [starti, endi]. An arrangement of pairs is valid if for every index i where 1 <= i < pairs.length, we have endi-1 == starti.
Return any valid arrangement of pairs.
Note: The inputs will be generated such that there exists a valid arrangement of pairs.
*/
package Graphs.OtherAlgorithm;
import java.util.*;

public class EulerianPath {

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        for (int[] pair : pairs) {
            int u = pair[0];
            int v = pair[1];
            if (!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(v);
            outDegree.put(u, outDegree.getOrDefault(u, 0) + 1);
            inDegree.put(v,inDegree.getOrDefault(v, 0) + 1);
        }

        int startNode = pairs[0][0];
        for (Integer node : adj.keySet()) {
            if(outDegree.getOrDefault(node,0)-inDegree.getOrDefault(node,0)==1){
                startNode = node;
                break;
            }
        }

        List<Integer> eularPath = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        st.push(startNode);
        while(!st.isEmpty()){
            int node = st.peek();
            if(adj.containsKey(node) && adj.get(node).size() > 0){
                int nei = adj.get(node).getLast();
                adj.get(node).removeLast();
                st.push(nei);
            }else{
                eularPath.add(st.pop());
            }
        }

        int[][] ans = new int[pairs.length][2];
        int j = 0;
        for (int i = eularPath.size()-1; i >0; i--) {
            ans[j][0] = eularPath.get(i);
            ans[j][1] = eularPath.get(i-1);
            j+=1;
        }
        return ans;
    }

}
