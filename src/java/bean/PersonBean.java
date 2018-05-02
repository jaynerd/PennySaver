package bean;

import javax.ejb.Stateful;

/**
 * @author Namyoon j4yn3rd@gmail.com
 */
@Stateful
public class PersonBean {

    private String name;
    private String age;
    private String salary;
    private String hours;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
