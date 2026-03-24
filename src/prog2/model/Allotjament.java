package prog2.model;

public abstract class Allotjament implements InAllotjament{
    private String nom;
    private String idAllotjament;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;
    private boolean operatiu;
    private String iluminacio;

    public Allotjament(String nom, String idAllotjament, long estadaMinimaALTA, long estadaMinimaBAIXA, boolean operatiu, String iluminacio){
        this.nom = nom;
        this.idAllotjament = idAllotjament;
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
        this.operatiu = operatiu;
        this.iluminacio = iluminacio;

    }
    /** {@inheritDoc} */
    @Override
    public String getNom() {
        return nom;
    }
    /** {@inheritDoc} */
    @Override
    public String getId() {
        return idAllotjament;
    }
    /** {@inheritDoc} */
    @Override
    public void setNom(String nom){
        this.nom = nom;
    }
    /** {@inheritDoc} */
    @Override
    public void setId(String idAllotjament) {
        this.idAllotjament = idAllotjament;
    }
    /** {@inheritDoc} */
    @Override
    public long getEstadaMinima(Temp temp) {
        if(temp == Temp.BAIXA)
            return estadaMinimaBAIXA;
        else
            return estadaMinimaALTA;
    }
    /** {@inheritDoc} */
    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        estadaMinimaALTA = estadaMinimaALTA_;
        estadaMinimaBAIXA = estadaMinimaBAIXA_;
    }

    public void setOperatiu(boolean operatiu){
        this.operatiu = operatiu;
    }

    public boolean isOperatiu(){
        return operatiu;
    }

    public void setIluminacio(String iluminacio){
        this.iluminacio = iluminacio;
    }

    public String getIluminacio(){
        return iluminacio;
    }

    @Override
    public String toString(){
        return "Nom=" + nom + ", Id=" + idAllotjament+ ", estada mínima en temp ALTA: " + estadaMinimaALTA +
                ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA + ".";
    }

    /**
     * Modifica l'estat de l'allotjament a No Operatiu i la il·luminació depenent de la tasca rebuda com a paràmetre
     *
     * @param tasca Objecte de tipus TascaManteniment.
     */

    @Override
    public void tancarAllotjament(TascaManteniment tasca) {
        operatiu = false;
        switch(tasca.getTipus()){
            case Reparacio, RevisioTecnica:
                iluminacio = "50%";
                break;
            case Neteja:
                iluminacio = "100%";
                break;
            case Desinfeccio:
                iluminacio = "0%";
                break;
        }
    }

    /**
     * Modifica l'estat de l'allotjament a Operatiu i la il·luminació al 100%
     */
    @Override
    public void obrirAllotjament() {
        operatiu = true;
        iluminacio = "100%";

    }
}

