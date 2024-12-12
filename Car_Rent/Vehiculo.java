/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
 * @author maran
 */
public class Vehiculo {
    private final String patente;
    private char condicion;

    public Vehiculo(String patente, char condicion) {
        this.patente = patente;
        this.condicion = condicion;
    }

    public String getPatente() {
        return patente;
    }

    public char getCondicion() {
        return condicion;
    }

    public void setCondicion(char condicion) {
        this.condicion = condicion;
    }

    public String[] toArray() {
        return new String[]{patente, String.valueOf(condicion)};
    }
}
