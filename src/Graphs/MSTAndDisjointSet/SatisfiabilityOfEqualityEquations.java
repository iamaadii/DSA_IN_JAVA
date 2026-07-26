/*
You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.
Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.
*/

/*
Process equality equation first & then un-equality equation. Try to solve it using DSU.
*/

package Graphs.MSTAndDisjointSet;

public class SatisfiabilityOfEqualityEquations {
    static class DSU {
        int[] size;
        int[] parent;

        int ultimate(int node){
            if(parent[node]==node){
                return node;
            }
            return parent[node] = ultimate(parent[node]);
        }

        void union(int u, int v){
            int ultimateU = ultimate(u);
            int ultimateV = ultimate(v);

            if(ultimateU==ultimateV) return;

            int sizeU = size[ultimateU];
            int sizeV = size[ultimateV];
            if(sizeU<sizeV){
                parent[ultimateU] = ultimateV;
                size[ultimateV] += size[ultimateU];
            }
            else{
                parent[ultimateV] = ultimateU;
                size[ultimateU] += size[ultimateV];
            }
        }

        DSU(int n) {
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i<n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }
    }

    public boolean equationsPossible(String[] equations) {
        DSU d = new DSU(26);
        for(String s: equations){
            if(s.charAt(1)=='='){
                d.union(s.charAt(0)-'a',s.charAt(3)-'a');
            }
        }
        for(String s: equations){
            if(s.charAt(1)=='!'){
                int uParent = d.ultimate(s.charAt(0)-'a');
                int vParent = d.ultimate(s.charAt(3)-'a');

                if(uParent==vParent) return false;
            }
        }
        return true;
    }
}
