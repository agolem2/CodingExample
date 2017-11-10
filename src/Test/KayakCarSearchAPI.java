package Test;

public class KayakCarSearchAPI {

    private String destinations;

    public KayakCarSearchAPI() {
        super();
    }

    // API

    public String destinations() {
        return destinations;
    }

    public void destinations(final String destinations) {
        this.destinations = destinations;
    }
}