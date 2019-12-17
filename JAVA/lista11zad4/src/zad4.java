import java.util.concurrent.Semaphore;

class program {
    private Semaphore odzwierny = new Semaphore(4, true);
    private paleczka[] paleczki = new paleczka[5];
    private filozof[] filozofowie = new filozof[5];


    class filozof extends Thread {
        private paleczka left;
        private paleczka right;

        public filozof(paleczka left, paleczka right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public void run() {
            try {
                while(true){
                    medytuj();
                    jedz();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void medytuj() throws InterruptedException {
            sleep((int) (Math.random()* 2));

        }

        public void jedz() throws InterruptedException {
            odzwierny.acquire();
            left.wez();
            right.wez();
            System.out.println(Thread.currentThread().getName() + " je");
            left.odloz();
            right.odloz();
            odzwierny.release();

        }
    }

    class paleczka {
        Semaphore stickSem = new Semaphore(1);

        public void wez() throws InterruptedException {
            stickSem.acquire();
        }

        public void odloz() {
            stickSem.release();
        }
    }

    public void simulation() {
        for (int i = 0; i < 5; i++) {
            paleczki[i] = new paleczka();
        }

        for (int i = 0; i < 5; i++) {
            filozofowie[i] = new filozof(paleczki[i], paleczki[(i + 1) % 5]);
        }

        for (int i = 0; i < 5; i++) {
            filozofowie[i].start();
        }
    }


    public static void main(String[] args) {
        program program = new program();
        program.simulation();
    }
}