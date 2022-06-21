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
        System.out.println("\nIngrese un año");
        Scanner entradaScan = new Scanner(System.in);
        String entrada = entradaScan.nextLine();
        if (!numberIsCorrect(entrada, 1900, 2022)) {
            System.out.println("\nDato mal ingresado, intente ingresarlo nuevamente");
        }
        else {
            long firstTime = System.nanoTime();
            MyList<Brewery> listaTop10 = new MyLinkedListImpl<>();
            int reviewsminimas = 1;
            Brewery temp = null;
//        System.out.println(reviewList.size());
            for (int i = 1; i < reviewList.size(); i++) {
                temp = reviewList.get(i).getCerveceria();
//                System.out.println("" + temp);
                if (listaTop10.contains(temp)) {
                    // Va ser la misma cerveceria que ya tenia
                } else { // Este cast member entra al vector y tengo que reoganizarlo
                    listaTop10.add(temp);
                }
            }
            // Imprimo en pantalla lo correspondiente a la consulta 1
            long lastTime = System.nanoTime();
            long dif2 = lastTime - firstTime;
            double timeTotal = (double) dif2 / 1000000000;
//        for (int k = 0; k < 5; k++) {
//            System.out.println("\nNombre cerveza: " + listaTop10.get(k).getName() + "\nCantidad de reviews : " + "\n");
//        }
            System.out.println("\nTiempo de ejecución de la consulta:" + "\n" + timeTotal);
        }
        }

        public void consulta2 () {
            System.out.println("haciendo consulta 2");
        }

        public void consulta3 (MyList<Review> reviewList) {
            System.out.println("Introduzca la fecha inicio con formato dd/mm/yyyy");
            Date fechaInicio = pruebaFecha();
            System.out.println("Introduzca la fecha fin con formato dd/mm/yyyy");
            Date fechaFin = pruebaFecha();
            if (fechaInicio != null && fechaFin != null) {
                long firstTime = System.nanoTime();
                MyList<Review> lista = new MyLinkedListImpl<>();
                for (int i = 0; i < reviewList.size(); i++) {
                    if (reviewList.get(i).getDate().before(fechaFin) && reviewList.get(i).getDate().after(fechaInicio)) {
                        lista.add(reviewList.get(i));
                    }
                }
                long lastTime = System.nanoTime();
                long dif2 = lastTime - firstTime;
                double timeTotal = (double) dif2 / 1000000000;
                for (int i = 0; i<lista.size(); i++){
                    System.out.println("Review " + lista.get(i).getId() + " Fecha" + lista.get(i).getDate());
                }
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
                // FIXME
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


