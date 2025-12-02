package co.joxelito.dao;

import java.time.LocalDate;
import java.util.List;

public class BloqueoTemporal {
    private final int idBloqueo;
    private final List<PlazaParqueo> plazas;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;
    private final String motivo;

    public BloqueoTemporal(int idBloqueo, List<PlazaParqueo> plazas, LocalDate fechaInicio, LocalDate fechaFin, String motivo) {
        this.idBloqueo = idBloqueo;
        this.plazas = plazas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.motivo = motivo;
    }

    public int getIdBloqueo() { return idBloqueo; }
    public List<PlazaParqueo> getPlazas() { return plazas; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public String getMotivo() { return motivo; }

    public boolean estaActivo(LocalDate hoy) {
        return (hoy.isEqual(fechaInicio) || hoy.isAfter(fechaInicio)) && (hoy.isBefore(fechaFin) || hoy.isEqual(fechaFin));
    }
}