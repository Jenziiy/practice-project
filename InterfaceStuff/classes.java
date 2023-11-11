package InterfaceStuff;

interface A {
  void show();

  void config();
}

class B implements A {

  @Override
  public void config() {
    System.out.println("in config");
  }

  @Override
  public void show() {
    System.out.println("in show");
  }

}
