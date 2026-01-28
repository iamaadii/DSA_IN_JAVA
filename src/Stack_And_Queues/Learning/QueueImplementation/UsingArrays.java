package Stack_And_Queues.Learning.QueueImplementation;

class UsingArrays {
    int arr[];
    int front, rear, size;

    UsingArrays(int size) {
        this.size = size;
        arr = new int[size];
        front = 0;
        rear = -1;
    }

    void enqueue(int x) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        arr[++rear] = x;
    }

    int dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return arr[front++];
    }

    int peek() {
        if (front > rear) return -1;
        return arr[front];
    }
}

