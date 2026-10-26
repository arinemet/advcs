/*
Student Class This class will have instance variables for the name (String), and
age(int).  The constructor is used to set up a student.  The student class will
be compatible with a HashSet in terms of checking for duplicates.  The hashCode
will return first letter of the name as number (hint: convert char to a number)
* prime number + age, and the equals method will return true if the first letter
and age are the same.  Have a toString that will return the student's name and
age.  
*This hashCode is not perfect since two students with different names having the
same first letter and age will produce the same result.

Required Method(s)
+ hashCode() : int - Return the first letter of the name as number (hint:
  convert char to a number) * prime number + age.
+ equals(Object) : boolean - Return true if the first letter of the name and age
  are the same
*/

public class Student {
  private String name;
  private int age;

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Student(String name, int age) {
    this.age = age;
    this.name = name;
  }

  @Override
  public int hashCode() {
    return (int) name.charAt(0) * 31 + age;
  }

  @Override
  public boolean equals(Object obj) {
    Student other = (Student) obj;
    if (name.charAt(0) == other.getName().charAt(0) && age == other.getAge()) {
      return true;
    }

    return false;
  }

  @Override
  public String toString() {
    return "Name: " + name + " Age: " + age;
  }
}