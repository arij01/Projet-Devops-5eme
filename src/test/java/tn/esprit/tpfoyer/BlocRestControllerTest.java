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
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class BlocRestControllerTest {

    @Mock
    private IBlocService blocService;

    @InjectMocks
    private BlocRestController blocRestController;

    private Bloc bloc;

    @BeforeEach
    public void setUp() {
        bloc = new Bloc(); // Create a sample Bloc object
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Bloc A");
        bloc.setCapaciteBloc(100);
        bloc.setFoyer(null); // Assuming foyer is not required for the test
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
        assertEquals("Bloc A", result.get(0).getNomBloc());

        // Verify that the service method was called once
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

        // Verify that the service method was called once
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

        // Verify that the service method was called once
        verify(blocService, times(1)).addBloc(any(Bloc.class));
    }

    @Test
    public void testRemoveBloc() {
        // Do nothing when the service's remove method is called
        doNothing().when(blocService).removeBloc(1L);

        // Call the controller method
        blocRestController.removeBloc(1L);

        // Verify that the service method was called once
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

        // Verify that the service method was called once
        verify(blocService, times(1)).modifyBloc(any(Bloc.class));
    }

    @Test
    public void testGetBlocswirhoutFoyer() {
        // Given
        List<Bloc> blocsWithoutFoyer = Arrays.asList(bloc);
        when(blocService.trouverBlocsSansFoyer()).thenReturn(blocsWithoutFoyer);

        // When
        List<Bloc> result = blocRestController.getBlocswirhoutFoyer();

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Bloc A", result.get(0).getNomBloc());

        // Verify that the service method was called once
        verify(blocService, times(1)).trouverBlocsSansFoyer();
    }

    @Test
    public void testRecuperBlocsParNomEtCap() {
        // Given
        List<Bloc> filteredBlocs = Arrays.asList(bloc);
        when(blocService.trouverBlocsParNomEtCap("Bloc A", 100)).thenReturn(filteredBlocs);

        // When
        List<Bloc> result = blocRestController.recuperBlocsParNomEtCap("Bloc A", 100);

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Bloc A", result.get(0).getNomBloc());

        // Verify that the service method was called once
        verify(blocService, times(1)).trouverBlocsParNomEtCap("Bloc A", 100);
    }
}
