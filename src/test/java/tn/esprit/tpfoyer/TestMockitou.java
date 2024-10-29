package tn.esprit.tpfoyer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.control.EtudiantRestController;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.service.IEtudiantService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class TestMockitou {

    @Mock
    private IEtudiantService etudiantService;

    @InjectMocks
    private EtudiantRestController etudiantRestController;

    private Etudiant etudiant;

    @BeforeEach
    public void setUp() {
        etudiant = new Etudiant(); // Create a sample Etudiant object
        etudiant.setIdEtudiant(1L);
        etudiant.setNomEtudiant("John");
        etudiant.setPrenomEtudiant("Doe");
        etudiant.setCinEtudiant(12345678L);
        etudiant.setDateNaissance(new Date()); // Use the current date for simplicity
    }

    @Test
    public void testGetEtudiants() {
        // Given
        List<Etudiant> etudiantList = Arrays.asList(etudiant);
        when(etudiantService.retrieveAllEtudiants()).thenReturn(etudiantList);

        // When
        List<Etudiant> result = etudiantRestController.getEtudiants();

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getIdEtudiant());

        // Verify that the service method was called once
        verify(etudiantService, times(1)).retrieveAllEtudiants();
    }

    @Test
    public void testRetrieveEtudiantParCin() {
        // Given
        when(etudiantService.recupererEtudiantParCin(12345678L)).thenReturn(etudiant);

        // When
        Etudiant result = etudiantRestController.retrieveEtudiantParCin(12345678L);

        // Then
        assertNotNull(result);
        assertEquals(12345678L, result.getCinEtudiant());

        // Verify that the service method was called once
        verify(etudiantService, times(1)).recupererEtudiantParCin(12345678L);
    }

    @Test
    public void testRetrieveEtudiantById() {
        // Given
        when(etudiantService.retrieveEtudiant(1L)).thenReturn(etudiant);

        // When
        Etudiant result = etudiantRestController.retrieveEtudiant(1L);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getIdEtudiant());

        // Verify that the service method was called once
        verify(etudiantService, times(1)).retrieveEtudiant(1L);
    }

    @Test
    public void testAddEtudiant() {
        // Given
        when(etudiantService.addEtudiant(any(Etudiant.class))).thenReturn(etudiant);

        // When
        Etudiant result = etudiantRestController.addEtudiant(etudiant);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getIdEtudiant());

        // Verify that the service method was called once
        verify(etudiantService, times(1)).addEtudiant(any(Etudiant.class));
    }

    @Test
    public void testRemoveEtudiant() {
        // Do nothing when the service's remove method is called
        doNothing().when(etudiantService).removeEtudiant(1L);

        // Call the controller method
        etudiantRestController.removeEtudiant(1L);

        // Verify that the service method was called once
        verify(etudiantService, times(1)).removeEtudiant(1L);
    }

    @Test
    public void testModifyEtudiant() {
        // Given
        when(etudiantService.modifyEtudiant(any(Etudiant.class))).thenReturn(etudiant);

        // When
        Etudiant result = etudiantRestController.modifyEtudiant(etudiant);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getIdEtudiant());

        // Verify that the service method was called once
        verify(etudiantService, times(1)).modifyEtudiant(any(Etudiant.class));
    }
}
