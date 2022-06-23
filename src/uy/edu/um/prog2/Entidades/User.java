package uy.edu.um.prog2.Entidades;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

public class User implements Comparable<User> {

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

    public int getTotalReviews() {
        return this.getUserReviewList().size();
    }

    public String printAllReviewsId() {
        String reviewsId = "";
        int reviewTotales = this.getTotalReviews();
        for (int i = 0; i < reviewTotales; i++) {
            reviewsId += this.getUserReviewList().get(i).getId() + " ";
        }
        return reviewsId;
    }

    @Override
    public String toString() {
        return "User: " +
                "Username: " + this.getUsername() +
                " | Escribió: " + this.getTotalReviews() + " reviews: " + printAllReviewsId();
    }

    @Override // Sobreescribo la operación de comparar instancias para utilizarlo en el heap.
    public int compareTo(User user) {
        return Integer.compare(this.getUserReviewList().size(), user.getUserReviewList().size());
    }
}
