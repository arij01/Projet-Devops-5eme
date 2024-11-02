package tn.esprit.tpfoyer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.control.BlocRestController;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.service.IBlocService;

import java.util.Arrays;
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
public class TestMockitou {

    @Mock
    private IBlocService blocService;

    @InjectMocks
    private BlocRestController blocRestController;

    private Bloc bloc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        bloc = new Bloc(); // Créez un objet Bloc d'exemple
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Bloc A");
        bloc.setCapaciteBloc(100);
    }

    @Test
    public void testGetBlocs() {
        // Given
        List<Bloc> blocList = Arrays.asList(bloc);
        when(blocService.retrieveAllBlocs()).thenReturn(blocList);

        // When
        List<Bloc> result = blocRestController.getBlocs();

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getIdBloc());

        // Vérifiez que la méthode du service a été appelée une fois
        verify(blocService, times(1)).retrieveAllBlocs();
    }

    @Test
    public void testRetrieveBloc() {
        // Given
        when(blocService.retrieveBloc(1L)).thenReturn(bloc);

        // When
        Bloc result = blocRestController.retrieveBloc(1L);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getIdBloc());

        // Vérifiez que la méthode du service a été appelée une fois
        verify(blocService, times(1)).retrieveBloc(1L);
    }

    @Test
    public void testAddBloc() {
        // Given
        when(blocService.addBloc(any(Bloc.class))).thenReturn(bloc);

        // When
        Bloc result = blocRestController.addBloc(bloc);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getIdBloc());

        // Vérifiez que la méthode du service a été appelée une fois
        verify(blocService, times(1)).addBloc(any(Bloc.class));
    }

    @Test
    public void testRemoveBloc() {
        // Ne rien faire lorsque la méthode remove est appelée
        doNothing().when(blocService).removeBloc(1L);

        // Appeler la méthode du contrôleur
        blocRestController.removeBloc(1L);

        // Vérifiez que la méthode du service a été appelée une fois
        verify(blocService, times(1)).removeBloc(1L);
    }

    @Test
    public void testModifyBloc() {
        // Given
        when(blocService.modifyBloc(any(Bloc.class))).thenReturn(bloc);

        // When
        Bloc result = blocRestController.modifyBloc(bloc);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getIdBloc());

        // Vérifiez que la méthode du service a été appelée une fois
        verify(blocService, times(1)).modifyBloc(any(Bloc.class));
    }
}
