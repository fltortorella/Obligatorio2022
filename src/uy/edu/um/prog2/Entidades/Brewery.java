package uy.edu.um.prog2.Entidades;

import uy.edu.um.prog2.adt.hash.MyHashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

import java.util.Date;

public class Brewery implements Comparable<Brewery> {

    private long id;
    private String name;
    private MyLinkedListImpl<Review> breweryReviewList = new MyLinkedListImpl<>();
    private MyHashImpl<Long, Review> breweryReviewHash = new MyHashImpl<>(50000);
    private Long[] reviewHashKeysPerBrewery = new Long[50000];
    private int contadorReviewsPerBrewery = 0;
    private int reviewsEnDeterminadoAño;

    public Brewery(long id, String name) {
        this.id = id;
        this.name = name;
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

    public MyLinkedListImpl<Review> getBreweryReviewList() {
        return breweryReviewList;
    }

    public void setBreweryReviewList(MyLinkedListImpl<Review> breweryReviewList) {
        this.breweryReviewList = breweryReviewList;
    }

    public MyHashImpl<Long, Review> getBreweryReviewHash() {
        return breweryReviewHash;
    }

    public void setBreweryReviewHash(MyHashImpl<Long, Review> breweryReviewHash) {
        this.breweryReviewHash = breweryReviewHash;
    }

    public Long[] getReviewHashKeysPerBrewery() {
        return reviewHashKeysPerBrewery;
    }

    public void setReviewHashKeysPerBrewery(Long[] reviewHashKeysPerBrewery) {
        this.reviewHashKeysPerBrewery = reviewHashKeysPerBrewery;
    }

    public int getReviewsEnDeterminadoAño() {
        return reviewsEnDeterminadoAño;
    }

    public void setReviewsEnDeterminadoAño(int reviewsEnDeterminadoAño) {
        this.reviewsEnDeterminadoAño = reviewsEnDeterminadoAño;
    }

    public void addToBreweryReviewList(Review review) {
        this.breweryReviewList.add(review);
    }

    public int getTotalReviews() {
        return this.getBreweryReviewList().size();
    }

    public void addKeyToHash(Long reviewId){
        reviewHashKeysPerBrewery[contadorReviewsPerBrewery] = reviewId;
        contadorReviewsPerBrewery ++;
    }
    public void setTotalReviewByYear(int year) {
        int contadorReviewsYear = 0;
        int totalReviews = this.getTotalReviews();

        for (int i = 0; i < totalReviews; i++) {
            long uno = System.currentTimeMillis();

            //noinspection deprecation
            if ((1900 + this.breweryReviewHash.get(reviewHashKeysPerBrewery[i]).getDate().getYear()) == year) {
                contadorReviewsYear ++;
            }
            long dos = System.currentTimeMillis();

            //System.out.println(dos - uno);
        }

        this.setReviewsEnDeterminadoAño(contadorReviewsYear);
    }

    @Override
    public String toString() {
        return "Brewery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override // Sobreescribo la operación de comparar instancias para utilizarlo en el heap.
    public int compareTo(Brewery brewery) {
        return Integer.compare(this.getReviewsEnDeterminadoAño(), brewery.getReviewsEnDeterminadoAño());
    }
}
