package com.petstore.pet.positive;

import com.petstore.TestUtils;
import com.petstore.api.PetApiClient;
import com.petstore.model.Category;
import com.petstore.model.Pet;
import com.petstore.model.Tag;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;


public class PetApiPositiveTests {

    private static PetApiClient client;

    @BeforeAll
    static void setUp() {
        client = new PetApiClient();
    }

    @Test
    void createAndGetByIdTest() {
        Pet pet = TestUtils.generateRandomPet();
        client.addPet(pet);
        Response response = client.getPetByID(pet.getId());

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.body());

        if (response.body() != null) {
            Pet petReceived = response.getBody().as(Pet.class);

            Assertions.assertEquals(pet, petReceived);
        }
    }

    @Test
    void createUpdateAndGetTest() {
        Pet pet = TestUtils.generateRandomPet();
        client.addPet(pet);

        pet.setName("Name updated");
        pet.setCategory(new Category(1L, "Category updated"));
        List<Tag> petTags = pet.getTags();
        petTags.add(new Tag(1L, "New Tag"));
        pet.setTags(petTags);

        Response response = client.getPetByID(pet.getId());

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.body());

        if (response.body() != null) {
            Pet petReceived = response.getBody().as(Pet.class);

            Assertions.assertEquals(pet, petReceived);
        }
    }

    @Test
    void createAndDeleteTest() {
        Pet pet = TestUtils.generateRandomPet();
        long id = pet.getId();
        client.addPet(pet);
        client.deletePet(id);
        Response response = client.getPetByID(id);
        Assertions.assertEquals(404, response.getStatusCode());
    }
}
