public class Employee {
    static int count = 1;
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private int department;
    private double salary;

    public Employee(String surname, String name, String patronymic, int department, double salary) {

        this.id = count;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        count++;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "ID:" + this.id + " " + this.surname + " " + this.name + " " + this.patronymic + " " + " Отдел " + this.department + " Зарплата " + this.salary;
    }
}