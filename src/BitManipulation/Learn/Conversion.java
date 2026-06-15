package BitManipulation.Learn;

public class Conversion {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(numberToBinary(n));
        System.out.println(binaryToNumber("1101"));
        System.out.println(13 & 7);
    }

    static String numberToBinary(int n){
        StringBuilder sb = new StringBuilder();
        while (n>0){
            if (n%2==0) sb.append(0);
            else sb.append(1);
            n=n/2;
        }
        sb.reverse();
        return sb.toString();
    }



    static int binaryToNumber(String s){
        int num=0;
        int n = s.length();
        int temp = 1;
        for (int i=n-1;i>=0;i--){
            if (s.charAt(i)=='1'){
                num = num + temp;
            }
            temp = temp*2;
        }
        return num;
    }



}

// 13-> 1 6 -> 0  3->1 1
