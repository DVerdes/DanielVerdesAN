package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {



        MongoClient cliente = MongoClients.create("mongodb://localhost:27017/pruebas");

        try{
            MongoDatabase conexion = cliente.getDatabase("Prueba");
            MongoCollection<Document> colMongo = conexion.getCollection("Empleados");

            Empleado emp1 = new Empleado ("Pedro García",35,true,2000, new Telefono[]{new Telefono(678123124), new Telefono(123456789)}  );
            EmpleadoCRUD.insertarEmpleado(colMongo,emp1);

            Empleado emp2 = new Empleado ("María López",32,false,1400, new Telefono[]{new Telefono(4567543), new Telefono(678456456)} );
            EmpleadoCRUD.insertarEmpleado(colMongo,emp1);

            List<Empleado> empleados = EmpleadoCRUD.listarEmpleados(colMongo);
            System.out.println("\nLista de empleados\n------------");
            for (Empleado emp: empleados){
                System.out.println(emp.toString());
            }

            emp2.setSueldo(1605);
            EmpleadoCRUD.actualizarEmpleado(colMongo, emp2);

            Empleado empConsultado = EmpleadoCRUD.consultarEmpleado(colMongo,"Pedro García");
            System.out.println("\nEmpleado consultado -> "+empConsultado.toString());


            EmpleadoCRUD.eliminarEmpleado(colMongo, "María López");

            empleados = EmpleadoCRUD.listarEmpleados(colMongo);
            System.out.println("\nLista de empleados\n--------");
            for(Empleado emp:empleados){
                System.out.println(emp.toString());
            }

        }finally {

            if(cliente!=null){
                cliente.close();
            }
        }




    }
}
