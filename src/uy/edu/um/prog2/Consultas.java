package uy.edu.um.prog2;

import uy.edu.um.prog2.Entidades.Beer;
import uy.edu.um.prog2.Entidades.Brewery;
import uy.edu.um.prog2.Entidades.Review;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static uy.edu.um.prog2.Main.numberIsCorrect;


public class Consultas {

    //10 casas de cerveza con más reseñas en un año.
    public void consulta1(MyList<Review> reviewList, MyList<Brewery> breweryList) {
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
        }

        public void consulta2 () {
            System.out.println("haciendo consulta 2");
        }

        public void consulta3 (MyList<Review> reviewList) {
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

        }
        public void consulta4 () {
            System.out.println("haciendo consulta 4");
        }

        public void consulta5 (MyList<Beer> beerList) {
            for (int i = 0; i < beerList.size(); i++){
//                beerList.get(i).g
            }
        }

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
    }


