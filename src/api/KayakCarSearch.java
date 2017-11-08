package api;

public class KayakCarSearch {

    private String destinations;

    public KayakCarSearch() {
        super();
    }

    // API

    public String getapt_code() {
        return destinations;
    }

    public void getapt_code(final String destinations) {
        this.destinations = destinations;
    }
}