package prog2.model;

public class MobilHome extends Casa{

    private boolean terrassaBarbacoa;

    public MobilHome(String nom, String idAllotjament, boolean operatiu, String iluminacio, float mida, int habitacions, int placesPersones,
                     boolean terrassaBarbacoa) {
        super(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones);
        this.terrassaBarbacoa = terrassaBarbacoa;

    }

    @Override
    public String toString(){
        return super.toString() +
                ", terradda barbacoa= " + terrassaBarbacoa + "}";

    }




}
