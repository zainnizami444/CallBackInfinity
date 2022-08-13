package com.example.techwizproject;

public class AddStudyResources {

    public String ResourceId;
    public String Resource;

    public AddStudyResources() {
    }

    public AddStudyResources(String resourceId, String resource) {
        ResourceId = resourceId;
        Resource = resource;
    }

    public String getResourceId() {
        return ResourceId;
    }

    public String getResource() {
        return Resource;
    }
}
