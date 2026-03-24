package prog2.model;

public class MobilHome extends Casa{

    private boolean terrassaBarbacoa;

    public MobilHome(String nom, String idAllotjament, String mida, int habitacions, int placesPersones,
                     boolean terrassaBarbacoa) {
        super(nom, idAllotjament, 5, 3, mida, habitacions, placesPersones);
        this.terrassaBarbacoa = terrassaBarbacoa;

    }

    @Override
    public String toString(){
        return super.toString() +
                ", terradda barbacoa= " + terrassaBarbacoa + "}";

    }




}
