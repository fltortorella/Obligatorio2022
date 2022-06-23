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
}
