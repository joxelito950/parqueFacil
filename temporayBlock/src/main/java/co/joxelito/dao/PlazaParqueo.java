package co.joxelito.dao;

public class PlazaParqueo {
    private final int id;
    private EstadoPlaza estado;

    public PlazaParqueo(int id) {
        this.id = id;
        this.estado = EstadoPlaza.LIBRE;
    }

    public int getId() { return id; }
    public EstadoPlaza getEstado() { return estado; }
    public void setEstado(EstadoPlaza estado) { this.estado = estado; }

    public boolean estaBloqueada() {
        return this.estado == EstadoPlaza.BLOQUEADA;
    }
}