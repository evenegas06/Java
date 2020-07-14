package proyectobatallanaval;

public class Target {

    private final int coordenadaX;
    private final int coordenadaY;

    public Target(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }
}
