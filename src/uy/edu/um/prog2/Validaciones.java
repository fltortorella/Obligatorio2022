package uy.edu.um.prog2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validaciones {

    public static boolean numberIsCorrect (String numeroString, int numeroinferior, int numerosuperior) {
        boolean resultado;

        try {
            Integer.parseInt(numeroString);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        if(resultado){
            if(!(Integer.parseInt(numeroString) >= numeroinferior && Integer.parseInt(numeroString) <= numerosuperior)){
                resultado = false;
            }
        }
        return resultado;
    }

    public static Date pruebaFecha() {
        Scanner sc = new Scanner(System.in);
        String fecha = sc.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = null;
        String date = fecha;
        try{
            testDate = df.parse(date);
            if (!df.format(testDate).equals(date)){
                System.out.println("Fecha invalida");
            } else {
                return testDate;
            }
        } catch (Exception e){ System.out.println("Formato invalido");}
        return null;
    }
}
