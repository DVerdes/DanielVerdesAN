/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

/**
 *
 * @author DVerd
 */
public class UserUtils {
    /**
     * Calcula la edad de un usuario a partir de su fecha de nacimiento
     * @param birthDate fecha de nacimiento del usuario
     * @return 
     */
    public static int calculateAge(Date birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
        LocalDate birthLocalDate = birthDate.toLocalDate();
        LocalDate currentDate = LocalDate.now(ZoneId.systemDefault());
        if (birthLocalDate.isAfter(currentDate)) {
            throw new IllegalArgumentException("Valor de fecha incorrecto");
        }
        return Period.between(birthLocalDate, currentDate).getYears();
    }
}
