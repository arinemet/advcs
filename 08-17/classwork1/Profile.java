public class Profile {
  private String name;
  private int age;

  public Profile(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "Name: " + name + " Age: " + age;
  }
}
