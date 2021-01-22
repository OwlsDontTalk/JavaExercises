package unit4;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String telephone;
    private String salary;
    private int age;

    public Employee(String _name, String _position, String _email, String _telephone, String _salary, int _age){
        name = _name;
        position = _position;
        email = _email;
        telephone = _telephone;
        salary = _salary;
        age = _age;
    }

    public void getInfo() {
        System.out.println("Employee " + name + ": age " + age + ", position: " + position + ", salary: " + salary + ", email: " + email + ", telephone: " + telephone);
    }

    public int getAge(){
        return this.age;
    }
}
