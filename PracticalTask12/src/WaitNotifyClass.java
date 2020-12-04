import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitNotifyClass {

    private char currentLetter;
    private int countOfRepetition;

    public WaitNotifyClass(char currentLetter, int countOfRepetition) {
        this.currentLetter = currentLetter;
        this.countOfRepetition = countOfRepetition;
    }

    public static void main(String[] args) {

        WaitNotifyClass waitNotify = new WaitNotifyClass('A', 5);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(waitNotify.new RunnableClass('A'));
        executorService.execute(waitNotify.new RunnableClass('B'));
        executorService.execute(waitNotify.new RunnableClass('C'));
        executorService.shutdown();

    }

    public synchronized void printLetter(char Letter) {

        for (int i = 0; i < countOfRepetition; i++) {

            while (currentLetter != Letter) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Letter);
            currentLetter = getNextLetter(Letter);
            notifyAll();

        }

    }

    private char getNextLetter(char Letter) {

        if (Letter == 'A')
            return 'B';
        else if (Letter == 'B')
            return 'C';
        else
            return 'A';

    }

    class RunnableClass implements Runnable {

        private char Letter;

        public RunnableClass(char letter) {
            Letter = letter;
        }

        @Override
        public void run() {
            printLetter(Letter);
        }

    }

}
