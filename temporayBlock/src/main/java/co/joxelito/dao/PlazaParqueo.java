package co.joxelito.dao;

public class PlazaParqueo {
    private final int id;
    private boolean ocupada;

    public PlazaParqueo(int id) {
        this.id = id;
        this.ocupada = false;
    }

    public int getId() { return id; }
    public boolean isOcupada() { return ocupada; }
    public void setOcupada(boolean ocupada) { this.ocupada = ocupada; }
}
