package com.petstore;

import com.petstore.model.Category;
import com.petstore.model.Pet;
import com.petstore.model.Status;
import com.petstore.model.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestUtils {
    private final static Random random = new Random();
    public static Pet generateRandomPet(){
        long petId = random.nextLong(0, Long.MAX_VALUE);
        long categoryId = random.nextLong(0, Long.MAX_VALUE);
        long tagId = random.nextLong(0, Long.MAX_VALUE);
        String petName = "Pet " + petId;
        String categoryName = "Category " + categoryId;
        String tagName = "Tag" + tagId;
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_16x9.jpg?w=1200");
        Category category = new Category(categoryId, categoryName);
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag(tagId, tagName));
        Status status = generateRandomStatus();
        return new Pet(petId, category,petName,photoUrls, tags, status);


    }

    private static Status generateRandomStatus(){
        Status[] statuses = Status.values();
        return statuses[random.nextInt(statuses.length)];
    }
}
