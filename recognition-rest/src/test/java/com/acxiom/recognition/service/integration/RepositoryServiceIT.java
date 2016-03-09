package com.acxiom.recognition.service.integration;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.acxiom.recognition.resource.Repository;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Assert;
import org.junit.Test;

public class RepositoryServiceIT {

    @Test
    public void testGetRepository() throws JsonGenerationException,
            JsonMappingException, IOException {

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(JacksonFeature.class);

        Client client = ClientBuilder.newClient(clientConfig);

        WebTarget webTarget = client
                .target("http://localhost:8080/recognition-rest/repositories/1");

        Builder request = webTarget.request(MediaType.APPLICATION_JSON);

        Response response = request.get();
        Assert.assertTrue(response.getStatus() == 200);

        Repository repository = response.readEntity(Repository.class);

        ObjectMapper mapper = new ObjectMapper();
        System.out
                .print("Received repository from database *************************** "
                        + mapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(repository));

    }


}
