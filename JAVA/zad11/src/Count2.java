class IntCell2 {
    private int n = 0;
    private boolean set = true;

    public synchronized int getN() {
        while (!set) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        set = false;
        notifyAll();
        return n;
    }

    public synchronized void setN(int n) {
        while (set) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.n = n;
        set = true;
        notifyAll();
    }
}

class Count2 extends Thread {
    private static IntCell2 n = new IntCell2();

    @Override
    public void run() {
        int temp;
        for (int i = 0; i < 200000; i++) {
            System.out.println(i);
            // synchronized (n) {
            temp = n.getN();
            n.setN(temp + 1);
            //}

        }
    }

    public static void main(String[] args) {
        Count2 p = new Count2();
        Count2 q = new Count2();
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