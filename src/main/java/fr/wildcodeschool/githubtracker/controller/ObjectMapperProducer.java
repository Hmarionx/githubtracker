package fr.wildcodeschool.githubtracker.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@ApplicationScoped
public class ObjectMapperProducer {

    @Produces
    public ObjectMapper produceObjectMapper() {
        ObjectMapper om = new ObjectMapper()

                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return om;
    }
}
