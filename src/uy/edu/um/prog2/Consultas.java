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
        Long[] breweryList = LoadData.getBreweryHashKeys();
        MyHeapImpl<Brewery> breweryHeap = new MyHeapImpl<>(false);

        for (int i = 0; i < cerveceríasTotales; i++) {
            breweryHash.get(breweryList[i]).setTotalReviewByYear(year); // Al correr esta operación sobre la cervecería de la iteración actual, se actualiza su número de reviews en el año del parámetro "year", en su variable "reviewsEnDeterminadoAño".
            breweryHeap.insert(breweryHash.get(breweryList[i]));
        }

        boolean hayReseñasAño = false;

        System.out.println("Top 10 de cervecerías con más reseñas en el año " + year + ":");
        for (int i = 0; i < 10; i++) {
            String space;
            if ((i + 1) < 10) {
                space = " ";
            } else {
                space = "";
            }
            Brewery breweryTop = breweryHeap.get();
            breweryHeap.delete();
            if (breweryTop.getReviewsEnDeterminadoAño() > 0) {
                hayReseñasAño = true;
                System.out.println("\t" + space + (i + 1) + ". ID: " + breweryTop.getId() +  " | Nombre: " + breweryTop.getName() + " | Reseñas: " + breweryTop.getReviewsEnDeterminadoAño());
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
    public static void consulta3 (Date startDate, Date endDate) {
        long consulta3StartTime = System.currentTimeMillis();

        //noinspection deprecation
        int startDateYear = 1900 + startDate.getYear();
        //noinspection deprecation
        int startDateMonth = 1 + startDate.getMonth();
        //noinspection deprecation
        int startDateDay = startDate.getDate();

        //noinspection deprecation
        int endDateYear = 1900 + endDate.getYear();
        //noinspection deprecation
        int endDateMonth = 1 + endDate.getMonth();
        //noinspection deprecation
        int endDateDay = endDate.getDate();

        String stringStartDate = String.valueOf(startDateDay) + "/" + String.valueOf(startDateMonth) + "/" + String.valueOf(startDateYear);
        String stringEndDate = String.valueOf(endDateDay) + "/" + String.valueOf(endDateMonth) + "/" + String.valueOf(endDateYear);

        int contadorReviewsFechas = 0;
        MyHashImpl<Long, Review> reviewHash = LoadData.getReviewHash();
        int reviewTotales = reviewHash.size();
        Long[] reviewKeyList = LoadData.getReviewHashKeys();

        for (int i = 0; i < reviewTotales; i++) {
            Date reviewDate = reviewHash.get(reviewKeyList[i]).getDate();

            if (reviewDate.equals(startDate) || reviewDate.after(startDate)) {
                if (reviewDate.equals(endDate) || reviewDate.before(endDate)) {
                    contadorReviewsFechas ++;
                }
            }
        }

        System.out.println("\tCantidad de reviews entre las fechas " + stringStartDate + " y " + stringEndDate + ": " + contadorReviewsFechas);
        long consulta3EndTime = System.currentTimeMillis();
        System.out.println("\nTiempo que toma en procesarse la consulta 3: " + (consulta3EndTime - consulta3StartTime) + " milisegundos.");

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
            System.out.println("\t" + (i + 1) + ". Estilo: " + styleTop.getName() + " | Aroma promedio: " + String.format("%.4f", styleTop.getAromaPromedio()));
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
            System.out.println("\t" + (i + 1) + ". Cerveza: " + beerTop.getName() + " | Reseñas: " + beerTop.getTotalReviews() + " | Puntaje general promedio: " + String.format("%.4f", beerTop.getPromedioPuntajeGeneral()));
        }

        long consulta5EndTime = System.currentTimeMillis();
        System.out.println("\nTiempo que toma en procesarse la consulta 5: " + (consulta5EndTime - consulta5StartTime) + " milisegundos.");
    }
}


