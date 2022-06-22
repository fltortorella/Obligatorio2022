package uy.edu.um.prog2.Entidades;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

public class Beer {

    private long id;
    private String name;
    private double abv;
    private Style style;
    private MyLinkedListImpl<Review> beerReviewList;

    public Beer(long id, String name, double abv) {
        this.id = id;
        this.name = name;
        this.abv = abv;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public Style getStyle() { return style; }

    public void setStyle(Style style) { this.style = style; }

    public MyLinkedListImpl<Review> getBeerReviewList() {
        return beerReviewList;
    }

    public void setBeerReviewList(MyLinkedListImpl<Review> beerReviewList) {
        this.beerReviewList = beerReviewList;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", abv=" + abv +
                ", style=" + style +
                ", beerReviewList=" + beerReviewList +
                '}';
    }
}
