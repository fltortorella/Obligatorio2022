package uy.edu.um.prog2.Entidades;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

public class User {

    private String username;
    private MyLinkedListImpl<Review> userReviewList = new MyLinkedListImpl<>();

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MyLinkedListImpl<Review> getUserReviewList() {
        return userReviewList;
    }

    public void setUserReviewList(MyLinkedListImpl<Review> userReviewList) {
        this.userReviewList = userReviewList;
    }

    public void addToUserReviewList(Review review) {
        this.userReviewList.add(review);
    }

    @Override
    public String toString() {
        int cantidadReviews = this.getUserReviewList().size();
        String reviewsId = "";
        for (int i = 0; i < cantidadReviews; i++) {
            reviewsId += this.getUserReviewList().get(i).getId() + " ";
        }

        return "User: " +
                "Username: " + this.username +
                " | Escribió: " + cantidadReviews + " reviews: " + reviewsId;
    }
}
