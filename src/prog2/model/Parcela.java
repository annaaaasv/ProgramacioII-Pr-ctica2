package prog2.model;

public class Parcela extends Allotjament{
    private float metres;
    private boolean connexioElectrica;

    public Parcela(String nom, String idAllotjament, boolean operatiu, String iluminacio, float metres, boolean connexioElectrica){
        super(nom, idAllotjament, 4, 2, true, "100%");
        this.metres = metres;
        this.connexioElectrica = connexioElectrica;
    }

    public float getMida(){
        return metres;
    }
    public void setMida(float metres){
        this.metres = metres;
    }
    public boolean isConnexioElectrica(){
        return connexioElectrica;
    }
    public void setConnexioElectrica(boolean connexioElectrica){
        this.connexioElectrica = connexioElectrica;
    }



    @Override
    public String toString(){
        return super.toString();
    }

}
