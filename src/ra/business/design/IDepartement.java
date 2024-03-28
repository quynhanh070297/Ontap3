package ra.business.design;

import ra.business.entity.Departement;

import java.util.List;

public interface IDepartement extends ICRUD<Departement>
{
    void printEmployeeByDepartmentName(List<Departement> departementlist);
}
