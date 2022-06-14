package uy.edu.um.prog2;

import uy.edu.um.prog2.Entidades.Brewery;
import uy.edu.um.prog2.Entidades.Review;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class LoadData {

    /*
    public static void main(String[] Args) throws IOException {
        MyLinkedListImpl<Review> reviewList = LoadReviews();


        // Prueba para imprimir las reviews:
        for (int i = 0; i < reviewList.size(); i++) {
            System.out.println("ID: " + reviewList.get(i).getId() +
                                ", Date: " + reviewList.get(i).getDate() +
                                ", Overall: " + reviewList.get(i).getOverallScore() +
                                ", Aroma: " + reviewList.get(i).getAromaScore() +
                                ", Appearance: " + reviewList.get(i).getAppearanceScore() +
                                ", Flavour: " + reviewList.get(i).getFlavourScore());
        }


        // Cantidad de reviews (los registros del csv que tuvieran algún campo vacío no se convirtieron a instancia de review):
        System.out.println(reviewList.size());
    }
    */

    /*
    // Se inicializan las estructuras en donde irán las distintas entidades.
    private MyLinkedListImpl<Review> reviewList = new MyLinkedListImpl<>();
    private MyLinkedListImpl<Brewery> breweryList = new MyLinkedListImpl<>();
    */

    public LoadData() {
    }

    //Getters de las estructuras
    public MyLinkedListImpl<Review> getReviewList() throws IOException {
        MyLinkedListImpl<Review> reviewList = LoadReviews();
        return reviewList;
    }

    public MyLinkedListImpl<Brewery> getBreweryList() {
        // return breweryList;
        return null;
    }

    public static MyLinkedListImpl<Review> LoadReviews() throws IOException {
        MyLinkedListImpl<Review> reviewList = new MyLinkedListImpl<>();

        FileReader fileReader = new FileReader("D:\\Facultad\\Ingeniería Informática\\2do año - 1er semestre 2022\\Programación 2\\Obligatorio\\Obligatorio_P2_2022\\Obligatorio2022-master\\src\\uy\\edu\\um\\prog2\\beer_dataset_test.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Salto la primera fila que contiene los títulos.
        bufferedReader.readLine();

        // Declaro la variable line con la linea actual del archivo csv.
        String line = bufferedReader.readLine();

        // Creo un array de 14 elementos, en cada uno de sus elementos irá cada columna del csv al momento de iterarlo.
        String[] atributos = new String[14];

        int emptyCount = 0; // Contador de líneas del csv en donde faltan datos.

        // Recorro cada línea del csv hasta. Cuando se termina el csv, readLine() devuelve null.
        while (line != null) {

            // Separo los valores por las comas y los inserto en un array de strings.
            if (line.indexOf('"') == -1) { // Si no hay comillas en la actual línea del csv significa que no hay problemas de comas y puedo hacer el split tranquilamente.
                atributos = line.split(","); // Separo el texto de la variable "line" por las comas y lo guardo en un array de strings.

            } else { // Si hay comillas en la actual línea del csv, significa que hay una coma que no es separadora de campos, sino que es parte del texto y tengo que separarlo a mano.

                int lineLength = line.length(); // Variable con la cantidad de caracteres de la línea actual del csv.
                String atributo = ""; // Variable en la que se va a guardar cada atributo de la línea a ctual del csv.
                boolean comillas = false; // Variable booleana para saber si entro dentro de unas comillas. Si estoy dentro de unas comillas, la coma no debe separar.
                int elemento = 0;

                for (int i = 0; i < lineLength; i++) { // Recorro la línea actual del csv caracter por caracter.

                    if (line.charAt(i) == '"' && comillas == false) { // Si el caracter es una comilla y no estoy dentro de unas comillas.
                        comillas = true; // Seteo la variable "comillas" en true para saber que comienza el texto entre comillas.
                    } else if (line.charAt(i) == '"' && comillas == true) { // Si el caracter es una comilla y estoy dentro de unas comillas.
                        comillas = false; // Seteo la variable "comillas" en false para saber que se terminó el texto entre comillas.
                    }

                    if (line.charAt(i) != ',' || (line.charAt(i) == ',' && comillas == true)) { // Si el caracter no es una coma, o es una coma pero estoy dentro de unas comillas.
                        atributo += line.charAt(i); // Voy adicionando los caracteres a la variable atributo.
                    } else if (line.charAt(i) == ',' && comillas == false) { // Cuando el caracter es una coma y no estoy dentro de unas comillas, significa que ya se terminó la palabra.
                        atributos[elemento] = atributo; // Se agrega la palabra que se venía formando en la variable atributo al array de palabras atributos.
                        atributo = ""; // La variable atributo vuelve a ser vacía para rellenarse de cero.
                        elemento += 1;
                    }
                }
            }

            /*
            // Prueba para ver si los datos de cada línea del csv se guardan bien en la variable "atributos":
            System.out.println("ID: " + atributos[0] + " - Brewery_id: " + atributos[1] + " - Brewery_name: " + atributos[2] +
                                " - Review_time: " + atributos[3] + " - Review_overall: " + atributos[4] + " - Review_aroma: " + atributos[5] +
                                " - Review_appearance: " + atributos[6] + " - Review_profilename: " + atributos[7] + " - Beer_style: " + atributos[8] +
                                " - Review_palate: " + atributos[9] + " - Review_taste: " + atributos[10] + " - Beer_name: " + atributos[11] +
                                " - Beer_abv: " + atributos[12] + " - Beer_beerid: " +  atributos[13]);
            */

            // A partir del array "atributos" obtengo los distintos datos para crear las distintas instancias.
            // Se ajustan los tipos de datos ya que todos los elementos de "atributos" son Strings.
            // Pero primero me aseguro de que se cuenta con todos los datos de la review actual (las 14 columnas), si algún dato es vacío, no tengo en cuenta la review.
            if (!atributos[0].isEmpty() && !atributos[1].isEmpty() && !atributos[2].isEmpty() && !atributos[3].isEmpty()
                    && !atributos[4].isEmpty() && !atributos[5].isEmpty() && !atributos[6].isEmpty() && !atributos[7].isEmpty()
                    && !atributos[8].isEmpty() && !atributos[9].isEmpty() && !atributos[10].isEmpty() && !atributos[11].isEmpty()
                    && !atributos[12].isEmpty() && !atributos[13].isEmpty()) {

                // Campo 0: "review_id".
                long reviewId = Long.parseLong(atributos[0]);

                // Campo 1: "brewery_id".
                long breweryId = Long.parseLong((atributos[1]));

                // Campo 2: "brewery_name".
                String breweryName = atributos[2];

                // Campo 3: "review_time".
                long seconds = Long.parseLong(atributos[3]); // El dato del archivo csv está en segundos desde una determinada fecha.
                long milliseconds = seconds * 1000; // Paso de segundos a milisegundos.
                Date date = new Date(milliseconds); // Cambio el tipo de dato a "Date".

                // Campo 4: "review_overall".
                double overallScore = Double.parseDouble(atributos[4]);

                // Campo 5: "review_aroma".
                double aromaScore = Double.parseDouble(atributos[5]);

                // Campo 6: "review_appearance".
                double appearanceScore = Double.parseDouble(atributos[6]);

                // Campo 7: "review_profilename".
                String reviewProfilename = atributos[7];

                // Campo 8: "beer_style".
                String beerStyle = atributos[8];

                // Campo 9: "review_palate".
                double reviewPalate = Double.parseDouble(atributos[9]);

                // Campo 10: "review_taste".
                double reviewTaste = Double.parseDouble(atributos[10]);

                // Campo 11: "beer_name".
                String beerName = atributos[11];

                // Campo 12: "beer_abv".
                double beerAbv = Double.parseDouble(atributos[12]);

                // Campo 13: "beer_beerid".
                long BeerId = Long.parseLong(atributos[13]);

                // Creo una instancia de la clase Review para la linea actual del csv.
                Review review = new Review(reviewId, date, overallScore, aromaScore, appearanceScore, reviewPalate);

                // Agrego la nueva instancia de la clase Review a la lista.
                reviewList.add(review);
            } else {
                emptyCount += 1;
            }

            // Leo la próxima línea del csv.
            line = bufferedReader.readLine();
        }

        // System.out.println("Líneas de reviews con datos vacíos: " + emptyCount);

        return reviewList;
    }
}
