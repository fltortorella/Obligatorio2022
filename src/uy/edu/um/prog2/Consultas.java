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
    public static void consulta1(int year) {
        long consulta1StartTime = System.currentTimeMillis();

        MyHashImpl<Long, Brewery> breweryHash = LoadData.getBreweryHash();
        int cerveceríasTotales = breweryHash.size();
        MyList<Brewery> breweryList = breweryHash.values();
        MyHeapImpl<Brewery> breweryHeap = new MyHeapImpl<>(false);

        for (int i = 0; i < cerveceríasTotales; i++) {
            breweryList.get(i).setTotalReviewByYear(year); // Al correr esta operación sobre la cervecería de la iteración actual, se actualiza su número de reviews en el año del parámetro "year", en su variable "reviewsEnDeterminadoAño".
            breweryHeap.insert(breweryList.get(i));
        }

        boolean hayReseñasAño = false;

        System.out.println("Top 10 de cervecerías con más reseñas en el año " + year + ":");
        for (int i = 0; i < 15; i++) {
            Brewery breweryTop = breweryHeap.get();
            breweryHeap.delete();
            if (breweryTop.getReviewsEnDeterminadoAño() > 0) {
                hayReseñasAño = true;
                System.out.println("\t" + (i + 1) + ". Nombre: " + breweryTop.getName() + " | Reseñas: " + breweryTop.getReviewsEnDeterminadoAño());
            }
        }

        if (!hayReseñasAño) {
            System.out.println("\tNo hay reseñas para el año seleccionado.");
        }

        long consulta1EndTime = System.currentTimeMillis();
        System.out.println("\nTiempo que toma en procesarse la consulta 1: " + (consulta1EndTime - consulta1StartTime) + " milisegundos.");
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
    public static void consulta5 () {
        long consulta5StartTime = System.currentTimeMillis();

        MyHashImpl<Long, Beer> beerHash = LoadData.getBeerHash();
        int cervezasTotales = beerHash.size();
        MyList<Beer> beerList = beerHash.values();
        MyHeapImpl<Beer> beerHeap = new MyHeapImpl<>(false);

        for (int i = 0; i < cervezasTotales; i++) {
            beerHeap.insert(beerList.get(i));
        }

        System.out.println("Top 5 de cervezas con más reseñas:");
        for (int i = 0; i < 5; i++) {
            Beer beerTop = beerHeap.get();
            beerHeap.delete();
            System.out.println("\t" + (i + 1) + ". Cerveza: " + beerTop.getName() + " | Reseñas: " + beerTop.getTotalReviews());
        }

        long consulta5EndTime = System.currentTimeMillis();
        System.out.println("\nTiempo que toma en procesarse la consulta 5: " + (consulta5EndTime - consulta5StartTime) + " milisegundos.");
    }
}


