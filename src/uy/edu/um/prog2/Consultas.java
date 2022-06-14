package uy.edu.um.prog2;

import uy.edu.um.prog2.Entidades.Brewery;
import uy.edu.um.prog2.Entidades.Review;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;


public class Consultas {

    //10 casas de cerveza con más reseñas en un año.
    public void consulta1(MyList<Review> reviewList, MyList<Brewery> breweryList){
        long firstTime = System.nanoTime();
        MyLinkedListImpl<Brewery> listaTop10 = new MyLinkedListImpl<>();
        int reviewsminimas = 1;
        Brewery temp;
//        for (int i = 10; i < breweryList.size(); i++){
//            temp = reviewList.get(breweryList.get(i).getId());
//        }
        // Imprimo en pantalla lo correspondiente a la consulta 1
        long lastTime = System.nanoTime();
        long dif2 = lastTime - firstTime;
        double timeTotal = (double) dif2/1000000000;
        for (int k = 0; k < 5; k++) {
            System.out.println("\nNombre cerveza: " + listaTop10.get(k).getName() + "\nCantidad de reviews : " + listaTop10.get(k).getName() + "\n");
        }
        System.out.println( "\nTiempo de ejecución de la consulta:" + "\n" + timeTotal);
    }
    public void consulta2(){
        System.out.println("haciendo consulta 2");
    }
    public void consulta3(){
        System.out.println("haciendo consulta 3");
    }
    public void consulta4(){
        System.out.println("haciendo consulta 4");
    }
    public void consulta5(){
        System.out.println("haciendo consulta 5");
    }

}
