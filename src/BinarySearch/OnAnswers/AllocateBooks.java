/*
Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book.
You also have an integer k representing the number of students. The task is to allocate books to each student such that:
    Each student receives at least one book.
    Each student is assigned a contiguous sequence of books.
    No book is assigned to more than one student.

The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations,
find the arrangement where the student who receives the most pages still has the smallest possible maximum.

Note: If it is not possible to allocate books to all students, return -1.

Constraints:
1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i], k ≤ 10^3
*/

package BinarySearch.OnAnswers;

public class AllocateBooks {
    public static void main(String[] args) {
        int[] arr = {25,46,28,49,24};
        int k = 4;
        System.out.println(bruteForce(arr,k));
        System.out.println(optimal(arr,k));
    }

    static int bruteForce(int[] arr, int k){
        if(k> arr.length) return -1;

        int min = arr[0];
        int max = 0;
        for (int e:arr) {
            min = Math.max(e,min);
            max += e;
        }

        for (int i=min;i<=max;i++){
            int allocatedStudents = 1, sum=arr[0];
            for (int j=1;j< arr.length;j++){
                sum+=arr[j];
                if(sum>i){
                    allocatedStudents += 1;
                    sum = arr[j];
                }
            }
            if(allocatedStudents==k) return i;
        }
        return -1;
    }


    static int optimal(int[] arr, int k){
        if(k> arr.length) return -1;

        int low = arr[0];
        int high = 0;
        for (int e:arr) {
            low = Math.max(e,low);
            high += e;
        }

        int ans = low;

        while (low<=high){
            int mid = low+(high-low)/2;
            int allocatedStudents = 1, sum=arr[0];
            for (int j=1;j< arr.length;j++){
                sum+=arr[j];
                if(sum>mid){
                    allocatedStudents += 1;
                    sum = arr[j];
                }
            }
            if(allocatedStudents<=k){
                ans = mid;
                high=mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
}
