package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class LlistaAllotjaments implements InLlistaAllotjaments{
    private ArrayList<Allotjament> llistaAllotjaments;

    public LlistaAllotjaments(ArrayList<Allotjament> llistaAllotjaments){ //aixo cal???? ns perque ho he fet
        this.llistaAllotjaments = llistaAllotjaments;
    }

    public LlistaAllotjaments() {
        llistaAllotjaments = new ArrayList<>();
    }

    /**
     * Afegeix un allotjament rebut per paràmetre a la llista d'allotjaments.
     *
     * @param allotjament Objecte de tipus Allotjament
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    //QUINA EXCEPCIÓ LLANÇA?
    @Override
    public void afegirAllotjament(Allotjament allotjament){ // throws ExcepcioCamping
        llistaAllotjaments.add(allotjament);
    }

    /**
     * Buida la llista d'allotjaments.
     */
    @Override
    public void buidar() {
        llistaAllotjaments.clear();
    }

    /**
     * Itera sobre la llista d'allotjaments i retorna un String amb la informació de tots els allotjaments amb l'estat rebut per paràmetre.
     * En cas que no hi hagi allotjaments en l'estat passat com a paràmetre llança una excepció.
     *
     * @param estat
     * @return String
     * @throws ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi allotjaments en l'estat passat com a paràmetre.
     */
    //NO ENTENC ESTE PERQUE ESTAT ES UN STRING A QUÈ CONY ES REFEREIX, a operatiu/no operatiu
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        Iterator<Allotjament> it = llistaAllotjaments.iterator();
        StringBuilder resultat = new StringBuilder();
        while(it.hasNext()) {
            Allotjament a = it.next();
            if((estat.equalsIgnoreCase("Operatiu")&&a.isOperatiu()) || estat.equalsIgnoreCase("No operatiu")&&!a.isOperatiu()){
                resultat.append(a.toString()); //no detectta el toString com si fos un metode de Allotjament???????
            }

        }
        if(resultat.isEmpty()){
            throw new ExcepcioCamping("No hi ha cap allotjament amb aquest estat");
        }

        return resultat.toString();
    }

    /**
     * Mira si la llista d'allotjaments conté algun allotjament operatiu.
     *
     * @return boolean
     */
    @Override
    public boolean containsAllotjamentOperatiu() {
        Iterator<Allotjament> it = llistaAllotjaments.iterator();
        while(it.hasNext()) {
            Allotjament a = it.next();
            if (a.isOperatiu()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Mira si la llista d'allotjaments conté l'allotjament rebut per paràmetre i retorna un booleà amb la informació.
     *
     * @param allotjament
     * @return boolean
     */
    //s'ha de fer amb iterador o es pot fer aixi i ya????
    @Override
    public boolean contains(Allotjament allotjament) {
        return llistaAllotjaments.contains(allotjament);
    }


    /**
     * Busca l'allotjament amb el nom rebut per paràmetre i el retorna. En cas que no existeixi llança una excepció.
     *
     * @param id String amb el id de l'allotjament
     * @return Objecte de tipus Allotjament
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        Iterator<Allotjament> it = llistaAllotjaments.iterator();
        while(it.hasNext()){
            Allotjament a = it.next();
            if (Objects.equals(a.getId(), id)){
                return a;
            }
        }
        throw new ExcepcioCamping("No existeix l'allotjament amb id " + id);

    }
}
