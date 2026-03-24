package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt{
    private float pesMax;

    public CarreteraAsfalt(String nom, boolean estat, float metres, float pesMax) {
        super(nom, estat, metres);
        this.pesMax = pesMax;
    }

    public void setPesMax(float pesMax) {
        this.pesMax = pesMax;
    }

    public float getPesMax() {
        return pesMax;
    }
    @Override
    public String toString(){
        return super.toString() + ", Pes màxim: " + pesMax;
    }

    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     *
     * @return
     */
    @Override
    public boolean isAccessibilitat() {
        return true;
    }
}
