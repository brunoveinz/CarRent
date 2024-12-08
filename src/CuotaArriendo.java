public class CuotaArriendo {
    private int numCuota;
    private double valorCuota;
    private boolean pagada;

    public CuotaArriendo(int numCuota, double valorCuota, boolean pagada) {
        this.numCuota = numCuota;
        this.valorCuota = valorCuota;
        this.pagada = pagada;
    }

    public int getNumCuota() {
        return numCuota;
    }

    public void setNumCuota(int numCuota) {
        this.numCuota = numCuota;
    }

    public double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public boolean pagarCuota(){
        if (!pagada){
            this.pagada = true;
            return true;
        }
        return false;
    }

}
