public class Main {

    public static void main(String[] args) throws FullException, EmptyException {


        CQueue<Integer> cQueue = new CQueue<Integer>(3);

        cQueue.enqueue(1);
        cQueue.enqueue(2);
        cQueue.enqueue(3);

        System.out.println(cQueue.first());
        cQueue.dequeue();
        System.out.println(cQueue.first());
        cQueue.dequeue();
        System.out.println(cQueue.first());
        cQueue.dequeue();
        cQueue.enqueue(4);
        System.out.println(cQueue.first());
    }
}
