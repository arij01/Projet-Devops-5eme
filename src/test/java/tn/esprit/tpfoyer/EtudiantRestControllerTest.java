package tn.esprit.tpfoyer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.control.EtudiantRestController;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.service.IEtudiantService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.ArgumentMatchers.any;


@Slf4j
@ExtendWith(MockitoExtension.class)
public class EtudiantRestControllerTest {
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
        etudiant.setDateNaissance(new Date()); // Consider using a fixed date if necessary
    }

    @Test
    public void testGetEtudiants() {

        List<Etudiant> etudiantList = Arrays.asList(etudiant);
        when(etudiantService.retrieveAllEtudiants()).thenReturn(etudiantList);


        List<Etudiant> result = etudiantRestController.getEtudiants();


        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getIdEtudiant());


        verify(etudiantService, times(1)).retrieveAllEtudiants();
    }

    @Test
    public void testRetrieveEtudiantParCin() {

        when(etudiantService.recupererEtudiantParCin(12345678L)).thenReturn(etudiant);


        Etudiant result = etudiantRestController.retrieveEtudiantParCin(12345678L);


        assertNotNull(result);
        assertEquals(12345678L, result.getCinEtudiant());


        verify(etudiantService, times(1)).recupererEtudiantParCin(12345678L);
    }

    @Test
    public void testRetrieveEtudiantById() {

        when(etudiantService.retrieveEtudiant(1L)).thenReturn(etudiant);


        Etudiant result = etudiantRestController.retrieveEtudiant(1L);


        assertNotNull(result);
        assertEquals(1L, result.getIdEtudiant());


        verify(etudiantService, times(1)).retrieveEtudiant(1L);
    }

    @Test
    public void testAddEtudiant() {

        when(etudiantService.addEtudiant(any(Etudiant.class))).thenReturn(etudiant);


        Etudiant result = etudiantRestController.addEtudiant(etudiant);


        assertNotNull(result);
        assertEquals(1L, result.getIdEtudiant());


        verify(etudiantService, times(1)).addEtudiant(any(Etudiant.class));
    }

    @Test
    public void testRemoveEtudiant() {

        doNothing().when(etudiantService).removeEtudiant(1L);


        etudiantRestController.removeEtudiant(1L);


        verify(etudiantService, times(1)).removeEtudiant(1L);
    }

    @Test
    public void testModifyEtudiant() {

        when(etudiantService.modifyEtudiant(any(Etudiant.class))).thenReturn(etudiant);


        Etudiant result = etudiantRestController.modifyEtudiant(etudiant);


        assertNotNull(result);
        assertEquals(1L, result.getIdEtudiant());


        verify(etudiantService, times(1)).modifyEtudiant(any(Etudiant.class));
    }
}
