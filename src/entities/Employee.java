package entities;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String gender;
    private int departmentId;

    public Employee() {}

    public Employee(int id, String name, String email, String gender, int departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getGenre() {
        return gender;
    }

    public void setGenre(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
