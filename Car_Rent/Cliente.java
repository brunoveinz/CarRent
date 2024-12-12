/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

 *
 * @author maran
 */
public class Cliente {
    private final String cedula;
    private final String nombre;
    private boolean vigente;

    public Cliente(String cedula, String nombre, boolean vigente) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.vigente = vigente;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public String[] toArray() {
        return new String[]{cedula, nombre, String.valueOf(vigente)};
    }
}
