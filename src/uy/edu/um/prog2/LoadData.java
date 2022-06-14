package uy.edu.um.prog2;

import uy.edu.um.prog2.Entidades.Brewery;
import uy.edu.um.prog2.Entidades.Review;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class LoadData {

    // Prueba para ver si puedo imprimir las reviews (faltaría hacer un override de la función println para que imprima lo que querramos):
    /*
    public static void main(String[] Args) throws IOException {
        MyLinkedListImpl<Review> reviewList = LoadReviews();

        for (int i = 0; i < reviewList.size(); i++) {
            System.out.println(reviewList.get(i));
        }
    }
    */

    // Inicializacion de las estructuras donde guardaremos los datos
    private MyLinkedListImpl<Review> reviewList = new MyLinkedListImpl<>();
    private MyLinkedListImpl<Brewery> breweryList = new MyLinkedListImpl<>();

    //Getters de las estructuras
    public MyLinkedListImpl<Review> getReviewList() {
        return reviewList;
    }
    public MyLinkedListImpl<Brewery> getBreweryList() {return breweryList;}

    public LoadData() {
    }

    static MyLinkedListImpl<Review> LoadReviews() throws IOException {
        MyLinkedListImpl<Review> reviewList = new MyLinkedListImpl<>();

        FileReader fileReader = new FileReader("D:\\Facultad\\Ingeniería Informática\\2do año - 1er semestre 2022\\Programación 2\\Obligatorio\\Obligatorio_P2_2022\\Obligatorio2022-master\\src\\uy\\edu\\um\\prog2\\beer_dataset_test.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine(); // Salto la primera fila que contiene los títulos.

        while (line != null) {
            String[] atributos = line.split(",");

            // Obtengo el 1er atributo de la review y lo convierto de String a long.
            long id = Long.parseLong(atributos[0]);

            // Obtengo el 2do atributo de la review y lo convierto de String a Date.
            long seconds = Long.parseLong(atributos[3]);
            long milliseconds = seconds * 1000;
            Date date = new Date(milliseconds);

            // Obtengo el 3er atributo de la review y lo convierto de String a double.
            double overallScore = Double.parseDouble(atributos[4]);

            // Obtengo el 4to atributo de la review y lo convierto de String a double.
            double aromaScore = Double.parseDouble(atributos[5]);

            // Obtengo el 5to atributo de la review y lo convierto de String a double.
            double appearanceScore = Double.parseDouble(atributos[6]);

            // Obtengo el 6to atributo de la review y lo convierto de String a double.
            double flavourScore = Double.parseDouble(atributos[9]);

            // Creo una instancia de la clase Review para la linea actual del csv.
            Review review = new Review(id, date, overallScore, aromaScore, appearanceScore, flavourScore);

            reviewList.add(review);

        }

        return reviewList;
    }
}
