package co.joxelito;

import co.joxelito.dao.BloqueoTemporal;
import co.joxelito.dao.PlazaParqueo;
import co.joxelito.service.BloqueoTemporalService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear plazas de parqueo
        PlazaParqueo plaza1 = new PlazaParqueo(1);
        PlazaParqueo plaza2 = new PlazaParqueo(2);

        // Instanciar el servicio
        BloqueoTemporalService servicio = new BloqueoTemporalService();

        // Crear un bloqueo temporal
        try {
            BloqueoTemporal bloqueo = servicio.crearBloqueo(
                Arrays.asList(plaza1, plaza2),
                LocalDate.now(),
                LocalDate.now().plusDays(2),
                "Mantenimiento"
            );
            System.out.println("Bloqueo creado con ID: " + bloqueo.getIdBloqueo());
        } catch (Exception e) {
            System.out.println("Error al crear bloqueo: " + e.getMessage());
        }

        // Consultar si una plaza está bloqueada
        boolean bloqueada = servicio.consultarSiBloqueo(plaza1, LocalDate.now(), LocalDate.now().plusDays(1));
        System.out.println("¿Plaza 1 bloqueada? " + bloqueada);

        // Consultar bloqueos activos
        List<BloqueoTemporal> activos = servicio.consultarBloqueosActivos();
        System.out.println("Bloqueos activos: " + activos.size());

        // Liberar un bloqueo
        if (!activos.isEmpty()) {
            servicio.liberarBloqueo(activos.get(0).getIdBloqueo());
            System.out.println("Bloqueo liberado.");
        }

        // Consultar bloqueos activos después de liberar
        System.out.println("Bloqueos activos tras liberar: " + servicio.consultarBloqueosActivos().size());
    }
}