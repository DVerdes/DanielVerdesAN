package org.example;

/**
 * EJERCICIO 1
 */
public class Ejercicio1
{
    public static void main( String[] args )
    {
        // Introducir datos ejercicio
        String matricula = "23Y517-65";

        if (esMatriculaValida(matricula)) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }

    public static boolean esMatriculaValida(String matricula) {

        if (matricula.matches("[0-9]+[0-9]+[BCDFGHJKLMNÑPQRSTVWXZ]+[0-9]+[0-9]+[0-9]+[-]+[0-9]+[0-9]")) {
            boolean numpar = false;

            int num1 = Integer.parseInt(String.valueOf(matricula.charAt(0)));
            int num2 = Integer.parseInt(String.valueOf(matricula.charAt(1)));
            int num3 = Integer.parseInt(String.valueOf(matricula.charAt(3)));
            int num4 = Integer.parseInt(String.valueOf(matricula.charAt(4)));
            int num5 = Integer.parseInt(String.valueOf(matricula.charAt(5)));
            int num6 = Integer.parseInt(String.valueOf(matricula.charAt(7)));
            int num7 = Integer.parseInt(String.valueOf(matricula.charAt(8)));


            if ((num1 + num2) % 2 == 0 && (num3 + num4) % 2 == 0 && (num4 + num5) % 2 == 0 && (num6 + num7) % 2 == 0) {
                return true;
            }


            return false;
        }


        return false;
    }

}
