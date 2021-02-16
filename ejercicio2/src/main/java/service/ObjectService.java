package service;

import model.Dept;
import model.Emp;

public interface ObjectService {

    /**
     * Guarda un departamento en la base de datos orientada a objetos
     * @param dept
     */
    void saveDept(Dept dept);

    /**
     * Guarda un empleado en la base de datos orientada a objetos
     * @param emp
     */
    void saveEmp(Emp emp);
}
