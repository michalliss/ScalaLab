package zad3;

public class BoundedBuffer implements Produce, Consume {
    final private int N;
    private int in = 0, out = 0, n = 0;
    private int[] elems;

    public BoundedBuffer(int N) {
        this.N = N; elems = new int[N]; 
    }

    public void print(){
        System.out.println("Status: n = " + n);
    }

    public synchronized void put(int x) {
        while (n >= N) 
          try {
        	  System.out.println(Thread.currentThread().getName()+" waiting with " + x+" n " + n);
        	  wait(); 
          } catch (InterruptedException e) {System.out.println(e);}
        elems[in] = x; in = (in + 1) % N ; n += 1; 
        System.out.println(Thread.currentThread().getName()+" produced: " + x + " n " + n);
       if (n == 1)
        notifyAll();
    }

    public synchronized int take() {
        while (n == 0)
          try {
        	  System.out.println(Thread.currentThread().getName()+" waiting"); 
        	  wait(); 
          } catch (InterruptedException e) {System.out.println(e);}
        int x = elems[out]; out = (out + 1) % N ; n -= 1;
        System.out.println(Thread.currentThread().getName()+" consuming: " + x+" n " + n);

        if (n == N-1)
        notifyAll();
        return x;
    }
}

