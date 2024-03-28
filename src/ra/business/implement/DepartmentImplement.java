package ra.business.implement;

import ra.business.config.InputMethods;
import ra.business.design.IDepartement;
import ra.business.entity.Departement;

import java.util.List;

public class DepartmentImplement implements IDepartement
{
    @Override
    public void displayData(List<Departement> departementList)
    {
            if (departementList.isEmpty()) {
                System.err.println("Danh sach trống");
            } else {
                departementList.forEach(Departement::displayData);
            }
    }

    @Override
    public void createData(List<Departement> departmentList)
    {

        System.out.println("Nhap so luong phong ban muon them");
        byte count  = InputMethods.getByte();
        for (int i = 1; i <=count ; i++) {
            System.out.println("Nhap thong tin cho phong ban thư "+i);
            Departement department = new Departement();
            department.inputDataDepartment();
            departmentList.add(department);
        }
        System.out.println("Đã them moi thanh cong ");
    }


    @Override
    public void updateData(List<Departement> departmentList)
    {
        System.out.println("Hãy chọn department muốn update");
        int id = InputMethods.getInteger();
        displayData( departmentList);
        for (Departement departement : departmentList)
        {
            if (departement.getId()==id){
                departement.inputDataDepartment();
            }
        }
    }

    @Override
    public void changeStatus(List<Departement> departmentList)
    {
        System.out.println("Moi ban nhap vao trang thai moi");
        int id = InputMethods.getInteger();
        displayData( departmentList);
        for (Departement departement : departmentList)
        {
            if (departement.getId()==id){
                departement.setStatus(InputMethods.getBoolean());
            }
        }
    }


    @Override
    public void printEmployeeByDepartmentName(List<Departement> departementlist)
    {
        System.out.println("Nhap ten department muốn Tim");
        String name = InputMethods.getString();
        displayData(departementlist);
        for (Departement departement : departementlist)
        {
            if (departement.getName().equals(name)){
                System.out.println(departement);
            }
        }
    }
}
