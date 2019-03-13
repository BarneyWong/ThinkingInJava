package concurrent;

import java.util.concurrent.TimeUnit;

public class Exercise15 {
    public static class Sync1 {
        public void f1() {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("f1()");
                    Thread.yield();
                }
            }
        }

        public void g1() {
            synchronized (this) {
                for (int j = 0; j < 5; j++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("g1()");
                    Thread.yield();
                }
            }
        }

        public void h1() {
            synchronized (this) {
                for (int k = 0; k < 5; k++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("h1()");
                    Thread.yield();
                }
            }
        }
    }

    public static class Sync2 {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        public  void f2(){
            synchronized (obj1){
                for (int i = 0; i < 5; i++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("f2()");
                    Thread.yield();
                }
            }
        }

        public  void g2(){
            synchronized (obj2){
                for (int i = 0; i < 5; i++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("g2()");
                    Thread.yield();
                }
            }
        }
        public  void h2(){
            synchronized (obj3){
                for (int i = 0; i < 5; i++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("h2()");
                    Thread.yield();
                }
            }
        }


    }

    public static void main(String[] args) {
        Sync1 sync11 = new Sync1();
        Sync2 sync2 = new Sync2();
        new Thread(() -> {
            sync11.f1();
        }).start();

        new Thread(() -> {
            sync11.g1();
        }).start();
        new Thread(() -> {
            sync11.h1();
        }).start();
        new Thread(() -> {
            sync2.f2();
        }).start();

        new Thread(() -> {
            sync2.g2();
        }).start();
        new Thread(() -> {
            sync2.h2();
        }).start();
    }
}
