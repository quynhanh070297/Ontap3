package ra.business.entity;

import ra.business.config.InputMethods;
import ra.run.Menu;

import javax.xml.namespace.QName;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Employee
{
    private int id ;
    private String fullName;
    private String address;
    private String phone;
    private LocalDate dateOfBirth;
    private Departement department;
    private boolean status;


    public Employee()
    {
        this.status = true;
    }

    public Employee(int id, String fullName, String address, String phone, LocalDate dateOfBirth, Departement department, boolean status)
    {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.status = status;
    }

    public int getId()
    {
        return id;
    }

    public void setId(List<Employee> employeeList)
        {
            //Nếu list chưa có phần tử nào thì đây chính là phần tử đầu tiên
            if (employeeList.isEmpty())
            {
                this.id = 1;
            } else
            {
                int maxId = employeeList.get(0).getId();
                for (Employee employee : employeeList)
                {
                    //Tìm ra id lớn nhất hiện có trong list employee
                    if (employee.getId() > maxId)
                        maxId = employee.getId();
                }
                this.id = ++maxId;
            }
        }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public Departement getDepartment()
    {
        return department;
    }

    public void setDepartment(Departement department)
    {
        this.department = department;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public void inputEmployee()
    {

        System.out.println("Moi ban nhap Ten");
        this.fullName = InputMethods.getString();
        System.out.println("Moi ban nhap dia chi");
        this.address = InputMethods.getString();
        System.out.println("Moi ban nhap so dien thoai");
        this.phone = getPhoneEmployee();
        System.out.println("Moi ban nhap Ngay sinh");
        this.dateOfBirth = InputMethods.getLocalDate();
        System.out.println("Moi ban nhap phong ban");
        this.department = getInputDepartment(Menu.departementList);
    }
    public void displayData(){
        System.out.printf("| ID : %-5s | Name : %-15s | Address : %-10s |Phone Number : %-10s | Date of Birth: %-15s | Department : %-15s | Status : -3s\n",
                id,fullName,address,phone,dateOfBirth,department==null?"khong co phong ban":department.getName(),status?"Dang Hoat Dong":"Ngung Hoat dong");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
    }

    private Departement getInputDepartment(List<Departement> departementList)
    {
        while (true)
        {
            System.out.println("Nhập vào tên phòng ban");
            departementList.forEach(Departement::displayData);
            System.out.println("Chon Phong ban theo ID");
            int departmentNameInputID = InputMethods.getInteger();
            for (int i = 0; i < departementList.size(); i++)
            {
                if (departementList.get(i).getId() == departmentNameInputID)
                {
                    departementList.get(i).setNumberEmployee(departementList.get(i).getNumberEmployee()+1);
                    return departementList.get(i);
                } else
                {
                    System.out.println("Nhap sai ID moi nhap lai");
                }
            }

        }

    }
        private String getPhoneEmployee ()
        {
            final String regex = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
            do
            {
                System.out.println("Nhập vào So Dien thoai");
                String phoneInput = InputMethods.getString();
                // đúng định dạng
                if (phoneInput.matches(regex))
                {
                    return phoneInput;
                } else
                {
                    System.err.println("Không đúng định dạng");
                }
            } while (true);
        }
    }

