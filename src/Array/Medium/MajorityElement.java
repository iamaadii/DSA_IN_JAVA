package Array.Medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
//    public static void main(String[] args) {
//        int[] arr = {2,3,3,3,1,3,2};
//
//        for (int i=0;i<arr.length;i++){
//            int count=0;
//            for(int j=0;j<arr.length;j++){
//                if(arr[i]==arr[j]){
//                    count+=1;
//                }
//            }
//            if(count>(arr.length/2)){
//                System.out.println(arr[i]);
//                break;
//            }
//        }
//    }



//    public static void main(String[] args) {
//        int[] arr = {2,2,3,3,1,2,2};
//        Map<Integer,Integer> m = new HashMap<>();
//
//        for(int i=0;i<arr.length;i++){
//            if(!m.containsKey(arr[i])){
//                m.put(arr[i],1);
//            }
//            else{
//                int freq = m.get(arr[i]);
//                m.put(arr[i],freq+1);
//            }
//        }
//
//        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
//            if(entry.getValue()>(arr.length/2)){
//                System.out.println(entry.getKey());
//                break;
//            }
//        }
//    }


    public static void main(String[] args) {
        int[] arr = {7,7,5,7,1,5,7,5,5,7,7,5,5,5,5 };
        int element = 0;
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            if(count==0){
                element=arr[i];
                count=1;
            }
            else if(arr[i]==element){
                count+=1;
            }
            else{
                count-=1;
            }
        }

        // Only do this step if problem states that array might have and might not have majority element
        int flag=0;
        for(int e:arr){
            if(e==element){
                flag+=1;
            }
        }
        if(flag>(arr.length/2))
            System.out.println(element);
    }
}
