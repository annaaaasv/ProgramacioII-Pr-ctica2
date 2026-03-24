package prog2.model;

public class CarreteraTerra extends AccesTerra{
    private float amplada;

    public CarreteraTerra(String nom, boolean estat, float longitud, float amplada) {
        super(nom, estat, longitud);
        this.amplada = amplada;
    }

    public void setAmplada(float amplada) {
        this.amplada = amplada;
    }

    public float getAmplada(){
        return amplada;
    }
    @Override
    public String toString(){
        return super.toString() + ", Amplada: " + amplada;
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
