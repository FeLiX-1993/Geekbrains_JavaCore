public class Main {

    public static void main(String[] args) {

        Employee[] employees = createEmployees();
        printEmployeesOver40YearsOld(employees);

    }

    public static Employee[] createEmployees(){

        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Michael Jeffrey Jordan", "Accountant",
                "Jordan@gmail.com", "89117509866", 150000, 35);
        employees[1] = new Employee("Scottie Pippen", "Economist",
                "Pippen@gmail.com", "89216664099", 100000, 55);
        employees[2] = new Employee("Dennis Keith Rodman", "Programmer",
                "Rodman@gmail.com", "89005349867", 800000, 59);
        employees[3] = new Employee("Gerald Eugene Sloan", "Analyst",
                "Sloan@gmail.com", "89234118990", 400000, 29);
        employees[4] = new Employee("Horace Grant", "Analyst",
                "Grant@gmail.com", "89117509866", 400000, 64);

        return employees;
    }

    public static void printEmployeesOver40YearsOld(Employee[] employees){

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40)
                System.out.println(employees[i]);
        }

    }
}
