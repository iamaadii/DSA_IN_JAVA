/*
Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
*/

package Graphs.MSTAndDisjointSet;
import java.util.*;
public class AccountsMerged {
    static class Disjoint{
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        Disjoint(int n) {
            for (int i = 0; i < n; i++) {
                size.add(1);
                parent.add(i);
            }
        }
        int findUltimateParent(int node){
            if (node== parent.get(node)){
                return node;
            }
            int up = findUltimateParent(parent.get(node));
            parent.set(node,up);
            return parent.get(node);
        }

        void unionBySize(int u, int v){
            int ultimateU = findUltimateParent(u);
            int ultimateV = findUltimateParent(v);

            if (ultimateV==ultimateU) {
                return;
            }

            int sizeU = size.get(ultimateU);
            int sizeV = size.get(ultimateV);

            if(sizeV < sizeU){
                parent.set(ultimateV,ultimateU);
                size.set(ultimateU,sizeU+sizeV);
            }
            else{
                parent.set(ultimateU,ultimateV);
                size.set(ultimateV,sizeV+sizeU);
            }
        }
    }
    static List<List<String>> optimal(List<List<String>> accounts) {
        int n = accounts.size();
        Disjoint obj = new Disjoint(n);
        HashMap<String,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!mp.containsKey(mail)) mp.put(mail,i);
                else obj.unionBySize(i,mp.get(mail));
            }
        }

        ArrayList<String>[] merged = new ArrayList[n];
        for(int i=0;i<n;i++) merged[i] = new ArrayList<>();
        for(Map.Entry<String,Integer> e: mp.entrySet()){
            String mail = e.getKey();
            int ind = obj.findUltimateParent(e.getValue());
            merged[ind].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(merged[i].isEmpty()) continue;
            Collections.sort(merged[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(merged[i]);
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> l = new ArrayList<>();
        l.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        l.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        l.add(Arrays.asList("Mary","mary@mail.com"));
        l.add(Arrays.asList("John","johnnybravo@mail.com"));

        System.out.println(optimal(l));
    }
}
