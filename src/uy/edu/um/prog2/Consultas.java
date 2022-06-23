package uy.edu.um.prog2;

import uy.edu.um.prog2.Entidades.*;
import uy.edu.um.prog2.adt.hash.MyHashImpl;
import uy.edu.um.prog2.adt.heap.MyHeapImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Consultas {

    // Consulta 1: las 10 cervecerías con más reseñas en un año dado.
    public static void consulta1(MyList<Review> reviewList, MyList<Brewery> breweryList) {
        System.out.println("Consulta 1");
        /*
        long firstTime = System.nanoTime();
        System.out.println("\nIngrese un año");
        Scanner entradaScan = new Scanner(System.in);
        String entrada = entradaScan.nextLine();
        if (!numberIsCorrect(entrada, 1900, 2022)) {
            System.out.println("\nDato mal ingresado, intente ingresarlo nuevamente");
        }
        else {
            MyList<Brewery> listaTop10 = new MyLinkedListImpl<>();
            Brewery temp = null;
            for (int i = 0; i < 3; i++) {
                SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
                String year = getYearFormat.format(reviewList.get(i).getDate());
                if (year.equals(entrada)){              // si la review es de ese anio
                    temp = reviewList.get(i).getBrewery();
                    listaTop10.add(temp);
                }
//
            }
            // Imprimo en pantalla lo correspondiente a la consulta 1
            for (int k = 0; k < listaTop10.size(); k++) {

                System.out.println("\nNombre cerveceria: " + listaTop10.get(k).getName() + " Cantidad reviews: ");
            }
        }
        long lastTime = System.nanoTime();
        long dif2 = lastTime - firstTime;
        double timeTotal = (double) dif2 / 1000000000;
        System.out.println("\nTiempo de ejecución de la consulta:" + "\n" + timeTotal);
        */
    }

    // Consulta 2: top 15 catadores con más reseñas.
    public static void consulta2 () {
        long consulta2StartTime = System.currentTimeMillis();

        MyHashImpl<String, User> userHash = LoadData.getUserHash();
        int usuariosTotales = userHash.size();
        MyList<User> usersList = userHash.values();
        MyHeapImpl<User> userHeap = new MyHeapImpl<>(false);

        for (int i = 0; i < usuariosTotales; i++) {
            userHeap.insert(usersList.get(i));
        }

        System.out.println("Top 15 de usuarios con más reseñas:");
        for (int i = 0; i < 15; i++) {
            String space;
            if ((i + 1) < 10) {
                space = " ";
            } else {
                space = "";
            }
            User usuarioTop = userHeap.get();
            userHeap.delete();
            System.out.println("\t" + space + (i + 1) + ". Username: " + usuarioTop.getUsername() + " | Reseñas: " + usuarioTop.getTotalReviews());
        }

        long consulta2EndTime = System.currentTimeMillis();
        System.out.println("\nTiempo que toma en procesarse la consulta 2: " + (consulta2EndTime - consulta2StartTime) + " milisegundos.");
    }

    // Consulta 3: cantidad de reviews en un período de tiempo dado.
    public static void consulta3 (MyList<Review> reviewList) {
        System.out.println("Consulta 3");
        /*
        int count = 0;
        System.out.println("Introduzca la fecha inicio con formato dd/mm/yyyy");
        Date fechaInicio = pruebaFecha();
        System.out.println("Introduzca la fecha fin con formato dd/mm/yyyy");       // no incluye ese dia
        Date fechaFin = pruebaFecha();
        if (fechaInicio != null && fechaFin != null) {
            long firstTime = System.nanoTime();
            for (int i = 0; i < reviewList.size(); i++) {
                if (reviewList.get(i).getDate().before(fechaFin) && reviewList.get(i).getDate().after(fechaInicio)) {
                    count++;
                }
            }
            long lastTime = System.nanoTime();
            long dif2 = lastTime - firstTime;
            double timeTotal = (double) dif2 / 1000000000;
            System.out.println("Cantidad de reviews dento del rango ingresado: " + count);
            System.out.println("\nTiempo de ejecución de la consulta:" + "\n" + timeTotal);
        } else {
            System.out.println("Intente nuevamente");
        }
        */
    }

    // Consulta 4: top 7 estilos de cerveza con mejor aroma.
    public static void consulta4 () {
        long consulta4StartTime = System.currentTimeMillis();

        MyHashImpl<String, Style> styleHash = LoadData.getStyleHash();
        MyList<Style> stylesList = styleHash.values();
        int estilosTotales = styleHash.size();
        for (int i = 0; i < estilosTotales; i++) {
            stylesList.get(i).getPromedioAromaStyle(); // Cada vez que llamo a la operación getPromedioAromaStyle() se calcula la variable "aromaPromedio" para la instancia de Style de la iteración actual.
        }

        MyHeapImpl<Style> styleHeap = new MyHeapImpl<>(false);
        for (int i = 0; i < estilosTotales; i++) {
            styleHeap.insert(stylesList.get(i));
        }

        System.out.println("Top 7 de estilos de cerveza con mejor aroma:");
        for (int i = 0; i < 7; i++) {
            Style styleTop = styleHeap.get();
            styleHeap.delete();
            System.out.println("\t" + (i + 1) + ". Estilo: " + styleTop.getName() + " | Aroma promedio: " + styleTop.getAromaPromedio());
        }

        long consulta4EndTime = System.currentTimeMillis();
        System.out.println("\nTiempo que toma en procesarse la consulta 4: " + (consulta4EndTime - consulta4StartTime) + " milisegundos.");
    }

    // consulta 5: top 5 cervezas con más reviews.
    public static void consulta5 (MyList<Beer> beerList) {
        System.out.println("Consulta 5");
        /*
        for (int i = 0; i < beerList.size(); i++){
//                beerList.get(i).g
        }
        */
    }

    /*
    public Date pruebaFecha() {
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
    */
}


