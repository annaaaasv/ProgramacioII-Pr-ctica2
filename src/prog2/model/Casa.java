package prog2.model;

public abstract class Casa extends Allotjament {
    private float mida;
    private int habitacions;
    private int placesPersones;

    public Casa(String nom, String idAllotjament, long estadaMinimaALTA, long estadaMinimaBAIXA, boolean operatiu, String iluminacio, float mida, int habitacions, int placesPersones){
        super(nom, idAllotjament, estadaMinimaALTA, estadaMinimaBAIXA,true, "100%");
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }

    @Override
    public String toString() {
        return super.toString() +
                getClass().getSimpleName() +
                "{mida= " + mida + ", habitacions= " + habitacions + ", places persones= " + placesPersones;
    }
}
