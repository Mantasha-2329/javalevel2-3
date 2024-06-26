import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

 class ConcurrencyDemo {
    private static int sharedResource = 0;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new IncrementTask());
        Thread thread2 = new Thread(new DecrementTask());

        thread1.start();
        thread2.start();
    }

    public static Lock getLock() {
        return lock;
    }

    public static void setLock(Lock lock) {
        ConcurrencyDemo.lock = lock;
    }

    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                lock.lock();
                try {
                    sharedResource++;
                    System.out.println("Incremented: " + sharedResource);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class DecrementTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                lock.lock();
                try {
                    sharedResource--;
                    System.out.println("Decremented: " + sharedResource);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}

