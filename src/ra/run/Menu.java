package ra.run;

import ra.business.config.InputMethods;
import ra.business.entity.Departement;
import ra.business.entity.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu
{
    public static List<Departement> departementList = new ArrayList<>();
    public static List<Employee> employeeList = new ArrayList<>();
    static {

        employeeList.add(new Employee(0, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(1, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(2, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(3, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(4, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(5, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(6, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(7, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(8, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(9, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(10, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(11, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(12, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(13, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(14, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(15, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        employeeList.add(new Employee(16, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
    }

    public static void main(String[] args)
    {
        while (true)
        {
            System.out.println("================MENU===================");
            System.out.println("1.Quản trị Department \n" +
                               "2.Quản lý Employee\n" +
                               "3.Thoát ");
            System.out.println("Vui long lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice)
            {
                case 1:
                    MenuDepartement.departmentMenu();
                    break;
                case 2:
                    MenuEmployee.employeeMenu();
                    break;
                case 4:
                    System.out.println("Thoát");
                    return;
                default:
                    System.err.println("Moi nhap lai");
            }
        }
    }
}