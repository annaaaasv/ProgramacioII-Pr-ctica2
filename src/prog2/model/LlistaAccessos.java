package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAccessos implements InLlistaAccessos, Serializable {
    private ArrayList<Acces> llistaAccessos;

    public LlistaAccessos(){
        llistaAccessos = new ArrayList<>();
    }

    /**
     * Afegeix un accés rebut per paràmetre a la llista d'accessos.
     *
     * @param acc Objecte de tipus Acces.
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void afegirAcces(Acces acc){// throws ExcepcioCamping
        llistaAccessos.add(acc);
    }

    /**
     * Buida la llista d'accessos
     */
    @Override
    public void buidar() {
        llistaAccessos.clear();
    }

    /**
     * Itera sobre la llista d'accessos i retorna un String amb la informació de tots els accessos amb l'estat rebut per paràmetre.
     * En cas que no hi hagi accessos en l'estat passat com a paràmetre llança una excepció.
     *
     * @param estat boolean
     * @return String
     * @throws ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi accessos en l'estat passat com a parametre.
     *
     */
    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        Iterator<Acces> it = llistaAccessos.iterator();
        StringBuilder resultat = new StringBuilder();
        while(it.hasNext()) {
            Acces a = it.next();
            if(a.getEstat() == estat){
                resultat.append(a.getNom());
                if(it.hasNext()){
                    resultat.append(", ");
                }
            }
        }
        if(resultat.isEmpty()){
            throw new ExcepcioCamping("No hi ha cap accés en aquest estat");
        }

        return resultat.toString();
    }

    /**
     * Recorre tota la llista d'accessos i els tanca. Només decidirà obrir cadascun d'ells si permet l'accés a algun allotjament operatiu.
     *
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        Iterator<Acces> it = llistaAccessos.iterator();
        while(it.hasNext()) {
            Acces a = it.next();
            boolean algunOperatiu = false;
            for(int i = 0; i < a.getAllotjaments().getNumElements(); i++){
                Allotjament all = a.getAllotjaments().get(i);
                if(all.isOperatiu()){
                    algunOperatiu = true;
                    break;
                }
            }
            if(algunOperatiu){
                a.obrirAcces();
            }
            else{
                a.tancarAcces();
            }
        }
    }

    /**
     * Itera sobre la llista d'accessos i retorna el número d'accessos sense accessibilitat.
     *
     * @return int
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public int calculaAccessosNoAccessibles() {//throws ExcepcioCamping
        Iterator<Acces> it = llistaAccessos.iterator();
        int comptador = 0;
        while(it.hasNext()) {
            Acces a = it.next();
            if(!a.isAccessibilitat()){
                comptador++;
            }
        }
        return comptador;
    }

    /**
     * Itera sobre la llista d'accessos, i pels accessos de terra suma el total de metres (longitud) i ho retorna.
     *
     * @return float amb els metres totals.
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public float calculaMetresTerra(){// throws ExcepcioCamping
        Iterator<Acces> it = llistaAccessos.iterator();
        float metresTotals = 0;
        while(it.hasNext()) {
            Acces a = it.next();
            if(a instanceof AccesTerra){
                metresTotals += ((AccesTerra) a).getLongitud();
            }
        }
        return metresTotals;
    }
}
