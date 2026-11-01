
abstract class Employee {

    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double monthlySalary();
}


class FTime extends Employee {

    double salary = 100000;

    FTime(String name, int id) {
        super(name, id);
    }

    @Override
    double monthlySalary() {
        return salary;
    }
}


class PTime extends Employee {

    double rate;
    int hours;

    PTime(String name, int id, double rate, int hours) {
        super(name, id);
        this.rate = rate;
        this.hours = hours;
    }

    @Override
    double monthlySalary() {
        return hours * rate;
    }
}


class Intern extends Employee {

    double stipend;

    Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    @Override
    double monthlySalary() {
        return stipend;
    }
}


public class Salary {

    public static void main(String[] args) {

        Employee[] employees = {
            new FTime("Krisha", 1),
            new PTime("Jatin", 2, 500, 40),
            new Intern("Ritu", 3, 20000)
        };

        double total = 0;

        for (Employee e : employees) {

            double salary = e.monthlySalary();

            System.out.println(
                e.name + " (" + e.id + ") = " + salary
            );

            total += salary;

            if (e instanceof Intern) {
                System.out.println("Note: This employee is an Intern.");
            }
        }

        System.out.println("Total Salary = " + total);
    }
}
