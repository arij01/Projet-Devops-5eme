package tn.esprit.tpfoyer;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestJUnit {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getBaseUrl() {
        return "http://localhost:" + port + "/bloc";
    }

    @Test
    public void testGetAllBlocs() {
        // Act: Call the /bloc/retrieve-all-blocs endpoint via HTTP GET
        ResponseEntity<List<Bloc>> response = restTemplate.exchange(
                getBaseUrl() + "/retrieve-all-blocs",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Bloc>>() {});

        // Assert: Check if the status is OK and body is not null
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());

        // Additional assertions can be added based on expected data
        List<Bloc> blocs = response.getBody();
        assertNotNull(blocs);
    }

    @Test
    public void testGetBlocById() {
        // Act: Call the /bloc/retrieve-bloc/{bloc-id} endpoint via HTTP GET
        ResponseEntity<Bloc> response = restTemplate.getForEntity(
                getBaseUrl() + "/retrieve-bloc/1", Bloc.class);

        // Assert: Check if the status is OK and the body contains the expected data
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getIdBloc());
    }

    @Test
    public void testCreateBloc() {
        // Arrange: Create a new Bloc object
        Bloc newBloc = new Bloc();
        newBloc.setNomBloc("Bloc A");
        newBloc.setCapaciteBloc(100);

        // Act: Call the /bloc/add-bloc endpoint via HTTP POST
        ResponseEntity<Bloc> response = restTemplate.postForEntity(
                getBaseUrl() + "/add-bloc", newBloc, Bloc.class);

        // Assert: Check if the status is CREATED (201) and the Bloc is returned
        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Bloc A", response.getBody().getNomBloc());
    }

    @Test
    public void testUpdateBloc() {
        // Arrange: Modify an existing Bloc
        Bloc updatedBloc = new Bloc();
        updatedBloc.setIdBloc(1L); // Assuming Bloc with ID 1 exists
        updatedBloc.setNomBloc("Bloc Updated");
        updatedBloc.setCapaciteBloc(120);

        // Act: Call the /bloc/modify-bloc endpoint via HTTP PUT
        ResponseEntity<Bloc> response = restTemplate.exchange(
                getBaseUrl() + "/modify-bloc", HttpMethod.PUT,
                new org.springframework.http.HttpEntity<>(updatedBloc),
                Bloc.class);

        // Assert: Check if the status is OK and the Bloc was updated
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Bloc Updated", response.getBody().getNomBloc());
    }

    @Test
    public void testDeleteBloc() {
        // Act: Call the /bloc/remove-bloc/{bloc-id} endpoint via HTTP DELETE
        restTemplate.delete(getBaseUrl() + "/remove-bloc/1"); // Assuming Bloc with ID 1 exists

        // Verify deletion by attempting to retrieve it (may need error handling)
        ResponseEntity<Bloc> response = restTemplate.getForEntity(
                getBaseUrl() + "/retrieve-bloc/1", Bloc.class);

        // Assert: Check if the Bloc was not found (assuming status 404 for not found)
        assertEquals(404, response.getStatusCodeValue());
    }
}
