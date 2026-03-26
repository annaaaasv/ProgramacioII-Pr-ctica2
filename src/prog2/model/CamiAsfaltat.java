package prog2.model;

public class CamiAsfaltat extends AccesAsfalt{
    public CamiAsfaltat(String nom, boolean accessibilitat, float metres) {
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
