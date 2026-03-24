package prog2.model;

public class CamiAsfalt extends AccesAsfalt{
    public CamiAsfalt(String nom, boolean accessibilitat, float metres) {
        super(nom, accessibilitat, metres);
    }

    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     *
     * @return
     */
    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
