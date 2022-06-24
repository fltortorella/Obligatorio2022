package uy.edu.um.prog2;

import uy.edu.um.prog2.Entidades.Brewery;
import uy.edu.um.prog2.Entidades.Review;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

import java.io.IOException;
import java.util.Scanner;

public class Main {
//*
    public static void cargaDeDatos() throws IOException {
        System.out.println("Comienza la carga de datos.");
        long startLoadData = System.currentTimeMillis(); // Comienza la medición del tiempo que tarda en cargar los datos.

        LoadData.LoadData(); // Llamo al método estático LoadData() de la clase LoadData.

        System.out.println("Finaliza la carga de datos.");
        long endLoadData = System.currentTimeMillis(); // Finaliza la medición del tiempo que tarda en cargar los datos.

        System.out.println("Tiempo necesario para la carga de los datos: " + (endLoadData - startLoadData) + " milisegundos."); // Imprimo el tiempo que tarda la carga de los datos.
    }

    public static void consultas () throws IOException {
        while (true) {
            System.out.println(
                    "\n1. 10 casas de cerveza con más reseñas en un año." +
                    "\n2. Top 15 catadores con más reseñas." +
                    "\n3. Cantidad de reviews en un rango dado." +
                    "\n4. Top 7 estilos de cervezas con mejor aroma." +
                    "\n5. Top 5 cervezas con más review." +
                    "\n6. Salir al menú principal.");

            // Leo lo que introduce el usuario.
            Scanner entradaScanConsultas = new Scanner(System.in);
            String entradaConsultas = entradaScanConsultas.nextLine();

            if (!Validaciones.numberIsCorrect(entradaConsultas, 1, 6)) {
                System.out.println("Dato mal ingresado, intente ingresarlo nuevamente");
            } else { // En este caso va a ejectuarse la consulta
                if (entradaConsultas.equals("1")) {
                    System.out.println("\nIngrese un año entre 1996 y 2012: ");
                    // Leo lo que introduce el usuario.
                    Scanner entradaAñoConsultaUno = new Scanner(System.in);
                    String añoConsulta1String = entradaAñoConsultaUno.nextLine();
                    int añoConsulta1Int = 0;
                    boolean datoAñoCorrecto = false;

                    try {
                        añoConsulta1Int = Integer.parseInt(añoConsulta1String);
                        if (!Validaciones.numberIsCorrect(añoConsulta1String, 1996, 2012)) {
                            System.out.println("No hay datos para el año ingresado, pruebe con un año entre 1996 y 2012.");
                        } else {
                            // Se corre la consulta 1.
                            Consultas.consulta1(añoConsulta1Int);
                        }

                    } catch (NumberFormatException excepcion) {
                        System.out.println("\nDato mal ingresado, intente ingresarlo nuevamente");
                    }

                } else if (entradaConsultas.equals("2")) {
                    // Se corre la consulta 2.
                    Consultas.consulta2();
                } else if (entradaConsultas.equals("3")) {
                    // Se corre la consulta 3.
                     Consultas.consulta3();
                } else if (entradaConsultas.equals("4")) {
                    // Se corre la consulta 4.
                    Consultas.consulta4();
                } else if (entradaConsultas.equals("5")) {
                    // Se corre la consulta 5.
                    Consultas.consulta5();
                } else { // Ya habia controlado arriba que el numero este entre 1 y 6 por lo que este es el caso de que digite 6.
                    // Vuelve al menu principal
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        boolean datosCargados = false;

        while (true) {
            System.out.println("\nSeleccione la opción que desee:\n\t1. Cargar datos.\n\t2. Ejecutar consultas.\n\t3. Finalizar el programa.");

            // Leo lo que introduce el usuario.
            Scanner entradaScanMenu = new Scanner(System.in);
            String entradaMenu = entradaScanMenu.nextLine();

            if (!Validaciones.numberIsCorrect(entradaMenu, 1, 3)) {
                System.out.println("\nDato mal ingresado, intente ingresarlo nuevamente");
            } else if (entradaMenu.equals("1")) {
                if(!datosCargados){
                    Main.cargaDeDatos();
                    datosCargados = true;
                } else {
                    System.out.println("Los datos ya fueron cargados previamente.");
                }
            } else if (entradaMenu.equals("2")) {
                if(!datosCargados){
                    System.out.println("Debe cargarse los datos antes de realizar las consultas.");
                } else {
                    Main.consultas();
                }
            } else { // (NroMenu.equals("3")) Ya habia controlado arriba que el numero este entre 1 y 3 por lo que este es el caso de que digite 3.
                System.out.println("\nSe terminó el programa.");
                break;
            }
        }
    }
    //*/
}
