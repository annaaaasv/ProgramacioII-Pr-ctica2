package prog2.vista;

import prog2.model.Camping;

public class VistaCamping {
    private Camping camping;

    public VistaCamping(Camping camping){
        this.camping = camping;
        camping.inicialitzaDadesCamping();
    }

    public void gestioCamping(){

    }
}
