package uy.edu.um.prog2.Entidades;

import java.util.Date;

public class Review {

    private long id;
    private Date date;
    private double overallScore;
    private double aromaScore;
    private double appearanceScore;
    private double flavourScore;

    public Review(long id, Date date, double overallScore, double aromaScore, double appearanceScore, double flavourScore) {
        this.id = id;
        this.date = date;
        this.overallScore = overallScore;
        this.aromaScore = aromaScore;
        this.appearanceScore = appearanceScore;
        this.flavourScore = flavourScore;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }

    public double getAromaScore() {
        return aromaScore;
    }

    public void setAromaScore(double aromaScore) {
        this.aromaScore = aromaScore;
    }

    public double getAppearanceScore() {
        return appearanceScore;
    }

    public void setAppearanceScore(double appearanceScore) {
        this.appearanceScore = appearanceScore;
    }

    public double getFlavourScore() {
        return flavourScore;
    }

    public void setFlavourScore(double flavourScore) {
        this.flavourScore = flavourScore;
    }
}