package prog2.model;

public class Bungalow extends Casa {
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    public Bungalow(String nom, String idAllotjament, boolean operatiu, String iluminacio, float mida, int habitacions, int placesPersones,
                    int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {

        super(nom, idAllotjament, 7, 4,true, "100%", mida, habitacions, placesPersones);

        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }

    public boolean isAireFred(){
        return aireFred;
    }

    @Override
    public String toString(){
        return super.toString() +
                ", places pàrquing= " + placesParquing + ", terrassa= " + terrassa + ", tv= " + tv;
    }





}
