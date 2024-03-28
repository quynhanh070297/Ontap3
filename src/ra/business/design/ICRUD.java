package ra.business.design;

import java.util.List;

public interface ICRUD <E>

{
    void displayData(List<E> listName);
    void createData(List<E> listName);
    void updateData(List<E> listName);
    void changeStatus(List<E> listName);



}
