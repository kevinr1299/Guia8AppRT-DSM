package sv.udb.edu.guia8apprt.datos;

import java.util.Date;

public class Persona {
    private String dui;
    private String nombre;
    private String born;
    private String sex;
    private String weight;
    private String height;
    String key;

    public Persona() {}

    public Persona(String dui, String nombre, String born, String sex, String weight, String height) {
        this.dui = dui;
        this.nombre =nombre;
        this.born = born;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
