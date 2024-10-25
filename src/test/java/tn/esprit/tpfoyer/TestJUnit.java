package tn.esprit.tpfoyer;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import tn.esprit.tpfoyer.entity.Etudiant;


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
        return "http://localhost:" + port + "/etudiants";
    }

    @Test
    public void testGetAllEtudiants() {
        // Act: Call the /etudiants endpoint via HTTP GET
        ResponseEntity<List<Etudiant>> response = restTemplate.exchange(
                getBaseUrl(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Etudiant>>() {
                });

        // Assert: Check if the status is OK and body is not null
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());

        // You can also check the number of Etudiants returned
        List<Etudiant> etudiants = response.getBody();
        assertEquals(2, etudiants.size());
    }

    @Test
    public void testGetEtudiantById() {
        // Act: Call the /etudiants/{id} endpoint via HTTP GET
        ResponseEntity<Etudiant> response = restTemplate.getForEntity(
                getBaseUrl() + "/1", Etudiant.class);

        // Assert: Check if the status is OK and the body contains the expected data
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getIdEtudiant());
        assertEquals("John", response.getBody().getNomEtudiant());
    }

    @Test
    public void testCreateEtudiant() {
        // Arrange: Create a new Etudiant object
        Etudiant newEtudiant = new Etudiant();
        newEtudiant.setNomEtudiant("Alice");
        newEtudiant.setPrenomEtudiant("Wonderland");

        // Act: Call the /etudiants endpoint via HTTP POST
        ResponseEntity<Etudiant> response = restTemplate.postForEntity(
                getBaseUrl(), newEtudiant, Etudiant.class);

        // Assert: Check if the status is CREATED (201) and the Etudiant is returned
        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Alice", response.getBody().getNomEtudiant());
    }
}
