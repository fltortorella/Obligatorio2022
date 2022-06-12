package uy.edu.um.prog2;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static boolean numberIsCorrect(String cadena, int numeroChico, int numeroGrande) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        if(resultado){
            if(!(Integer.parseInt(cadena) >= numeroChico && Integer.parseInt(cadena) <= numeroGrande)){
                resultado = false;
            }
        }
        return resultado;
    }
//     REVISAR
//    public static void cargaDeDatos(UpData newUp) throws IOException {
//        long firstTime = System.nanoTime();
//        newUp.upNames();
//        newUp.upMovies();
//        newUp.uPTitle();
//        newUp.upMRatin();
//        long lastTime = System.nanoTime();
//        long dif2 = lastTime - firstTime;
//        double timeTotal = (double) dif2/1000000000;
//        System.out.println("\nCarga de datos exitosa, tiempo de ejecución de la carga:" + timeTotal + "\n");
//    }

    public static void menuInicial() throws IOException {
//        UpData newUp = null;
        Consultas nuevaConsulta = new Consultas();
        while (true) {
            System.out.println("\nSeleccione la opción que desee:\n1.Carga de datos\n2.Ejecutar consultas\n3.Salir");
            Scanner entradaScanMenu = new Scanner(System.in);
            String entradaMenu = entradaScanMenu.nextLine();
            if (!numberIsCorrect(entradaMenu, 1, 3)) {
                System.out.println("\nDato mal ingresado, intente ingresarlo nuevamente");
            }else if (entradaMenu.equals("1")) {
//                if(newUp == null){
//                    newUp = new UpData();
//                    cargaDeDatos(newUp);
//                }else{
                    System.out.println("Los datos ya han sido cargados, presione 2 para realizar las consultas");
//                }
            }else if (entradaMenu.equals("2")) {
//                if(newUp == null){
//                    System.out.println("Debe subirse previamente los datos");
//                }else{
                    consultas(nuevaConsulta);
//                }
            }else { // (NroMenu.equals("3")) Ya habia controlado arriba que el numero este entre 1 y 3 por lo que este es el caso de que digite 3.
                System.out.println("\nSe terminó el programa");
                break;
            }
        }
    }

    public static void consultas (Consultas nuevaConsulta){
        while (true) {
            System.out.println(
                    "\n1.10 casas de cerveza con más reseñas en un año." +
                    "\n2.Top 15 catadores con más reseñas." +
                    "\n3.Cantidad de reviews en un rango dado." +
                    "\n4.Top 7 estilos de cervezas con mejor aroma." +
                    "\n5.Top 5 cervezas con más review." +
                    "\n6.Salir.");
            Scanner entradaScanConsultas = new Scanner(System.in);
            String entradaConsultas = entradaScanConsultas.nextLine();
            if (!numberIsCorrect(entradaConsultas, 1, 6)) {
                System.out.println("Dato mal ingresado, intente ingresarlo nuevamente");
            } else {// En este caso va a ejectuarse la consulta
                if (entradaConsultas.equals("1")) {

                    nuevaConsulta.consulta1();

                } else if (entradaConsultas.equals("2")) {

                    nuevaConsulta.consulta2();

                } else if (entradaConsultas.equals("3")) {

                    nuevaConsulta.consulta3();

                } else if (entradaConsultas.equals("4")) {

                    nuevaConsulta.consulta4();

                } else if (entradaConsultas.equals("5")) {

                    nuevaConsulta.consulta5();

                } else { // Ya habia controlado arriba que el numero este entre 1 y 6 por lo que este es el caso de que digite 6.
                    // Vuelve al menu principal
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        menuInicial();
    }
}
