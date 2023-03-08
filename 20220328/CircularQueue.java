public class CircularQueue{
    int front = 0;
    int rear = 0;
    String[] elements;

    public CircularQueue(int maxQueueSize){

    }

    public boolean isFull(){
        return front == (rear + 1) % this.elements.length;
    }

    public CircularQueue add(String item){
        if(this.isFull()){
            throw new RuntimeException("Queue is full!");
        }

        this.rear = (this.rear + 1) % this.elements.length;
        this.elements;
    }

    public static void main(String[] args){
        System.out.println("Hello");
    }
}
