package com.algopractice.problemsolving;


public class ThreadingOddEven {
    static int N;
    int counter = 1;
    public static void main(String[] args) {
        N = 10;
        ThreadingOddEven threadingOddEven = new ThreadingOddEven();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadingOddEven.printEvenNo();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadingOddEven.printOddNo();
            }
        });
        t1.start();
        t2.start();
    }

    private void printOddNo() {
        synchronized (this) {
            while(counter < N) {
                while(counter%2 ==0) {
                    try {
                        wait();
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
                System.out.println(counter + " ");
                counter++;
                notify();
            }
        }

    }

    private void printEvenNo() {
        synchronized (this){
            while(counter < N) {
                while (counter % 2 == 1){
                    try {
                        wait();
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
                System.out.println(counter + " ");
                counter++;
                notify();
            }
        }
    }
}
