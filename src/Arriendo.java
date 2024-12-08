public abstract  class Arriendo {
    private int numArriendo;
    private String fechaArriendo;
    private int diasArriendo;
    private Vehiculo vehiculo;
    private Cliente cliente;

    public Arriendo(int numArriendo, String fechaArriendo, int diasArriendo, Vehiculo vehiculo, Cliente cliente) {
        this.numArriendo = numArriendo;
        this.fechaArriendo = fechaArriendo;
        this.diasArriendo = diasArriendo;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
    }

    public int getNumArriendo() {
        return numArriendo;
    }

    public void setNumArriendo(int numArriendo) {
        this.numArriendo = numArriendo;
    }

    public String getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(String fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public int getDiasArriendo() {
        return diasArriendo;
    }

    public void setDiasArriendo(int diasArriendo) {
        this.diasArriendo = diasArriendo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
