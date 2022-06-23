package uy.edu.um.prog2.Entidades;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

public class Style implements Comparable<Style> {

    private String name;
    private MyLinkedListImpl<Beer> styleBeerList = new MyLinkedListImpl<>();
    private double aromaPromedio;

    public Style(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyLinkedListImpl<Beer> getStyleBeerList() {
        return styleBeerList;
    }

    public void setStyleBeerList(MyLinkedListImpl<Beer> styleBeerList) {
        this.styleBeerList = styleBeerList;
    }

    public double getAromaPromedio() {
        return aromaPromedio;
    }

    public void setAromaPromedio(double aromaPromedio) {
        this.aromaPromedio = aromaPromedio;
    }

    public void addToStyleBeerList(Beer beer) {
        this.styleBeerList.add(beer);
    }

    public int getTotalBeers() {
        return this.styleBeerList.size();
    }

    public String printAllBeersId() {
        String beerId = "";
        int beerTotales = this.getTotalBeers();
        for (int i = 0; i < beerTotales; i++) {
            beerId += this.getStyleBeerList().get(i).getId() + " ";
        }
        return beerId;
    }

    public double getPromedioAromaStyle() {
        double aromaTotal = 0;
        int reviewsTotalesStyle = 0;
        int beersTotales = this.getTotalBeers();

        for (int i = 0; i < beersTotales; i++) {
            int reviewsTotalesPerBeer = this.getStyleBeerList().get(i).getBeerReviewList().size();
            for (int j = 0; j < reviewsTotalesPerBeer; j++) {
                aromaTotal += this.getStyleBeerList().get(i).getBeerReviewList().get(j).getAromaScore();
                reviewsTotalesStyle ++;
            }
        }
        double aromaPromedioStyle = aromaTotal / reviewsTotalesStyle;

        this.setAromaPromedio(aromaPromedioStyle);

        return aromaPromedioStyle;
    }

    @Override // Sobreescribo la operación de comparar instancias para utilizarlo en el heap.
    public int compareTo(Style style) {
        return Integer.compare((int) (this.getAromaPromedio() * 1000000), (int) (style.getAromaPromedio() * 1000000)); // Me pide castearlo a int, entonces, para no perder los decimales multiplico por un valor alto de ambos lados.
    }

    @Override
    public String toString() {
        return "Style: " +
                "Name: " + this.getName() +
                " | Cervezas con este estilo: " + this.printAllBeersId();
    }
}
