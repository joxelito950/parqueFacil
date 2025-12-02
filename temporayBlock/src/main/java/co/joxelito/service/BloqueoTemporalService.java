package co.joxelito.service;

import co.joxelito.dao.BloqueoTemporal;
import co.joxelito.dao.PlazaParqueo;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BloqueoTemporalService {
    private int secuencia = 1;
    private final List<BloqueoTemporal> bloqueos = new ArrayList<>();

    public BloqueoTemporal crearBloqueo(List<PlazaParqueo> plazas, LocalDate inicio, LocalDate fin, String motivo) {
        for (PlazaParqueo plaza : plazas) {
            if (plaza.isOcupada() || consultarSiBloqueo(plaza, inicio, fin)) {
                throw new IllegalStateException("Plaza " + plaza.getId() + " ya está ocupada o bloqueada.");
            }
        }
        BloqueoTemporal bloqueo = new BloqueoTemporal(secuencia++, plazas, inicio, fin, motivo);
        bloqueos.add(bloqueo);
        return bloqueo;
    }

    public boolean consultarSiBloqueo(PlazaParqueo plaza, LocalDate inicio, LocalDate fin) {
        return bloqueos.stream().anyMatch(b ->
            b.getPlazas().contains(plaza) &&
            !(fin.isBefore(b.getFechaInicio()) || inicio.isAfter(b.getFechaFin()))
        );
    }

    public List<BloqueoTemporal> consultarBloqueosActivos() {
        LocalDate hoy = LocalDate.now();
        return bloqueos.stream().filter(b -> b.estaActivo(hoy)).collect(Collectors.toList());
    }

    public List<BloqueoTemporal> consultarBloqueosAnteriores() {
        LocalDate hoy = LocalDate.now();
        return bloqueos.stream().filter(b -> b.getFechaFin().isBefore(hoy)).collect(Collectors.toList());
    }

    public void liberarBloqueo(int idBloqueo) {
        bloqueos.removeIf(b -> b.getIdBloqueo() == idBloqueo);
    }
}