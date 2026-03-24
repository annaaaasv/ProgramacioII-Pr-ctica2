package prog2.model;

public class CamiTerra extends AccesTerra{
    public CamiTerra(String nom, boolean accessibilitat, float longitud) {
        super(nom, accessibilitat, longitud);
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
