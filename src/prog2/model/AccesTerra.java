package prog2.model;

public abstract class AccesTerra extends Acces{
    private float longitud;

    public AccesTerra(String nom, boolean estat, float longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }

    @Override
    public String toString(){
        return super.toString() + ", Longitud: " + longitud;
    }


}
