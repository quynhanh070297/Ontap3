package ra.business.implement;

import ra.business.config.InputMethods;
import ra.business.design.IEmployee;
import ra.business.entity.Departement;
import ra.business.entity.Employee;
import ra.run.Menu;

import java.util.Comparator;
import java.util.List;

public class EmployeeImplement implements IEmployee
{


    @Override
    public void displayData(List<Employee> employeeList)
    {
        if (employeeList.isEmpty()) {
            System.err.println("Danh sach trống");
        } else {
            employeeList.forEach(Employee::displayData);
        }
    }

    @Override
    public void createData(List<Employee> employeeList)
    {

        System.out.println("Nhap so nhan vien ban muon them");
        byte count  = InputMethods.getByte();
        for (int i = 1; i <=count ; i++) {
            System.out.println("Nhap thong tin cho nhan vien thư "+i +1);
            Employee employee = new Employee();
            employee.inputEmployee();
            employeeList.add(employee);
        }
        System.out.println("Đã them moi thanh cong ");
    }

    @Override
    public void updateData(List<Employee> employeeList)
    {
        System.out.println("Hãy chọn nhan vien muốn update");
        int id = InputMethods.getInteger();
        displayData( employeeList);
        for (Employee employee : employeeList)
        {
            if (employee.getId()==id){
                employee.inputEmployee();
            }
        }

    }

    @Override
    public void changeStatus(List<Employee> employeeList)
    {
        System.out.println("Moi ban nhap vao trang thai moi");
        int id = InputMethods.getInteger();
        displayData( employeeList);
        for (Employee employee : employeeList)
        {
            if (employee.getId()==id){
                employee.setStatus(InputMethods.getBoolean());
            }
        }
    }


    @Override
    public void findByEmployeeName(List<Employee> employeeList)
    {
        System.out.println("Nhap ten nhan vien muốn Tim");
        String name = InputMethods.getString();
        displayData(employeeList);
        for (Employee employee : employeeList)
        {
            if (employee.getFullName().equals(name)){
                System.out.println(employee);
            }
        }
    }

    @Override
    public void findEmployeeByDepartmentName(List<Employee> employeeList, List<Departement> departementList)
    {
        for (Departement departement : departementList)
        {
            employeeList.stream().filter(employee -> employee.getDepartment().getId()==departement.getId()).forEach(Employee::displayData);
        }
    }


    @Override
    public void sortByName(List<Employee> employeeList)
    {
        employeeList.stream().sorted(Comparator.comparing(Employee::getFullName));

    }

    //Logic phan trang
    //B1: Tạo ra Limit = 5 Tức là mỗi trang có 5 phần tử

    //Trang 1: (0 - 4) Nhân viên
    //Trang 2: (5 - 9) Nhân viên
    //Trang 3: (10 - 14) Nhân viên

    //Vị trí bắt đầu = (trang hiện tại - 1) * limit
    // Trang 1 = (1 -1)*0 = 0 vị trí bắt đầu = 0
    // Trang 2 = (2 -1)*5 = 5 Vi trí bắt đầu = 5
    // Trang 3 = (3 - 1) *5 =  10 Vi trí bắt đầu = 10

    //Vị tri kết thúc = limit*page -1;
    int limit = 5;
    int thisPage = 1;
    int lenght = Menu.employeeList.size();
    public void loadEmployee(){
       do {
        int startNum = limit*(thisPage-1);
        int endNum = limit*thisPage-1;
        for (int i = 0; i < Menu.employeeList.size(); i++)
        { if (i>=startNum&&i<=endNum)
           {
            Menu.employeeList.get(i).displayData();
               thisPage++;
            }
        }
        listPage();
        }while (true);
    }

    private void listPage()
    { int count =  (int) Math.ceil((float)lenght/limit);
        if (thisPage!=1){
            System.out.print("<Trang trước: ");
            for (int i = 0; i < thisPage; i++)
            {
                System.out.print(i +
                        "|");
            }
            System.out.print("Trang sau>");

            System.out.println("Lua chon");
            System.out.println("Nhập số trang bạn muốn");
            int num = InputMethods.getInteger();
        }
    }


    int quantity = (int) Math.ceil((float)lenght/limit);

    @Override
    public void printPagination(int currentPage,List<Employee> employeeList)
    {
        for (int i = currentPage*limit; i < currentPage*limit+limit; i++)
        {
            if (i==lenght){
                break;
            }employeeList.get(i).displayData();
        }
        System.out.println("ban dang o trang " + (currentPage+1) +"/"+quantity);
    }
    @Override
    public void paginationMath(List<Employee> employeeList)
    {
        printPagination( 0, employeeList);
        while (true){
            System.out.println("Chon trang ban muon xem");
            System.out.println("chon 0 de dung ");
            byte choice = InputMethods.getByte();
            if (choice-1<=0){
                return;
            }
            if (choice-1<quantity){
                printPagination( choice, employeeList);
            }
            else {
                System.out.println("Moi ban chon lai");
            }
        }
    }
}
