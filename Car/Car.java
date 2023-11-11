package Car;

public abstract class Car {

  public abstract void drive();

  public void playMusic() {
    System.out.println("playing music");
  }
}

class WagonR extends Car {

  public void drive() {

    System.out.println("Driving..");

  }
}