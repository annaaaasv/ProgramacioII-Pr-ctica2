package prog2.vista;

import prog2.model.Camping;

/**
 *
 * @author lauraigual
 */
public class IniciadorCamping {
    
    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        // Definim el nom del càmping
        String nomCamping = "Green";
            Camping camping = new Camping(nomCamping);

        // Creem un objecte de la vista i li passem el nom del càmping
        VistaCamping vistaCamping = new VistaCamping(camping);
     
        // Inicialitzem l'execució de la vista
        vistaCamping.gestioCamping();
    }
}
