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
     * Guarda un empleado
     */
    void saveEmpInMariaDB();

    /**
     * Obtiene todos los departamentos de la base de datos
     * @return
     */
    List<Dept> getAllDept();



}
