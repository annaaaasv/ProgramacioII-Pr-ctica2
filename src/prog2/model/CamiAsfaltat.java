package prog2.model;

public class CamiAsfaltat extends AccesAsfalt{
    public CamiAsfaltat(String nom, boolean estat, float metres) {
        super(nom, estat, metres);
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
