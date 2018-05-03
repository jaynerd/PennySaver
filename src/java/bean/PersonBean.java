package bean;

import javax.ejb.Stateful;

/**
 * @author Namyoon j4yn3rd@gmail.com
 */
@Stateful
public class PersonBean {

    private String name;
    private int age;
    private int salary;
    private int workHours;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }
}
