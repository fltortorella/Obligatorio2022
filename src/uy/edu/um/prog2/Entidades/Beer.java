package uy.edu.um.prog2.Entidades;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

public class Beer {

    private long id;
    private String name;
    private double abv;
    private Style style;
    private MyLinkedListImpl<Review> beerReviewList = new MyLinkedListImpl<>();

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

    public MyLinkedListImpl<Review> getBeerReviewList() { return beerReviewList; }

    public void setBeerReviewList(MyLinkedListImpl<Review> beerReviewList) { this.beerReviewList = beerReviewList; }

    public void addToBeerReviewList(Review review) {
        this.beerReviewList.add(review);
    }

    @Override
    public String toString() {
        int cantidadReviews = this.getBeerReviewList().size();
        String reviewsId = "";
        for (int i = 0; i < cantidadReviews; i++) {
            reviewsId += this.getBeerReviewList().get(i).getId() + " ";
        }
        return "Beer: " +
                "ID: " + this.id +
                " | Name: " + this.name +
                " | ABV: " + this.abv +
                " | Style: " + this.getStyle().getName() +
                " | Aparece en " + cantidadReviews + " review/s: " + reviewsId;
    }
}