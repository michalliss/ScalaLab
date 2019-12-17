import java.util.concurrent.Semaphore;

class IntCell3 {
    private int n = 0;
    private Semaphore semaphore = new Semaphore(1);

    public int getN() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return n;
    }

    public void setN(int n) {
        this.n = n;
        semaphore.release();
    }
}

class Count3 extends Thread {
    private static IntCell3 n = new IntCell3();
    private static Semaphore semaphore = new Semaphore(1);

    @Override
    public void run() {
        int temp;
        for (int i = 0; i < 200000; i++) {
            //try { semaphore.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }
            temp = n.getN();
            n.setN(temp + 1);
            //semaphore.release();
        }
    }

    public static void main(String[] args) {
        Count3 p = new Count3();
        Count3 q = new Count3();
        p.start();
        q.start();
        try {
            p.join();
            q.join();
        } catch (InterruptedException e) {
        }
        System.out.println("The value of n is " + n.getN());
    }
}