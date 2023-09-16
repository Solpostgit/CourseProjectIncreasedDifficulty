import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee[] storage = new Employee[10]; //поле типа Employee[10]

        storage[0] = new Employee("Ivanov", "Ivan", "Ivanovich", 3, 91000);
        storage[1] = new Employee("Petrov", "Petr", "Petrovich", 2, 100000);
        storage[2] = new Employee("Sidorov", "Denis", "Sergeevich", 4, 95000);
        storage[3] = new Employee("Ivanova", "Anna", "Borisovna", 1, 93000);
        storage[4] = new Employee("Svetlaya", "Irina", "Pavlovna", 5, 90000);
        storage[5] = new Employee("Borisov", "Maksim", "Alekseevich", 3, 97000);
        storage[6] = new Employee("Alekseev", "Sergey", "Nikolaevich", 1, 92000);
        storage[7] = new Employee("Maksimova", "Alla", "Nikolaevna", 2, 94000);
        storage[8] = new Employee("Nikolaeva", "Olga", "Anatolyevna", 4, 91000);
        storage[9] = new Employee("Denisov", "Pavel", "Ivanovich", 3, 98000);

        System.out.println();
        System.out.println(Arrays.toString(storage)); //список сотрудников со всеми имеющимися данными
        System.out.println();
        System.out.println("*** Повышенная сложность ***");
        System.out.println();
        indexSalary(storage, 1.1); //индексация зарплаты на 10%
        System.out.println();
        changeDepartment(storage, 3, 1.05); //выбираем отдел (3), индексируем зарплату на 5% (1,05)
        System.out.println();
        choiceNumber(storage, 104000); //повышенная сложность 3. зарплата меньше/больше indexSalary
        System.out.println();
    }

    //***** Повышенная сложность *****

    public static void indexSalary(Employee[] arr, double index) { //индексация зарплат
        double indexSal = 0;
        for (int i = 0; i < arr.length; i++) {
            indexSal = arr[i].getSalary() * index;
            arr[i].setSalary(indexSal);
            System.out.println(arr[i]);
        }
    }

    public static void changeDepartment(Employee[] arr, int department, double indexSal) {
        int indexEmployeeDep = 0; //количество сотрудников в отделе
        int minIndex = 0;
        int maxIndex = 0;
        double minSal = 150000;
        double maxSal = 90000;
        double sumSalaryDep = 0; //сумма зарплат в отделе
        double midleSalaryDep = 0; //средняя зарплата в отделе
        double indexSalDep = 0; //индексированная зарплата
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDepartment() == department) {
                indexEmployeeDep++;
                if (arr[i].getSalary() <= minSal) { //сотрудник с мин зарплатой
                    minSal = arr[i].getSalary();
                    minIndex = i;
                }
                if (arr[i].getSalary() >= maxSal) { //сотрудник с макс зарплатой
                    maxSal = arr[i].getSalary();
                    maxIndex = i;
                }
                sumSalaryDep = sumSalaryDep + arr[i].getSalary(); //сумма зарплат на отдел
                midleSalaryDep = sumSalaryDep / indexEmployeeDep; //средняя зарплата по отделу
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой в " + department + " отделе " + arr[minIndex]);
        System.out.println("Сотрудник с максимальной зарплатой в " + department + " отделе " + arr[maxIndex]);
        System.out.println("Сумма затрат на зарплату по " + department + " отделу " + sumSalaryDep);
        System.out.println("Средняя зарплата по отделу " + midleSalaryDep);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDepartment() == department) {
                indexSalDep = arr[i].getSalary() * indexSal; //индексация зарплаты в отделе
                arr[i].setSalary(indexSalDep);
                System.out.println("Индексация зарплаты в отделе " + arr[i]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDepartment() == department) {
                System.out.println("ID:" + arr[i].getId() + " " + arr[i].getSurname() + " " + arr[i].getName() + " " + arr[i].getPatronymic() + " " + arr[i].getSalary());
                //все сотрудники отдела
            }
        }
    }

    public static void choiceNumber(Employee[] arr, double indexSalary) {
        System.out.println("Зарплата меньше " + indexSalary);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getSalary() < indexSalary) { //зарплата меньше indexSalary
                System.out.println("ID:" + arr[i].getId() + " " + arr[i].getSurname() + " " + arr[i].getName() + " " + arr[i].getPatronymic() + " " + arr[i].getSalary());
            }
        }
        System.out.println("Зарплата больше " + indexSalary);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getSalary() >= indexSalary) { //зарплата больше indexSalary
                System.out.println("ID:" + arr[i].getId() + " " + arr[i].getSurname() + " " + arr[i].getName() + " " + arr[i].getPatronymic() + " " + arr[i].getSalary());
            }
        }
    }
}