package prog2.model;

public abstract class AccesAsfalt extends Acces{
    private float metres;

    public AccesAsfalt(String nom, boolean estat, float metres) {
        super(nom, estat);
        this.metres = metres;
    }

    @Override
    public String toString(){
        return super.toString() + ", Metres: " + metres;
    }



}
