package Stack_And_Queues.Learning.QueueImplementation;

public class UsingCircularArrays {
    int[] queue;
    int size,currSize;
    int front, rear;

    UsingCircularArrays(int n){
        queue = new int[n];
        size = n;
        front = -1;
        rear=-1;
        currSize = 0;
    }

    void add(int element){
        if(currSize==size){
            System.out.println("Queue Overflow");
            return;
        }
        else if (front==-1 && rear==-1){
            front = 0; rear=0;
        }
        else {
            rear = (rear+1)%size;
        }
        queue[rear] = element;
        currSize +=1;
    }

    int poll(){
        if (currSize==0){
            System.out.println("Queue Underflow");
            return -1;
        }
        int element = queue[front];
        if(front==rear){
            front=-1; rear=-1;
        }
        else front = (front+1)%size;
        currSize -= 1;
        return element;
    }

    int peek(){
        if (currSize==0) return -1;
        return queue[front];
    }

    boolean isEmpty(){
        return currSize==0;
    }

    boolean isFull(){
        return currSize==size;
    }

    int Size(){
        return currSize;
    }

    public static void main(String[] args) {

    }
}
