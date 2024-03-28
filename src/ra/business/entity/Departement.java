package ra.business.entity;

import ra.business.config.InputMethods;
import ra.run.Menu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Departement
{
    private static int id ;
    private String name;
    private int numberEmployee;
    private  boolean status;

    public Departement()
    {
        this.id ++;
        this.status = true;
        this.numberEmployee = 0;
    }

    public Departement(int id, String name, int numberEmployee, boolean status)
    {
        this.id = id;
        this.name = name;
        this.numberEmployee = numberEmployee;
        this.status = status;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getNumberEmployee()
    {
        return numberEmployee;
    }

    public void setNumberEmployee(int numberEmployee)
    {
        this.numberEmployee = numberEmployee;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }
    public void inputDataDepartment(){
        this.name = getInputName(Menu.departementList);
        this.numberEmployee = 0;
    }
    public void displayData(){
        System.out.printf("| ID : %-5s | Name : %-15s | NumberEmployee : %-3s | Status : %-3s |\n",
                id,name,numberEmployee,status);
        System.out.println("------------------------------------------------------------------------");
    }

    private String getInputName(List<Departement> departementList)
    {
        //name: String – ko để trống , không trùng lặp
        while (true)
        {
            System.out.println("Moi ban nhap ten");
            //Check khong de trong
            String inputName = InputMethods.getString();
            // Check trùng lặp
            if (departementList.stream().noneMatch(t -> t.name.equals(inputName)))
            {
                return inputName;
            } else
            {
                System.out.println("Khong dung dinh dang moi nhap lai");
            }
        }
    }
}
