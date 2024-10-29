
package tn.esprit.tpfoyer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;

import static org.junit.jupiter.api.Assertions.*;

class UniversiteTest {

    private Universite universite;

    @BeforeEach
    void setUp() {
        // Initialize the Universite entity with default values for testing
        universite = new Universite();
        universite.setIdUniversite(1L);
        universite.setNomUniversite("Université de l'Esprit");
        universite.setAdresse("18, rue de l'Usine - ZI Aéroport Charguia II 2035 Ariana");
        universite.setFoyer(new Foyer());
    }

    @Test
    void testGettersAndSetters() {
        // Test getters and setters for the Universite entity fields
        assertEquals(1L, universite.getIdUniversite());
        assertEquals("Université de l'Esprit", universite.getNomUniversite());
        assertEquals("18, rue de l'Usine - ZI Aéroport Charguia II 2035 Ariana", universite.getAdresse());

        Foyer foyer = new Foyer();
        universite.setFoyer(foyer);
        assertEquals(foyer, universite.getFoyer());
    }

    @Test
    void testNoArgsConstructor() {
        Universite emptyUniversite = new Universite();
        assertNull(emptyUniversite.getNomUniversite());
        assertNull(emptyUniversite.getAdresse());
        assertNull(emptyUniversite.getFoyer());
    }

    @Test
    void testAllArgsConstructor() {
        Foyer foyer = new Foyer();
        Universite fullUniversite = new Universite(1L, "Université Centrale", "Tunis", foyer);

        assertEquals(1L, fullUniversite.getIdUniversite());
        assertEquals("Université Centrale", fullUniversite.getNomUniversite());
        assertEquals("Tunis", fullUniversite.getAdresse());
        assertEquals(foyer, fullUniversite.getFoyer());
    }

    @Test
    void testToString() {
        String expected = "Universite(idUniversite=1, nomUniversite=Université de l'Esprit, adresse=18, rue de l'Usine - ZI Aéroport Charguia II 2035 Ariana, foyer=" + universite.getFoyer() + ")";
        assertEquals(expected, universite.toString());
    }
}
