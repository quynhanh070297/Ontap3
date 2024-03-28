package ra.run;

import ra.business.config.InputMethods;
import ra.business.entity.Departement;
import ra.business.implement.DepartmentImplement;

import java.util.Scanner;

public class MenuDepartement
{
    public static void departmentMenu()
    {
        DepartmentImplement departmentImplement = new DepartmentImplement();
        while (true) {
            System.out.println("================Department Menu===================");
            System.out.println(
                            "1.Hiển thị tất cả phòng ban\n" +
                            "2.Thêm mới phòng ban\n" +
                            "3.Sửa thông tin phòng ban\n" +
                            "4.Tìm kiếm phòng ban theo tên\n" +
                            "5.Thay đổi trạng thái phòng ban\n"+
                            "6.Thoát\n"
            );
            System.out.println("Nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    departmentImplement.displayData(Menu.departementList);
                    break;
                case 2:
                    departmentImplement.createData(Menu.departementList);
                    break;
                case 3:
                    departmentImplement.updateData(Menu.departementList);
                    break;
                case 4:
                    departmentImplement.printEmployeeByDepartmentName(Menu.departementList);
                    break;
                case 5:
                    departmentImplement.changeStatus(Menu.departementList);
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Nhap sai moi nhap lai");
            }
        }
    }
}
