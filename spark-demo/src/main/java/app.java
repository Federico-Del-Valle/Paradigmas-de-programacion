
import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class app {

    private static List<Hotel> hoteles = new ArrayList<>();
    private static Gson gson = new Gson();

    public static void main(String[] args) {

        // Configuración del puerto
        port(8080);

        // Datos iniciales
        hoteles.add(new Hotel(1, "Hotel Plaza", "Buenos Aires", 150.0));
        hoteles.add(new Hotel(2, "Hotel Costa", "Mar del Plata", 120.0));

        // Configurar respuestas en JSON
        after((req, res) -> res.type("application/json"));

        // ===== ENDPOINTS =====

        // GET - Obtener todos los hoteles
        get("/api/hoteles", (req, res) -> {
            return gson.toJson(hoteles);
        });

        // GET - Obtener hotel por ID
        get("/api/hoteles/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Hotel hotel = hoteles.stream()
                    .filter(h -> h.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (hotel != null) {
                return gson.toJson(hotel);
            } else {
                res.status(404);
                return "{\"error\": \"Hotel no encontrado\"}";
            }
        });

        // POST - Crear nuevo hotel
        post("/api/hoteles", (req, res) -> {
            Hotel nuevoHotel = gson.fromJson(req.body(), Hotel.class);


            String error = validarAlta(nuevoHotel);
            if (error != null) {
                res.status(400); // Bad Request
                return gson.toJson(new MensajeError(error));
            }
            hoteles.add(nuevoHotel);
            res.status(201);
            return gson.toJson(nuevoHotel);
        });

        // PUT - Actualizar hotel
        put("/api/hoteles/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Hotel hotelActualizado = gson.fromJson(req.body(), Hotel.class);

            for (int i = 0; i < hoteles.size(); i++) {
                if (hoteles.get(i).getId() == id) {
                    hoteles.set(i, hotelActualizado);
                    return gson.toJson(hotelActualizado);
                }
            }

            res.status(404);
            return "{\"error\": \"Hotel no encontrado\"}";
        });

        // DELETE - Eliminar hotel
        delete("/api/hoteles/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            boolean eliminado = hoteles.removeIf(h -> h.getId() == id);

            if (eliminado) {
                return "{\"mensaje\": \"Hotel eliminado\"}";
            } else {
                res.status(404);
                return "{\"error\": \"Hotel no encontrado\"}";
            }
        });

        System.out.println("API REST iniciada en http://localhost:8080");
    }

    private static String validarAlta(Hotel h) {
        if (h == null) return "Cuerpo JSON inválido";
        if (h.getNombre() == null || h.getNombre().isBlank()) return "El campo 'nombre' es obligatorio";
        if (h.getCiudad() == null || h.getCiudad().isBlank()) return "El campo 'ciudad' es obligatorio";
        if (h.getPrecio() <= 0) return "El campo 'precio' debe ser mayor a 0";
        return null; // válido
    }

    static class MensajeError {
        private final String error;
        MensajeError(String error) { this.error = error; }
        public String getError() { return error; }
    }
}

