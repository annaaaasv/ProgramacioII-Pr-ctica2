package prog2.model;

public class TascaManteniment implements InTascaManteniment{
    private int numero;
    private Allotjament allotjament;
    private String data;
    private TipusTascaManteniment tipus;
    private int diesPerCompletar;

    public TascaManteniment(int numero, TipusTascaManteniment tipus, Allotjament allotjament, String data, int diesPerCompletar){
        this.numero = numero;
        this.tipus = tipus;
        this.allotjament = allotjament;
        this.data = data;
        this.diesPerCompletar = diesPerCompletar;
    }

    public static enum TipusTascaManteniment{
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    };

    /**
     * Retorna el número identificador de la tasca.
     *
     * @return int
     */
    @Override
    public int getNum() {
        return numero;
    }

    /**
     * Retorna el tipus de tasca de manteniment.
     *
     * @return TipusTascaManteniment
     */
    @Override
    public TascaManteniment.TipusTascaManteniment getTipus() {
        return tipus;
    }

    /**
     * Retorna l'allotjament associat a la tasca.
     *
     * @return Allotjament
     */
    @Override
    public Allotjament getAllotjament() {
        return allotjament;
    }

    /**
     * Retorna la data de registre de la tasca.
     *
     * @return String
     */
    @Override
    public String getData() {
        return data;
    }

    /**
     * Retorna el nombre de dies previstos per completar la tasca.
     *
     * @return int
     */
    @Override
    public int getDies() {
        return diesPerCompletar;
    }

    /**
     * Assigna un nou número identificador a la tasca.
     *
     * @param num_ Número identificador de la tasca.
     */
    @Override
    public void setNum(int num_) {
        numero = num_;
    }

    /**
     * Assigna el tipus de tasca de manteniment.
     *
     * @param tipus_ Tipus de tasca.
     */
    @Override
    public void setTipus(TascaManteniment.TipusTascaManteniment tipus_) {
        tipus = tipus_;
    }

    /**
     * Assigna l'allotjament associat a la tasca.
     *
     * @param allotjament_ Allotjament afectat.
     */
    @Override
    public void setAllotjament(Allotjament allotjament_) {
        allotjament = allotjament_;
    }

    /**
     * Assigna la data de registre de la tasca.
     *
     * @param data_ Data de la tasca.
     */
    @Override
    public void setData(String data_) {
        data = data_;
    }

    /**
     * Assigna el nombre de dies previstos per completar la tasca.
     *
     * @param dies_ Nombre de dies.
     */
    @Override
    public void setDies(int dies_) {
        diesPerCompletar = dies_;
    }

    /**
     * Retorna el percentatge d'il·luminació que ha de tenir l'allotjament
     * segons el tipus de tasca de manteniment.
     *
     * @return String amb el percentatge d'il·luminació.
     */
    @Override
    public String getIluminacioAllotjament() {
        return switch (tipus) {
            case Reparacio, RevisioTecnica -> "50%";
            case Neteja -> "100%";
            case Desinfeccio -> "0%";
        };
    }
}
