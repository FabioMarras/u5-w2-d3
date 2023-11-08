package fabiomarras.u5w2d2;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Elemento: " + id + " non trovato!");
    }
}
