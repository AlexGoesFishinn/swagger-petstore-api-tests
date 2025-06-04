package com.petstore.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize
public class Pet {

    @JsonProperty("id")
    private long id;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photoUrls")
    private List<String> photoUrls;
    @JsonProperty("tags")
    private List<Tag> tags;
    @JsonProperty("status")
    private Status status;

    public Pet() {
    }

    public Pet(long id, Category category, String name, List<String> photoUrls, List<Tag> tags, Status status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Pet)) {
            return false;
        }
        Pet pet = (Pet) obj;

        return this.id == pet.getId() &&
                this.category.equals(pet.getCategory()) &&
                this.name.equals(pet.getName()) &&
                this.photoUrls.equals(pet.getPhotoUrls()) &&
                this.tags.equals(pet.tags) &&
                this.status.equals(pet.status);
    }
    @Override
    public int hashCode() {
        return name.hashCode() * 31 + (int) id * 47;
    }

    @Override
    public String toString() {
        return name + " " + id + " " + status;
    }
}

