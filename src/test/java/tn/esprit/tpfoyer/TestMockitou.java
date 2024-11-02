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
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bloc = new Bloc();
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Bloc A");
        bloc.setCapaciteBloc(100);
    }

    @Test
    void shouldReturnListOfBlocsWhenGetBlocsCalled() {
        // Arrange: Prepare mock data and expectations
        List<Bloc> blocList = Arrays.asList(bloc);
        when(blocService.retrieveAllBlocs()).thenReturn(blocList);

        // Act: Call the method to test
        List<Bloc> result = blocRestController.getBlocs();

        // Assert: Verify the outcome
        assertNotNull(result, "The result should not be null");
        assertEquals(1, result.size(), "The result size should match the mock data");
        assertEquals(1L, result.get(0).getIdBloc(), "The ID of the bloc should match");

        // Verify the service method is called once
        verify(blocService, times(1)).retrieveAllBlocs();
    }

    @Test
    void shouldReturnBlocWhenRetrieveBlocCalledWithValidId() {
        // Arrange: Prepare mock data and expectations
        when(blocService.retrieveBloc(1L)).thenReturn(bloc);

        // Act: Call the method to test
        Bloc result = blocRestController.retrieveBloc(1L);

        // Assert: Verify the outcome
        assertNotNull(result, "The result should not be null");
        assertEquals(1L, result.getIdBloc(), "The ID of the bloc should match");

        // Verify the service method is called once
        verify(blocService, times(1)).retrieveBloc(1L);
    }

    @Test
    void shouldAddBlocSuccessfullyWhenAddBlocCalled() {
        // Arrange: Prepare mock data and expectations
        when(blocService.addBloc(any(Bloc.class))).thenReturn(bloc);

        // Act: Call the method to test
        Bloc result = blocRestController.addBloc(bloc);

        // Assert: Verify the outcome
        assertNotNull(result, "The result should not be null");
        assertEquals(1L, result.getIdBloc(), "The ID of the added bloc should match");

        // Verify the service method is called once
        verify(blocService, times(1)).addBloc(any(Bloc.class));
    }

    @Test
    void shouldRemoveBlocWhenRemoveBlocCalledWithValidId() {
        // Arrange: Do nothing when the service remove method is called
        doNothing().when(blocService).removeBloc(1L);

        // Act: Call the method to test
        blocRestController.removeBloc(1L);

        // Verify the service method is called once
        verify(blocService, times(1)).removeBloc(1L);
    }

    @Test
    void shouldModifyBlocSuccessfullyWhenModifyBlocCalled() {
        // Arrange: Prepare mock data and expectations
        when(blocService.modifyBloc(any(Bloc.class))).thenReturn(bloc);

        // Act: Call the method to test
        Bloc result = blocRestController.modifyBloc(bloc);

        // Assert: Verify the outcome
        assertNotNull(result, "The result should not be null");
        assertEquals(1L, result.getIdBloc(), "The ID of the modified bloc should match");

        // Verify the service method is called once
        verify(blocService, times(1)).modifyBloc(any(Bloc.class));
    }
}
