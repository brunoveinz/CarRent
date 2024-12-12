/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
 * @author maran
 */
public class CuotaArriendo {
    private final int numCuota;
    private final int valorCuota;
    private boolean pagada;

    public CuotaArriendo(int numCuota, int valorCuota, boolean pagada) {
        this.numCuota = numCuota;
        this.valorCuota = valorCuota;
        this.pagada = pagada;
    }

    public int getNumCuota() {
        return numCuota;
    }

    public int getValorCuota() {
        return valorCuota;
    }

    public boolean isPagada() {
        return pagada;
    }

    public boolean pagarCuota() {
        if (!pagada) {
            pagada = true;
            return true;
        }
        return false;
    }

    public String[] toArray() {
        return new String[]{String.valueOf(numCuota), String.valueOf(valorCuota), String.valueOf(pagada)};
    }
}

