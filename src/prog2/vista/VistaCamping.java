package prog2.vista;

import prog2.model.Camping;

import java.util.Scanner;

public class VistaCamping {
    private Camping camping;

    public VistaCamping(Camping camping){
        this.camping = camping;
        camping.inicialitzaDadesCamping();
    }


    public void gestioCamping(){
        Scanner sc = new Scanner(System.in);
        enum OpcionsMenu {LLISTAR_ALL, LLISTAR_ALL_OP, LLISTAR_ALL_NOP, LLISTAR_ACC_O, LLISTAR_ACC_T, LLISTAR_TM_A,
            AFEGIR_TM, COMPLETAR_TM, NUM_ACC_NO_VEH, NUM_METRES_AT, GUARDAR_CAMP, REC_CAMP, SORTIR};
        String [] descripcions = {"Llistar la info de tots els allotjaments", "Llistar la info dels allotjaments operatius", "Llistar la info dels allotjaments no operatius",
        "Llistar la info dels accessos oberts", "Llistar la info dels accessos tancats", "Llistar la info de les tasques de manteniment actives", "Afegir una tasca de manteniment",
        "Completar una tasca de manteniment", "Calcular i mostrar del número total d'accessos que NO proporcionen accessibilitat amb vehicle",
                "Calcular i mostrar el número total de metres dels accessos de terra", "Guardar càmping", "Recuperar càmping", "Sortir de l'aplicació"};

        Menu<OpcionsMenu> menu = new Menu<>("Menu Càmping", OpcionsMenu.values());
        menu.setDescripcions(descripcions);
        OpcionsMenu opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio=menu.getOpcio(sc);
            try {
                switch (opcio) {
                    case LLISTAR_ALL:
                        System.out.println("Llista d'allotjaments: ");
                        System.out.println(camping.llistarAllotjaments());
                        break;
                    case LLISTAR_ALL_OP:
                        System.out.println("Llista d'allotjaments operatius: ");
                        System.out.println(camping.llistarAllotjaments("Operatiu"));
                        break;
                    case LLISTAR_ALL_NOP:
                        System.out.println("Llista d'allotjaments no operatius: ");
                        System.out.println(camping.llistarAllotjaments("No operatiu"));
                        break;
                    case LLISTAR_ACC_O:
                        System.out.println("Llista d'accessos oberts: ");
                        System.out.println(camping.llistarAccessos("Obert"));
                        break;
                    case LLISTAR_ACC_T:
                        System.out.println("Llista d'accessos tancats: ");
                        System.out.println(camping.llistarAccessos("Tancat"));
                        break;
                    case LLISTAR_TM_A:
                        System.out.println("Llista de tasques de manteniment actives: ");
                        System.out.println(camping.llistarTasquesManteniment());
                        break;
                    case AFEGIR_TM:
                        System.out.println("Quina tasca de manteniment vols afegir? ");
                        System.out.println("Número: ");
                        int numero = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Tipus: ");
                        String tipus = sc.nextLine();
                        System.out.println("idAllotjament: ");
                        String idAllotjament = sc.nextLine();
                        System.out.println("Data: (dd/mm/aaaa) ");
                        String data = sc.nextLine();
                        System.out.println("Dies: ");
                        int dies = sc.nextInt();
                        sc.nextLine();

                        camping.afegirTascaManteniment(numero, tipus, idAllotjament, data, dies);
                        break;
                    case COMPLETAR_TM:
                        System.out.println("Quina tasca de manteniment vols completar? ");
                        System.out.println("Número: ");
                        int num = sc.nextInt();
                        camping.completarTascaManteniment(num);
                        break;
                    case NUM_ACC_NO_VEH:
                        System.out.println("Número total d'accessos que NO proporcionen accessibilitat amb vehicle");
                        System.out.println(camping.calculaAccessosNoAccessibles());
                        break;
                    case NUM_METRES_AT:
                        System.out.println("Número total de metres dels accessos de terra");
                        System.out.println(camping.calculaMetresTerra());
                        break;
                    case GUARDAR_CAMP:
                        System.out.println("Cami destí: ");
                        String camiDesti = sc.nextLine();
                        camping.save(camiDesti);
                        System.out.println("Guardant càmping");
                        break;
                    case REC_CAMP:
                        System.out.println("Camí origen: ");
                        String camiOrigen = sc.nextLine();
                        Camping.load(camiOrigen);
                        System.out.println("Recuperant càmping");
                        break;
                    case SORTIR:
                        System.out.println("Fins aviat!");
                        break;
                }
            } catch(ExcepcioCamping e){
                System.out.println(e.getMessage());
            }

        } while(opcio!= OpcionsMenu.SORTIR);



    }
}
