package uy.edu.um.prog2;

import uy.edu.um.prog2.Entidades.*;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class LoadData {


    public static void main(String[] Args) throws IOException {
        // Genero una instancia de la clase LoadData para que en el constructor se llame al método LoadData() y se carguen los datos.
        /*
        long mainStartTime = System.currentTimeMillis(); // Inicio a medir el tiempo que tarda en cargar los datos.
        System.out.println("Comienza la carga.");

        LoadData pruebaLoadData = new LoadData();

        MyLinkedListImpl<User> userList = LoadData.getUserList();
        MyLinkedListImpl<Style> styleList = LoadData.getStyleList();
        MyLinkedListImpl<Brewery> breweryList = LoadData.getBreweryList();
        MyLinkedListImpl<Beer> beerList = LoadData.getBeerList();
        MyLinkedListImpl<Review> reviewList = LoadData.getReviewList();

        long mainEndTime = System.currentTimeMillis(); // Finalizo la medición del tiempo que tarda en cargar los datos.
        System.out.println("Finaliza la carga.");

        System.out.println("Tiempo que toma la carga de los datos: " + (mainEndTime - mainStartTime) + " milisegundos."); // Imprimo el tiempo que tarda en la carga de los datos.
        //*/

        /*
        // Para imprimir los usuarios:
        System.out.println("Se tienen " + userList.size() + " distintos usuarios.");
        /*
        for (int i = 0; i < userList.size(); i++) {
            System.out.println("- Nombre: " + userList.get(i).getUsername());
        }
        //*/

        /*
        // Para imprimir los estilos de cerveza:
        System.out.println("Se tienen " + styleList.size() + " distintos estilos de cerveza:");
        /*
        for (int i = 0; i < styleList.size(); i++) {
            System.out.println("- " + styleList.get(i).getName());
        }
        //*/

        /*
        // Para imprimir las cervecerías:
        System.out.println("Se tienen " + breweryList.size() + " distintas cervecerías:");
        /*
        for (int i = 0; i < breweryList.size(); i++) {
            System.out.println("- ID: " + breweryList.get(i).getId() +
                    ", Nombre: " + breweryList.get(i).getName());
        }
        //*/

        /*
        // Para imprimir las cervezas:
        System.out.println("Se tienen " + beerList.size() + " distintas cervezas:");
        /*
        for (int i = 0; i < beerList.size(); i++) {
            System.out.println("- Nombre: " + beerList.get(i).getName() + ", Estilo: " + beerList.get(i).getStyle().getName());
        }
        //*/

        /*
        // Para imprimir las reviews:
        System.out.println("Se tienen " + reviewList.size() + " distintas reviews.");
        /*
        for (int i = 0; i < reviewList.size(); i++) {
            System.out.println("- ID: " + reviewList.get(i).getId() +
                                ", Date: " + reviewList.get(i).getDate() +
                                ", Overall: " + reviewList.get(i).getOverallScore() +
                                ", Aroma: " + reviewList.get(i).getAromaScore() +
                                ", Appearance: " + reviewList.get(i).getAppearanceScore() +
                                ", Flavour: " + reviewList.get(i).getFlavourScore() +
                                ", Usuario: " + reviewList.get(i).getUser().getUsername() +
                                ", ID Brewery: " + reviewList.get(i).getBrewery().getId() +
                                ", Nombre Brewery: " + reviewList.get(i).getBrewery().getName());
        }
        //*/

        // Cosulta 3.
        /*
        long consulta3StartTime = System.currentTimeMillis(); // Inicio a medir el tiempo que tarda en procesarse la consulta 3.

        int cantidadReviews = reviewList.size();
        int cantidadUsuarios = userList.size();
        String[] arrayNombreUsuarios = new String[cantidadUsuarios];
        int[] arrayHistogramaUsuarios = new int[cantidadUsuarios];

        for (int i = 0; i < cantidadUsuarios; i++) {
            arrayNombreUsuarios[i] = userList.get(i).getUsername();
        }

        for (int i = 0; i < cantidadReviews; i++) {
            String nombreUsuario = reviewList.get(i).getUser().getUsername();
            int indiceNombre = Arrays.asList(arrayNombreUsuarios).indexOf(nombreUsuario);
            arrayHistogramaUsuarios[indiceNombre] ++;
        }

        /*
        for (int i = 0; i < cantidadUsuarios; i++) {
            System.out.println("Nombre: " + arrayNombreUsuarios[i] + ", Reviews: " + arrayHistogramaUsuarios[i]);
        }
        */

        /*
        long consulta3endTime = System.currentTimeMillis(); // Finalizo de medir el tiempo que tarda en procesarse la consulta 3.
        System.out.println("Tiempo que toma en procesarse la consulta 3 es de: " + (consulta3endTime - consulta3StartTime) + " milisegundos."); // Imprimo el tiempo que tarda procesarse la consulta 3.
        //*/
    }

    public LoadData() throws IOException {
        this.LoadData();
    }

    // Se inicializan las estructuras en donde irán las distintas entidades.
    private static MyLinkedListImpl<User> userList = new MyLinkedListImpl<>();
    private static MyLinkedListImpl<Style> styleList = new MyLinkedListImpl<>();
    private static MyLinkedListImpl<Brewery> breweryList = new MyLinkedListImpl<>();
    private static MyLinkedListImpl<Beer> beerList = new MyLinkedListImpl<>();
    private static MyLinkedListImpl<Review> reviewList = new MyLinkedListImpl<>();

    //Getters de las estructuras.
    public static MyLinkedListImpl<User> getUserList() {
        return userList;
    }

    public static MyLinkedListImpl<Style> getStyleList() {
        return styleList;
    }

    public static MyLinkedListImpl<Brewery> getBreweryList() {
        return breweryList;
    }

    public static MyLinkedListImpl<Beer> getBeerList() {
        return beerList;
    }

    public static MyLinkedListImpl<Review> getReviewList() throws IOException {
        return reviewList;
    }

    public void LoadData() throws IOException {
        MyLinkedListImpl<String> userNameList = new MyLinkedListImpl<>(); // Lista para guardar los distintos nombres users, para no repetir entidades.
        MyLinkedListImpl<String> styleNameList = new MyLinkedListImpl<>(); // Lista para guardar los distintos nombres de syles, para no repetir entidades.
        MyLinkedListImpl<Long> breweryIdList = new MyLinkedListImpl<>(); // Lista para guardar los distintos ID's de las brewerys, para no repetir entidades.
        MyLinkedListImpl<Long> beerIdList = new MyLinkedListImpl<>(); // Lista para guardar los distintos ID's de las beers, para no repetir entidades.

        // Para la carga de datos utilizo las siguientes líneas de código.
        String filePath = new File("").getAbsolutePath(); // Devuelve el path absoluto.
        String csvPath = filePath + "\\src\\uy\\edu\\um\\prog2\\beer_dataset_minitest.csv"; // Al path absoluto le concateno el path hasta el archivo csv.
        FileReader fileReader = new FileReader(csvPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Salto la primera fila que contiene los títulos.
        bufferedReader.readLine();

        // Declaro la variable line con la linea actual del archivo csv.
        String line = bufferedReader.readLine();

        // Creo un array de 14 elementos, en cada uno de sus elementos irá cada columna del csv al momento de iterarlo.
        String[] atributos = new String[14];

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

                    if ((line.charAt(i) != ',' && line.charAt(i) != '"') || (line.charAt(i) == ',' && comillas == true)) { // Si el caracter no es una coma, o es una coma pero estoy dentro de unas comillas.
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
                String reviewProfileName = atributos[7];

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
                long beerId = Long.parseLong(atributos[13]);


                // Creo las instancias y las agrego a sus respectivos TADs.

                // Instancia de User.
                User user = new User(reviewProfileName); // Creo un nueva nueva instancia de User por cada línea del csv, porque sino luego a la hora de asignar el user a la review, se demora mucho en buscar el usuario de la lista para las reviews que repiten usuario.
                if (!userNameList.contains(reviewProfileName)) { // Si la lista de nombres de usuario ya recorridos no contiente al de la línea actual del csv.
                    userNameList.add(reviewProfileName); // Lo agrego a la lista de usuarios ya vistos.
                    userList.add(user); // Agrego la nueva instancia de la clase User a su lista.
                }

                // Instancia de Style.
                Style style = new Style(beerStyle); // Creo un nueva nueva instancia de Style por cada línea del csv, porque sino luego a la hora de asignar el style a la beer, se demora mucho en buscar el style de la lista para las beers que repiten style.
                if (!styleNameList.contains(beerStyle)) { // Si la lista de nombres de estilos de cervezas ya reccorridos no contiene al de la línea actual del csv.
                    styleNameList.add(beerStyle); // Lo agrego a la lista de estilos de cerveza ya vistos.
                    styleList.add(style); // Agrego la nueva instancia de la clase Style a su lista.
                }

                // Instancia de Brewery.
                Brewery brewery = new Brewery(breweryId, breweryName); // Creo un nueva nueva instancia de Brewery por cada línea del csv, porque sino luego a la hora de asignar el brewery a la review, se demora mucho en buscar el brewery de la lista para las reviews que repiten brewery.
                if (!breweryIdList.contains(breweryId)) { // Si la lista de ID's de brewery ya recorridas no contiene a la de la línea actual del csv.
                    breweryIdList.add(breweryId); // Agrego el ID de brewery de la línea actual del csv a la lista de ID's de brewery.
                    breweryList.add(brewery); // Agrego la nueva instancia de la clase Brewery a su lista.
                }

                // Instancia de Beer.
                if (!beerIdList.contains(beerId)) { // Si la lista de ID's de beers ya recorridas no contiene a la de la línea actual del csv.
                    beerIdList.add(beerId); // Agrego el ID de beer de la línea actual del csv a la lista de ID's de beers.
                    Beer beer = new Beer(beerId, beerName, beerAbv); // Creo la instancia de la clase Beer para la línea actual del csv.
                    beer.setStyle(style); // Le asigno el objeto Style encontrado a el objeto Beer de esta iteración.
                    beerList.add(beer); // Agrego la nueva instancia de la clase Beer a su lista.
                }

                // Instancia de Review.
                Review review = new Review(reviewId, date, overallScore, aromaScore, appearanceScore, reviewPalate); // Creo la instancia de la clase Review para la línea actual del csv.
                review.setUser(user);
                review.setBrewery(brewery);
                reviewList.add(review); // Agrego la nueva instancia de la clase Review a su lista.
            }

            // Leo la próxima línea del csv.
            line = bufferedReader.readLine();
        }
    }
}