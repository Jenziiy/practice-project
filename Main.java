class A extends Thread {

  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println("hello thread 1 here!");
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class B extends Thread {

  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println("hello thread 2 here!");
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class Main {

  public static void main(String[] args) {
    A obj1 = new A();
    B obj2 = new B();

    obj1.start();
    try {
      Thread.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    obj2.start();

    Runnable obj3 = () -> {
      for (int i = 0; i < 100; i++) {
        System.out.println("hello runnable object");
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.getStackTrace();
        }
        ;
      }
      ;
    };

    Runnable obj4 = () -> {
      for (int i = 0; i < 100; i++) {
        System.out.println("hello runnable object 2");
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.getStackTrace();
        }
        ;
      }
      ;
    };

    Thread t1 = new Thread(obj3);
    Thread t2 = new Thread(obj4);

    t1.start();
    t2.start();
  }

}
