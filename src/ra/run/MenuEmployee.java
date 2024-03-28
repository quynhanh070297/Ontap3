package ra.run;

import ra.business.config.InputMethods;
import ra.business.implement.EmployeeImplement;

import java.util.Scanner;

public class MenuEmployee
{
    public static void employeeMenu()
    {
        EmployeeImplement employeeImplement = new EmployeeImplement();
        while (true) {
            System.out.println("================Employee Menu===================");
            System.out.println(
                    "1.Hiển thị tất cả nhân viên (phân trang)\n" +
                            "2.Thêm mới nhân viên\n" +
                            "3.Sửa thông tin nhân viên\n" +
                            "4.Thay đổi trạng thái nhân viên\n" +
                            "5.Danh sách nhân viên theo phòng ban\n" +
                            "6.Sắp xếp nhân viên theo tên tăng dần\n" +
                            "7.Thoat");
            System.out.println("Nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    employeeImplement.paginationMath(Menu.employeeList);
                    break;
                case 2:
                    employeeImplement.createData(Menu.employeeList);
                    break;
                case 3:
                    employeeImplement.updateData(Menu.employeeList);
                    break;
                case 4:
                    employeeImplement.changeStatus(Menu.employeeList);
                    break;
                case 5:
                    employeeImplement.findEmployeeByDepartmentName(Menu.employeeList,Menu.departementList);
                    break;
                case 6:
                    employeeImplement.sortByName(Menu.employeeList);

                    break;
                case 7:
                    return;
                default:
                    System.err.println("Nhap sai moi nhap lai");
            }
        }
    }
}
