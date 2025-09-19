/*
Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the
kth position of the combined sorted array.

Constraints:
1 ≤ a.size(), b.size() ≤ 10^6
1 ≤ k ≤ a.size() + b.size()
0 ≤ a[i], b[i] ≤ 10^8
*/
package BinarySearch.OnAnswers;

public class kthElement {
    public static void main(String[] args) {
        int[] arr1 = {1,3,4,7,10,12};
        int[] arr2 = {2,3,6,15};
        int k = 4;
        System.out.println(bruteForce(arr1,arr2,k));
        System.out.println(betterSolution(arr1,arr2,k));
        System.out.println(optimal(arr1,arr2,k));
    }

    static int bruteForce(int[] a, int[] b,int k){
        int n1 = a.length, n2 = b.length;
        int arr3[] = new int[n1+n2];

        int i=0,j=0,l=0;
        while (i<n1 && j<n2){
            if(a[i]<b[j])  arr3[l++] = a[i++];
            else arr3[l++] = b[j++];
        }
        while (i<n1) arr3[l++] = a[i++];
        while (j<n2) arr3[l++] = b[j++];
        return arr3[k-1];
    }




    static int betterSolution(int[] a, int[] b, int k){
        int n1 = a.length, n2 = b.length;
        int ele = 0;
        int count = 0;

        int i=0, j=0;
        while (i<n1 && j<n2){
            if(a[i]<b[j]){
                if(count==k-1) ele = a[i];
                i++; count++;
            }
            else{
                if(count==k-1) ele = b[j];
                j++; count++;
            }
        }
        while (i<n1){
            if(count==k-1) ele = a[i];
            i++; count++;
        }
        while (j<n2){
            if(count==k-1) ele = b[j];
            j++; count++;
        }
        return ele;
    }





    static int optimal(int[] a, int[] b, int k){
        int n1=a.length, n2=b.length;

        if(n1>n2) return optimal(b,a,k);

        int low = Math.max(0,k-n2), high = Math.min(n1,k);
        int left = k;
        while (low<=high){
            int mid1 = low+(high-low)/2;
            int mid2 = left-mid1;

            int l1 = Integer.MIN_VALUE, l2=Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1<n1) r1=a[mid1];
            if (mid2<n2) r2=b[mid2];
            if (mid1-1>=0) l1 = a[mid1-1];
            if (mid2-1>=0) l2 = b[mid2-1];

            if (l1<=r2 && l2<=r1)  return Math.max(l1,l2);
            else if (l1>r2) high=mid1-1;
            else low=mid1+1;
        }
        return 0;
    }
}
