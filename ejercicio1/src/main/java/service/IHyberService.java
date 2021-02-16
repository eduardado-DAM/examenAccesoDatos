package service;

import model.Dept;
import model.Emp;

import java.util.List;

/**
 * Capa lógica o Interfaz
 */
public interface IHyberService {


    /**
     * Obtiene todos los empleados de la base de datos de oracle
     * @return
     */
    List<Emp> getAllEmp(String hibernateConfigResource);

    /**
     * Guarda un empleado en una base de datos
     */
    void saveEmp(String hibernateConfigResource, Emp emp);

    /**
     * Guarda un departamento en una base de datos
     * @param hibernateConfigResource
     */
    void saveDept(String hibernateConfigResource, Dept dept);

    /**
     * Obtiene todos los departamentos de la base de datos
     * @return
     */
    List<Dept> getAllDept(String hibernateConfigResource);



}
