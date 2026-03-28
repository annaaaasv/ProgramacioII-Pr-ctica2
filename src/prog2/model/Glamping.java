package prog2.model;

public class Glamping extends Casa{

    private String material;
    private boolean casaMascota;


    public Glamping(String nom, String idAllotjament, boolean operatiu, String iluminacio, float mida, int habitacions, int placesPersones,
                    String material, boolean casaMascota){

        super(nom, idAllotjament, 5, 3,true, "100%", mida, habitacions, placesPersones);

        this.material = material;
        this.casaMascota = casaMascota;

    }

    @Override
    public String toString(){
        return super.toString() +
                ", material= " + material + ", casa mascota= " + casaMascota + "}";
    }



}
