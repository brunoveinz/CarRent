/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
 * @author maran
 */
import java.util.ArrayList;

public class ArriendoCuota extends Arriendo {
    private final int cantCuotas;
    private final ArrayList<CuotaArriendo> cuotas;

    public ArriendoCuota(int numArriendo, String fecArr, int diasArriendo, Cliente cliente, Vehiculo vehiculo, int cantCuotas) {
        super(numArriendo,fecArr,diasArriendo, cliente, vehiculo);
        this.cantCuotas = cantCuotas;
        this.cuotas = new ArrayList<>();
    }

    public boolean ingresarArriendoConCuota(int precioDia) {
        try {
            generarCuotas(precioDia);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<CuotaArriendo> generarCuotas(int precioDia) {
        int montoTotal = obtenerMontoAPagar(precioDia);
        int valorCuota = montoTotal / cantCuotas;

        for (int i = 1; i <= cantCuotas; i++) {
            cuotas.add(new CuotaArriendo(i, valorCuota, false));
        }
        return cuotas;
    }

    public ArrayList<CuotaArriendo> getCuotas() {
        return cuotas;
    }
}
