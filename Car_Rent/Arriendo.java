/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
 * @author maran
 */
public class Arriendo {
    private final int numArriendo;
    private final String fecArr;
    private final int diasArriendo;
    private final Cliente cliente;
    private final Vehiculo vehiculo;

    public Arriendo(int numArriendo, String fecArr, int diasArriendo, Cliente cliente, Vehiculo vehiculo) {
        this.numArriendo = numArriendo;
        this.fecArr = fecArr;
        this.diasArriendo = diasArriendo;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }

    public int getNumArriendo() {
        return numArriendo;
    }

    public String getFecArr() {
        return fecArr;
    }

    public int getDiasArriendo() {
        return diasArriendo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public int obtenerMontoAPagar(int precioDia) {
        return diasArriendo * precioDia;
    }

    public String[] toArray() {
        return new String[]{String.valueOf(numArriendo), fecArr, String.valueOf(diasArriendo)};
    }
}


