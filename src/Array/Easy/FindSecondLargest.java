package Array.Easy;

public class FindSecondLargest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4};
        System.out.println(better(arr));
        System.out.println(optimal(arr));
    }



    static int better(int[] arr){
        int n = arr.length;
        int largest=arr[0];
        for (int i=1;i<n;i++){
            if (arr[i]>largest) largest=arr[i];
        }

        int secondLargest = -1;
        for (int e: arr){
            if (e>secondLargest && e<largest){
                secondLargest=e;
            }
        }
        return secondLargest;
    }






    static int optimal(int[] arr){
        int largest = arr[0],secondLargest=-1;
        for (int i=1;i<arr.length;i++){
            if (arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];
            }
            else if(arr[i]>secondLargest && arr[i]<largest) secondLargest=arr[i];
        }
        return secondLargest;
    }
}
