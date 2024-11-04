package tn.esprit.tpfoyer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;

import static org.junit.jupiter.api.Assertions.*;

class BlocTest {

    private Bloc bloc;

    @BeforeEach
    void setUp() {
        // Initialize the Bloc entity with default values for testing
        bloc = new Bloc(); // Using the no-arg constructor
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Bloc A");
        bloc.setCapaciteBloc(100); // Set the capacity
        bloc.setFoyer(new Foyer()); // Initialize the Foyer association
    }

    @Test
    void testGettersAndSetters() {
        // Test getters and setters for the Bloc entity fields
        assertEquals(1L, bloc.getIdBloc());
        assertEquals("Bloc A", bloc.getNomBloc());
        assertEquals(100, bloc.getCapaciteBloc());

        Foyer foyer = new Foyer(); // Create a new Foyer instance
        bloc.setFoyer(foyer);
        assertEquals(foyer, bloc.getFoyer());
    }

    @Test
    void testNoArgsConstructor() {
        Bloc emptyBloc = new Bloc(); // Use the no-arg constructor
        assertNull(emptyBloc.getNomBloc()); // Check default name is null
        assertEquals(0, emptyBloc.getCapaciteBloc()); // Assuming default capacity is 0
        assertNull(emptyBloc.getFoyer()); // Ensure foyer is null for a new instance
    }

    @Test
    void testAllArgsConstructor() {
        // This test is not applicable because we are not adding an all-args constructor in the entity
        // Instead, we will just validate individual field settings
        Foyer foyer = new Foyer(); // Create a Foyer instance
        bloc = new Bloc(); // Use no-arg constructor
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Bloc B");
        bloc.setCapaciteBloc(150);
        bloc.setFoyer(foyer);

        assertEquals(1L, bloc.getIdBloc());
        assertEquals("Bloc B", bloc.getNomBloc());
        assertEquals(150, bloc.getCapaciteBloc());
        assertEquals(foyer, bloc.getFoyer());
    }

    @Test
    void testToString() {
        String expected = "Bloc(idBloc=1, nomBloc=Bloc A, capaciteBloc=100, foyer=" + bloc.getFoyer() + ")";
        assertEquals(expected, bloc.toString());
    }
}
