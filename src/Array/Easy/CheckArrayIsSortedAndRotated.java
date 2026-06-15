package Array.Easy;

public class CheckArrayIsSortedAndRotated {
    public static void main(String[] args) {
        int[] arr = {2,1,3,4};
        System.out.println(optimal1(arr));
    }





    static boolean optimal1(int[] arr) {
        int i = 1;
        int n = arr.length;
        while(i<n && arr[i]>=arr[i-1]){
            i+=1;
        }
        if(i==n) return true;
        if(arr[i]>arr[0]) return false;
        i+=1;
        while(i<n){
            if(arr[i]>arr[0] || arr[i]<arr[i-1]) {
                return false;
            }
            i+=1;
        }
        return true;
    }






    static boolean optimal2(int[] arr){
        int count=0;
        for (int i=1;i<arr.length;i++){
            if (arr[i]<arr[i-1]){
                count+=1;
            }
        }
        if (arr[arr.length-1]>arr[0]) count+=1;
        return count<=1;
    }
}
