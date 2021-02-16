package app;

import model.Dept;
import model.Emp;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import service.HiberService;

import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        HiberService hiberService = new HiberService(); // instanciamos clase de servicios


        System.out.println("--COPIANDO DEPARTAMENTOS DESDE ORACLEXE A MARIADB--");
        List<Dept> deptListOracle = hiberService.getAllDept(HiberService.HIBERNATE_CONFIG_ORACLE);
        deptListOracle.forEach(dept -> {
            System.out.println("Procesando el departamento: " + dept.getDname());
            hiberService.saveDept(HiberService.HIBERNATE_CONFIG_MARIADB, dept);
        });






    }

    /**
     * Pruebas
     * @param hiberService
     */
    private static void pruebas(HiberService hiberService) {
        //obtenemos todos los empleados de la base de datos de oracle
        System.out.println("oracle");
        List<Emp> empListOracle = hiberService.getAllEmp(HiberService.HIBERNATE_CONFIG_ORACLE);
        empListOracle.forEach(emp -> System.out.println(emp));

        System.out.println("maria");
        List<Emp> empListMaria = hiberService.getAllEmp(HiberService.HIBERNATE_CONFIG_MARIADB);
        empListMaria.forEach(emp -> System.out.println(emp));

        System.out.println("oracle");
        List<Dept> deptListOracle = hiberService.getAllDept(HiberService.HIBERNATE_CONFIG_ORACLE);
        deptListOracle.forEach(dept -> System.out.println(dept));

        System.out.println("maria");
        List<Dept> deptListMaria = hiberService.getAllDept(HiberService.HIBERNATE_CONFIG_MARIADB);
        deptListMaria.forEach(dept -> System.out.println(dept));

    }

}
