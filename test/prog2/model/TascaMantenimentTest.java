package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TascaMantenimentTest {
    private TascaManteniment tasca;
    private Allotjament allotjament;

    @BeforeEach
    void setUp() {
        // Suposant que Allotjament té un constructor bàsic
        allotjament = new Parcela("Allotjament Test", "ID001", true,  "100%", 50,  true);
        tasca = new TascaManteniment(1, TascaManteniment.TipusTascaManteniment.REPARACIO, allotjament, "2024-03-25", 4);
    }

    @Test
    void testConstructor() {
        assertEquals(1, tasca.getNum());
        assertEquals(TascaManteniment.TipusTascaManteniment.REPARACIO, tasca.getTipus());
        assertEquals(allotjament, tasca.getAllotjament());
        assertEquals("2024-03-25", tasca.getData());
        assertEquals(4, tasca.getDies());
    }

    @Test
    void testSetters() {
        Allotjament nouAllotjament = new Parcela("Nou", "ID002", true, "100%", 50, true);

        tasca.setNum(10);
        assertEquals(10, tasca.getNum());

        tasca.setTipus(TascaManteniment.TipusTascaManteniment.NETEJA);
        assertEquals(TascaManteniment.TipusTascaManteniment.NETEJA, tasca.getTipus());

        tasca.setAllotjament(nouAllotjament);
        assertEquals(nouAllotjament, tasca.getAllotjament());

        tasca.setData("2025-01-01");
        assertEquals("2025-01-01", tasca.getData());

        tasca.setDies(7);
        assertEquals(7, tasca.getDies());
    }

    @Test
    void testGetIluminacioAllotjamentReparacio() {
        TascaManteniment t =
                new TascaManteniment(2, TascaManteniment.TipusTascaManteniment.REPARACIO, allotjament, "2024-01-01", 3);

        assertEquals("50%", t.getIluminacioAllotjament());
    }

    @Test
    void testGetIluminacioAllotjamentNeteja() {
        TascaManteniment t =
                new TascaManteniment(3, TascaManteniment.TipusTascaManteniment.NETEJA, allotjament, "2024-01-01", 3);

        assertEquals("100%", t.getIluminacioAllotjament());
    }

    @Test
    void testGetIluminacioAllotjamentDesinfeccio() {
        TascaManteniment t =
                new TascaManteniment(4, TascaManteniment.TipusTascaManteniment.DESINFECCIO, allotjament, "2024-01-01", 3);

        assertEquals("0%", t.getIluminacioAllotjament());
    }

    @Test
    void testGetIluminacioAllotjamentRevisioTecnica() {
        TascaManteniment t =
                new TascaManteniment(5, TascaManteniment.TipusTascaManteniment.REVISIOTECNICA, allotjament, "2024-01-01", 3);

        assertEquals("50%", t.getIluminacioAllotjament());
    }
}
