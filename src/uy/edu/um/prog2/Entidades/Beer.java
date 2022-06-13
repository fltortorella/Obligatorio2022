package uy.edu.um.prog2.Entidades;

public class Beer {

    private long id;
    private String name;
    private double abv;
    private Style style;

    public Beer(long id, String name, double abv) {
        this.id = id;
        this.name = name;
        this.abv = abv;
        // this.style = new Style(); // FIXME para definir que el atributo style sea una instancia de la clase Style es necesario pasarle como atributo el nombre del style.
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
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
}
