/*
Given two sorted arrays a[] and b[], find and return the median of the combined array after merging them into
a single sorted array.

Constraints:
1 ≤ a.size(), b.size() ≤ 10^6
1 ≤ a[i], b[i] ≤ 10^9
a.size() + b.size() > 0
*/
package BinarySearch.OnAnswers;

public class MedianOftwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,3,4,7,10,12};
        int[] arr2 = {2,3,6,15};
        System.out.println(bruteForce(arr1,arr2));
        System.out.println(betterSolution(arr1,arr2));
        System.out.println(optimal(arr1,arr2));
    }

    static double bruteForce(int[] a, int[] b){
        int n1 = a.length, n2 = b.length;
        int arr3[] = new int[n1+n2];

        int i=0,j=0,k=0;
        while (i<n1 && j<n2){
            if(a[i]<b[j])  arr3[k++] = a[i++];
            else arr3[k++] = b[j++];
        }
        while (i<n1) arr3[k++] = a[i++];
        while (j<n2) arr3[k++] = b[j++];

        int m = arr3.length;
        int mid = m/2;
        if(m % 2 == 0){
            return (arr3[mid]+(arr3[mid-1]))/2.0;
        }
        return arr3[mid];
    }




    static double betterSolution(int[] a, int[] b){
        int n1 = a.length, n2 = b.length;
        int ind2 = (n1+n2)/2, ind1 = ind2-1;
        int ind1e=0, ind2e=0;
        int count = 0;

        int i=0, j=0;
        while (i<n1 && j<n2){
            if(a[i]<b[j]){
                if(count==ind1) ind1e = a[i];
                if(count==ind2) ind2e = a[i];
                i++; count++;
            }
            else{
                if(count==ind1) ind1e = b[j];
                if(count==ind2) ind2e = b[j];
                j++; count++;
            }
        }
        while (i<n1){
            if(count==ind1) ind1e = a[i];
            if(count==ind2) ind2e = a[i];
            i++; count++;
        }
        while (j<n2){
            if(count==ind1) ind1e = b[j];
            if(count==ind2) ind2e = b[j];
            j++; count++;
        }
        if((n1+n2)%2==1) return ind2e;
        return (ind1e+ind2e)/2.0;
    }





    static double optimal(int[] a, int[] b){
        int n1=a.length, n2=b.length;

        if(n1>n2) return optimal(b,a);

        int n = n1+n2;
        int left = (n + 1) / 2;
        int low = 0, high = n1;
        while (low<=high){
            int mid1 = low+(high-low)/2;
            int mid2 = left-mid1;

            int l1 = Integer.MIN_VALUE, l2=Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1<n1) r1=a[mid1];
            if (mid2<n2) r2=b[mid2];
            if (mid1-1>=0) l1 = a[mid1-1];
            if (mid2-1>=0) l2 = b[mid2-1];

            if (l1<=r2 && l2<=r1){
                if (n%2==1) return Math.max(l1,l2);
                return ( Math.max(l1,l2) + Math.min(r1,r2) )/ 2.0;
            }
            else if (l1>r2) high=mid1-1;
            else low=mid1+1;
        }
        return 0;
    }
}
