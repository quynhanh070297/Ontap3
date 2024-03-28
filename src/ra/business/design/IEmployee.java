package ra.business.design;

import ra.business.entity.Departement;
import ra.business.entity.Employee;

import java.util.List;

public interface IEmployee extends ICRUD <Employee>
{
    void findByEmployeeName(List<Employee> employeeList);
    void findEmployeeByDepartmentName(List<Employee> employeeList ,List<Departement> departementList);
    void sortByName(List<Employee> employeeList);
    void printPagination(int currentPage,List<Employee> employeeList);
    void paginationMath(List<Employee> employeeList);
}
