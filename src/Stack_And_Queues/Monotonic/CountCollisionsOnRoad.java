/*

*/
package Stack_And_Queues.Monotonic;
import java.util.*;
public class CountCollisionsOnRoad {

    public static void better(String str) {
        Stack<Character> st = new Stack<>();
        int totalCollisions = 0;
        for (char c : str.toCharArray()){
            if(c=='R') {
                st.push(c);
            }

            else if(c=='L'){
                if (!st.isEmpty() && st.peek() == 'R') {
                    totalCollisions += 2;
                    st.pop();

                    while (!st.isEmpty() && st.peek() == 'R') {
                        totalCollisions++;
                        st.pop();
                    }
                    st.push('S');
                }
                else if (!st.isEmpty() && st.peek() == 'S') {
                    totalCollisions++;
                }
            }
            else{
                while (!st.isEmpty() && st.peek() == 'R') {
                    totalCollisions++;
                    st.pop();
                }
                st.push('S');
            }
        }
        System.out.println(totalCollisions);
    }







    public static int optimal(String str) {
        int rightCars = 0;
        int collisions = 0;
        boolean hasStationary = false;

        for (char c : str.toCharArray()) {

            if (c == 'R') {
                rightCars++;
            }

            else if (c == 'S') {
                collisions += rightCars;
                rightCars = 0;
                hasStationary = true;
            }

            else { // c == 'L'
                if (rightCars > 0) {
                    collisions += rightCars + 1;
                    rightCars = 0;
                    hasStationary = true;
                }
                else if (hasStationary) {
                    collisions += 1;
                }
            }
        }
        return collisions;
    }



    public static void main(String[] args) {
        better("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR");
        System.out.println(optimal("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }
}
