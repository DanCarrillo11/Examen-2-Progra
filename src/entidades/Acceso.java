package entidades;

public class Acceso {
    private String idUsuario;
    private String fechaEntrada;
    private String fechaSalida;

    public Acceso(String idUsuario, String fechaEntrada, String fechaSalida) {
        this.idUsuario = idUsuario;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public String getIdUsuario() { return idUsuario; }
    public String getFechaEntrada() { return fechaEntrada; }
    public String getFechaSalida() { return fechaSalida; }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return idUsuario + "," + fechaEntrada + "," + fechaSalida;
    }
}