import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

class Student implements Comparable<Student> {
  int age;
  String name;

  public Student(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public String toString() {
    return "Student [age=]" + age + ", name=" + name + "]";
  }

  public int compareTo(Student that) {
    if (this.age > that.age) {
      return 1;
    } else {
      return -1;
    }
  }
}

class Counter {
  int count;

  public synchronized void increment() {
    count++;
  }
}

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

    Comparator<Student> com = new Comparator<Student>() {

      public int compare(Student i, Student j) {
        if (i.age > j.age)
          return 1;
        else
          return -1;
      }
    };

    List<Student> studs = new ArrayList<>();
    studs.add(new Student(21, "jza"));
    studs.add(new Student(11, "jzb"));
    studs.add(new Student(31, "jzc"));
    studs.add(new Student(28, "jzd"));

    Collections.sort(studs, com);

    for (Student student : studs) {
      System.out.println(student);
    }

    Map<String, Integer> students = new HashMap<>();
    students.put("Jeanine", 100);
    students.put("Jz", 99);
    students.put("lalala", 80);
    students.put("loeloe", 30);
    students.put("oke", 60);

    System.out.println(students);

    for (String key : students.keySet()) {
      System.out.println(key + " : " + students.get(key));
    }

    Collection<Integer> nums = new TreeSet<Integer>();
    nums.add(39);
    nums.add(8);
    nums.add(60);
    nums.add(3);
    nums.add(9);
    System.out.println(nums);

    Iterator<Integer> values = nums.iterator();
    values.next();

    while (values.hasNext()) {
      System.out.println(values.next());
    }

    A obj1 = new A();
    B obj2 = new B();

    // obj1.start();
    // try {
    // Thread.sleep(2);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // obj2.start();

    Counter c = new Counter();

    Runnable obj3 = () -> {
      for (int i = 1; i <= 10000; i++) {
        c.increment();
        // System.out.println("hello runnable object");
        // try {
        // Thread.sleep(10);
        // } catch (InterruptedException e) {
        // e.getStackTrace();
        // }
        // ;
      }
      ;
    };

    Runnable obj4 = () -> {
      for (int i = 1; i <= 10000; i++) {
        c.increment();
        // System.out.println("hello runnable object 2");
        // try {
        // Thread.sleep(10);
        // } catch (InterruptedException e) {
        // e.getStackTrace();
        // }
        // ;
      }
      ;
    };

    Thread t1 = new Thread(obj3);
    Thread t2 = new Thread(obj4);

    t1.start();
    t2.start();

    try {
      t1.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      t2.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println(c.count);
  }

}
