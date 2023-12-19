package com.example.apiPruebas;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpleadoController {

    private List<Empleado> empleados = new ArrayList<Empleado>();

    public EmpleadoController(){
        empleados.add(new Empleado(1L,"Juan","García",34));
        empleados.add(new Empleado(2L,"Pedro","Martínez",45));
        empleados.add(new Empleado(3L,"Alba","Fernández",23));
    }



    @GetMapping("/empleados")
    List lista(){
        return empleados;
    }

    @GetMapping("/empleados/{id}")
    Empleado obtener(@PathVariable Long id){
        for (Empleado empleado:empleados
             ) {
            if(empleado.getId()==id){
                return empleado;
            }
        }

        System.out.println("La id especificada no existe");
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe la id");
    }


    @PostMapping("/empleados")
    Empleado crear(@RequestBody Empleado empeladoEntrada){
        empleados.add(empeladoEntrada);
        return empeladoEntrada;
    }

    @DeleteMapping("/empleados/{id}")
    void eliminar(@PathVariable Long id){
        for (Empleado empleado:empleados
        ) {
            if(empleado.getId()==id){
                empleados.remove(empleado);
            }
        }
    }

    @PutMapping("/empleados/{id}")
    Empleado actualizar(@RequestBody Empleado empleadoEntrada, @PathVariable Long id){
        for (Empleado empleado:empleados
        ) {
            if(empleado.getId()==id){
                empleados.remove(empleado);
                empleados.add(empleadoEntrada);
            }
        }
        return empleadoEntrada;
    }

}
