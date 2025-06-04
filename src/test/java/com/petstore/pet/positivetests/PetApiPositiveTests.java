package com.petstore.pet.positivetests;

import com.petstore.api.PetApiClient;
import com.petstore.model.Category;
import com.petstore.model.Pet;
import com.petstore.model.Status;
import com.petstore.model.Tag;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static com.petstore.TestUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;


class PetApiPositiveTests {

    private static PetApiClient client;

    @BeforeAll
    static void setUp() {
        client = new PetApiClient();
    }

    @Test
    void createAndGetByIdTest() {
        Pet pet = generateRandomPet();
        Response addResponse = client.addPet(pet);

        assertEquals(200, addResponse.getStatusCode());

        Response getResponse = client.getPetByID(pet.getId());

        assertEquals(200, getResponse.getStatusCode());
        assertNotNull(getResponse.body());

        if (getResponse.body() != null) {
            Pet petReceived = getResponse.getBody().as(Pet.class);
            assertEquals(pet, petReceived);
        }
    }
    @Test
    void getValidJsonSchemaTest(){
        Pet pet = generateRandomPet();
        client.addPet(pet);
        client.getPetByID(pet.getId())
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("pet_json_schema.json"));


    }

    @Test
    void createUpdateAndGetTest() {
        Pet pet = generateRandomPet();
        client.addPet(pet);

        pet.setName("Name updated");
        pet.setCategory(new Category(1L, "Category updated"));
        List<Tag> petTags = pet.getTags();
        petTags.add(new Tag(1L, "New Tag"));
        pet.setTags(petTags);

        Response response = client.getPetByID(pet.getId());

        assertEquals(200, response.getStatusCode());
        assertNotNull(response.body());

        if (response.body() != null) {
            Pet petReceived = response.getBody().as(Pet.class);
            assertEquals(pet, petReceived);
        }
    }

    @Test
    void createAndDeleteTest() {
        Pet pet = generateRandomPet();
        long id = pet.getId();
        client.addPet(pet);
        client.deletePet(id);
        Response response = client.getPetByID(id);
        assertEquals(404, response.getStatusCode());
    }

    @Test
    void createAndGetByStatus(){
        Pet pet = generateRandomPet();
        Status status = pet.getStatus();
        client.addPet(pet);
        Response response = client.getPetListByStatus(status);
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getBody());
        if(response.getBody() != null){
            List<Pet> pets = response.getBody().jsonPath().getList(".", Pet.class);
            assertTrue(pets.contains(pet));
        }
    }
}
