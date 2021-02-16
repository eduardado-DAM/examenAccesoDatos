package launcher;

import model.Dept;
import model.Emp;
import service.HiberService;
import service.ObjectDBService;
import service.ObjectService;

import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        HiberService hiberService = new HiberService();
        ObjectService objectService = new ObjectDBService();

        List<Emp> empListOracle = hiberService.getAllEmp(HiberService.HIBERNATE_CONFIG_ORACLE);
        empListOracle.forEach(emp -> {
            System.out.println("Procesando el empleado llamado: " + emp.getEname());
            objectService.saveEmp(emp);
        });

        List<Dept> deptListOracle = hiberService.getAllDept(HiberService.HIBERNATE_CONFIG_ORACLE);
        deptListOracle.forEach(dept -> {
            System.out.println("Procesando departamento: " + dept.getDname());
            objectService.saveDept(dept);
        });



    }

    private static void pruebas(){
        HiberService hiberService = new HiberService();

        System.out.println("oracle");
        List<Emp> empListOracle = hiberService.getAllEmp(HiberService.HIBERNATE_CONFIG_ORACLE);
        empListOracle.forEach(emp -> System.out.println(emp));

        System.out.println("oracle");
        List<Dept> deptListOracle = hiberService.getAllDept(HiberService.HIBERNATE_CONFIG_ORACLE);
        deptListOracle.forEach(dept -> System.out.println(dept));

    }
}
