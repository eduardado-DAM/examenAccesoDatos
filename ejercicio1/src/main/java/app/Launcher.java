package app;

import model.Emp;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import service.HiberService;

import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        HiberService hiberService = new HiberService(); // instanciamos clase de servicios

        //obtenemos todos los empleados de la base de datos de oracle
        System.out.println("oracle");
        List<Emp> empListOracle = hiberService.getAllEmp(HiberService.HIBERNATE_CONFIG_ORACLE);
        empListOracle.forEach(emp -> System.out.println(emp));

        System.out.println("maria");
        List<Emp> empListMaria = hiberService.getAllEmp(HiberService.HIBERNATE_CONFIG_MARIADB);
        empListMaria.forEach(emp -> System.out.println(emp));
    }

}
