package Stack_And_Queues.Learning.StackImplementation;

public class UsingArrays {
    int top;
    int[] stack;
    int size;

    UsingArrays(int n){
        top = -1;
        stack = new int[n];
        size = n;
    }

    void push(int element){
        if(top==size-1){
            System.out.println("Stack overflow");
            return;
        }
        stack[++top] = element;
    }
    int pop(){
        if(top==-1){
            System.out.println("stack underflow");
            return -1;
        }
        return stack[top--];
    }

    int peek(){
        if (top==-1) return -1;
        return stack[top];
    }
    int size(){
        return top+1;
    }
    boolean isEmpty(){
        return top == -1;
    }
    boolean isFull(){
        return top==size-1;
    }

    public static void main(String[] args) {
        UsingArrays st = new UsingArrays(5);
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.isEmpty());
        System.out.println(st.isFull());
    }
}
