package org.example;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        // 1er parte (desencriptar)
        File file = new File("C://Pruebas//encriptado.txt");
        FileInputStream fis = new FileInputStream(file);
        int num = 0;
        String linea = "";


        while (num!=-1){
            num = fis.read();
            if(num!=-1){
                linea += descifrarMensaje(num);

            }
        }

        System.out.println(linea);

        //2nda parte (encriptar)

        File f = new File("C://Pruebas//mensaje.txt");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(206);
        fos.write(217);
        fos.write(200);
        fos.write(202);
        fos.write(208);
        fos.write(200);
        fos.write(218);
        f.createNewFile();



    }

    public static String descifrarMensaje(int numero){
        switch (numero){
            case 200:
                return "A";
            case 201:
                return "B";
            case 202:
                return "C";
            case 203:
                return "D";
            case 204:
                return "E";
            case 205:
                return "F";
            case 206:
                return "G";
            case 207:
                return "H";
            case 208:
                return "I";
            case 209:
                return "J";
            case 210:
                return "K";
            case 211:
                return "L";
            case 212:
                return "M";
            case 213:
                return "N";
            case 214:
                return "O";
            case 215:
                return "P";
            case 216:
                return "Q";
            case 217:
                return "R";
            case 218:
                return "S";
            case 219:
                return "T";
            case 220:
                return "U";
            case 221:
                return "V";
            case 222:
                return "W";
            case 223:
                return "X";
            case 224:
                return "Y";
            case 225:
                return "Z";
            default:
                return "NOSE";
        }

    }

}
