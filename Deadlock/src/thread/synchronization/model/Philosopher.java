package thread.synchronization.model;

import java.util.Timer;

/**
 * Created by Khue DZ on 11/4/2017.
 */
public class Philosopher extends Thread {
    private static int noOfPhilosophers = 0;
    Timer timer;
    private int id;
    private Choptick leftChoptick;
    private Choptick rightChoptick;
    private ChoptickPair choptickPair = new ChoptickPair();
    private long time = 0;

    public Philosopher() {
        this.id = noOfPhilosophers++;
    }

    private void pickLeftChoptick() {
        if (null == leftChoptick) {
            leftChoptick = choptickPair.getChoptickOnLeft(id);
            if (null != leftChoptick)
                System.out.println("Philo " + id + " has picked left choptick");
        }
    }

    private void pickRightChoptick() throws InterruptedException {
        if (null == rightChoptick) {
            while (null == rightChoptick && time != 15) {
                rightChoptick = choptickPair.getChoptickOnRight(id);
                if (null != rightChoptick)
                    System.out.println("Philo " + id + " has picked right choptick");
                initTimer();
            }
        }
    }

    private void putdownChoptick() {
        if (null != leftChoptick) leftChoptick.putdownChoptick();
        if (null != rightChoptick) rightChoptick.putdownChoptick();
        leftChoptick = null;
        rightChoptick = null;
    }

    private void eat() throws InterruptedException {
        pickLeftChoptick();
        Thread.currentThread().sleep(1);
        pickRightChoptick();
        if (availableChoptick()) {
            time = 0;
            System.out.println("philosopher " + id + " has started eating...");
            Thread.currentThread().sleep(2000);
            System.out.println("philosopher " + id + " has finished eating");
            putdownChoptick();
        }
    }

    private boolean availableChoptick() {
        return null != leftChoptick && null != rightChoptick;
    }

    void initTimer() throws InterruptedException {
        Thread.sleep(1000);
        time++;
    }


    @Override
    public void run() {
        System.out.println("Thread for philosopher " + id + " started");
        while (time != 15) {
            try {
                eat();
                Thread.currentThread().sleep(time != 15 ? 10000 : 0);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Philosopher " + id + " dead");
    }
}
