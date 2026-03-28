package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AllotjamentTest {

    private Allotjament allotjament;

    @BeforeEach
    void setUp() {
        // Creem una instància anònima d'Allotjament per a tests

        allotjament = new Parcela("Allotjament Test", "ID001", true, "100%", 64.0f, true);
    }

    @Test
    void comprovarConstructor() {
        assertEquals("Allotjament Test", allotjament.getNom());
        assertEquals("ID001", allotjament.getId());
        assertEquals(4, allotjament.getEstadaMinima(InAllotjament.Temp.ALTA));
        assertEquals(2, allotjament.getEstadaMinima(InAllotjament.Temp.BAIXA));
        assertTrue(allotjament.isOperatiu());
        assertEquals("100%", allotjament.getIluminacio());
    }

    @Test
    void testCanviOperatiu() {
        allotjament.setOperatiu(false);
        assertEquals(false, allotjament.isOperatiu());

        allotjament.setOperatiu(true);
        assertEquals(true, allotjament.isOperatiu());
    }

    @Test
    void testObrirAllotjament() {
        allotjament.setOperatiu(false);
        allotjament.obrirAllotjament();

        assertTrue(allotjament.isOperatiu());
        assertEquals("100%", allotjament.getIluminacio());
    }

    @Test
    void testTancarAllotjamentReparacio() {
        TascaManteniment t =
                new TascaManteniment(1, TascaManteniment.TipusTascaManteniment.REPARACIO, allotjament, "01/01/2025", 2);

        allotjament.tancarAllotjament(t);

        assertEquals(false, allotjament.isOperatiu());
        assertEquals("50%", allotjament.getIluminacio());
    }

    @Test
    void testTancarAllotjamentNeteja() {
        TascaManteniment t =
                new TascaManteniment(2, TascaManteniment.TipusTascaManteniment.NETEJA, allotjament, "01/01/2025", 2);

        allotjament.tancarAllotjament(t);

        assertEquals("100%", allotjament.getIluminacio());
    }

    @Test
    void testTancarAllotjamentDesinfeccio() {
        TascaManteniment t =
                new TascaManteniment(3, TascaManteniment.TipusTascaManteniment.DESINFECCIO, allotjament, "01/01/2025", 2);

        allotjament.tancarAllotjament(t);

        assertEquals("0%", allotjament.getIluminacio());
    }
}



