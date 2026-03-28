package prog2.model;

public class BungalowPremium extends Bungalow{
    private boolean serveisExtra;
    private String codiWifi;

    public BungalowPremium(String nom, String idAllotjament, boolean operatiu, String iluminacio, float mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {

        super(nom, idAllotjament,true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);

        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    @Override
    public String toString(){
        return super.toString() +
                ", serveis extra= " + serveisExtra + ", codi wifi= " + codiWifi + "}";
    }



}
