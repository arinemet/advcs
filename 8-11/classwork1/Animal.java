public class Animal {
  private String type; // instance variables
  private String name;
  private int age;

  public Animal(String type, String name, int age) { // constructor
    this.type = type;
    this.name = name;
    this.age = age;

  }

  public String toString() {
    return name + ", " + type + ", " + age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }
}