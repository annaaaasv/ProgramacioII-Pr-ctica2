package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccesTest {

    private Acces acces1;
    private Acces acces2;

    @BeforeEach
    void setUp() {
        // Dos accessos inicials i un allotjament
        acces1 = new Acces("Acces 1", true){
            @Override
            public boolean isAccessibilitat() {
                return true;
            }
        };
        acces2 = new Acces("Acces 2", false){
            @Override
            public boolean isAccessibilitat() {
                return false;
            }
        };
    }

    @Test
    void comprovarConstructor(){
        assertEquals(acces1.getNom(), "Acces 1");
        assertEquals(acces2.getNom(), "Acces 2");
        assertTrue(acces1.isAccessibilitat());
        assertFalse(acces2.isAccessibilitat());
        assertTrue(acces1.getEstat());
        assertFalse(acces2.getEstat());
        assertTrue(acces1.getAllotjaments() instanceof LlistaAllotjaments);
    }

    @Test
    void testTancarAcces() {
        acces1.tancarAcces();
        assertFalse(acces1.getEstat());
    }

    @Test
    void testObrirAcces() {
        acces2.obrirAcces();
        assertTrue(acces2.getEstat());
    }

    @Test
    void testAfegirAllotjaments() {
        Allotjament allotjament = new Parcela("Allotjament Test", "ID001", true, "100%", 64.0f, true);

        acces1.afegirAllotjament(allotjament);

        assertEquals(1, acces1.getAllotjaments().getNumElements());
    }

    @Test
    void testAfegirDiversosAllotjaments() {
        Allotjament a1 = new Parcela("A1", "ID1", true, "100%", 64.0f, true);
        Allotjament a2 = new Parcela("A2", "ID2", true, "100%", 64.0f, true);

        acces1.afegirAllotjament(a1);
        acces1.afegirAllotjament(a2);

        assertEquals(2, acces1.getAllotjaments().getNumElements());
    }

    @Test
    void testGetAllotjamentsNoNull() {
        assertNotNull(acces1.getAllotjaments());
    }
}
