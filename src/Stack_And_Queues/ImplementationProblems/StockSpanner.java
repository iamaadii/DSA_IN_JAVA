/*
Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.

For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.
*/
package Stack_And_Queues.ImplementationProblems;
import java.util.*;



public class StockSpanner {
    static class Pair{
        int value;
        int index;
        Pair(int v,int i){
            value = v;
            index = i;
        }
    }
    static Stack<Pair> st;
    static int count;
    public StockSpanner() {
        st = new Stack<>();
        count = -1;
    }

    public int next(int price) {
        count += 1;
        while(!st.isEmpty() && st.peek().value <= price){
            st.pop();
        }
        int ans = count - (st.isEmpty() ? -1 : st.peek().index);
        st.push(new Pair(price,count));
        return ans;
    }

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}
