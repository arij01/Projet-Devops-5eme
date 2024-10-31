package tn.esprit.tpfoyer.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;
import tn.esprit.tpfoyer.repository.ChambreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ChambreServiceImplTest {

    @Mock
    private ChambreRepository chambreRepository;

    @InjectMocks
    private ChambreServiceImpl chambreService;

    @Test
    void testRetrieveAllChambres() {
        List<Chambre> mockChambres = new ArrayList<>();
        mockChambres.add(new Chambre(1, 101, TypeChambre.SIMPLE, null, null));

        Mockito.when(chambreRepository.findAll()).thenReturn(mockChambres);

        List<Chambre> chambres = chambreService.retrieveAllChambres();
        Assertions.assertEquals(1, chambres.size());
        Assertions.assertEquals(101, chambres.get(0).getNumeroChambre());
    }

    @Test
    void testRetrieveChambre() {
        Chambre mockChambre = new Chambre(1, 102, TypeChambre.DOUBLE, null, null);

        Mockito.when(chambreRepository.findById(1L)).thenReturn(Optional.of(mockChambre));

        Chambre chambre = chambreService.retrieveChambre(1L);
        Assertions.assertNotNull(chambre);
        Assertions.assertEquals(102, chambre.getNumeroChambre());
    }

    @Test
    void testAddChambre() {
        Chambre newChambre = new Chambre(1, 103, TypeChambre.TRIPLE, null, null);

        Mockito.when(chambreRepository.save(newChambre)).thenReturn(newChambre);

        Chambre addedChambre = chambreService.addChambre(newChambre);
        Assertions.assertNotNull(addedChambre);
        Assertions.assertEquals(103, addedChambre.getNumeroChambre());
    }

    @Test
    void testModifyChambre() {
        Chambre existingChambre = new Chambre(1, 104, TypeChambre.DOUBLE, null, null);

        Mockito.when(chambreRepository.save(existingChambre)).thenReturn(existingChambre);

        Chambre modifiedChambre = chambreService.modifyChambre(existingChambre);
        Assertions.assertNotNull(modifiedChambre);
        Assertions.assertEquals(104, modifiedChambre.getNumeroChambre());
    }

    @Test
    void testRemoveChambre() {
        chambreService.removeChambre(1L);

        Mockito.verify(chambreRepository).deleteById(1L);
    }
}


