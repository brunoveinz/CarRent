import java.util.ArrayList;
import java.util.List;

public class ArriendoCuota extends Arriendo {
    private int cantCuotas;
    private List<CuotaArriendo> cuotas;

    public ArriendoCuota(int numArriendo, String fechaArriendo, int diasArriendo, Vehiculo vehiculo, Cliente cliente, int cantCuotas, List<CuotaArriendo> cuotas) {
        super(numArriendo, fechaArriendo, diasArriendo, vehiculo, cliente);
        this.cantCuotas = cantCuotas;
        this.cuotas = cuotas;
    }

    public int getCantCuotas() {
        return cantCuotas;
    }

    public void setCantCuotas(int cantCuotas) {
        this.cantCuotas = cantCuotas;
    }

    public List<CuotaArriendo> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<CuotaArriendo> cuotas) {
        this.cuotas = cuotas;
    }

    public boolean ingresarArriendoConCuota(int precioDia){
        if (precioDia <= 0 || cantCuotas <= 0 ){
            return false;
        }
        this.cuotas = generarCuotas(precioDia);
        return true;
    }

    public ArrayList<CuotaArriendo> generarCuotas(int precioDia) {
        ArrayList<CuotaArriendo> listaCuotas = new ArrayList<>();
        int montoTotal = precioDia * getDiasArriendo(); // Calcular el monto total
        int montoPorCuota = montoTotal / cantCuotas; // Dividir el monto en partes iguales
        int residuo = montoTotal % cantCuotas; // Calcular el residuo para ajustar la última cuota

        for (int i = 1; i <= cantCuotas; i++) {
            int monto = montoPorCuota;
            if (i == cantCuotas) {
                monto += residuo; // Ajustar la última cuota
            }
            CuotaArriendo cuota = new CuotaArriendo(i, monto, false); // Crear una nueva cuota
            listaCuotas.add(cuota);
        }
        return listaCuotas;
    }


}
