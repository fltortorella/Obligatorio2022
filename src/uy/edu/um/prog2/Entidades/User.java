package uy.edu.um.prog2.Entidades;

public class User {

    private String username;
    private int numeroReviews = 0;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumeroReviews() {
        return numeroReviews;
    }

    public void setNumeroReviews(int numeroReviews) {
        this.numeroReviews = numeroReviews;
    }

    public void nuevaReview() {
        this.numeroReviews ++;
    }

    @Override
    public String toString() {
        return "User: " +
                "Username: " + this.username +
                " | Reviews: " + this.numeroReviews;
    }
}
