package com.example.rest;

import com.example.objects.Person;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Student
 */
@Path("service")
public class ServiceResource {

    /**
     * test url
     * 
     * http://localhost:8080/maven-rest-app/webresources/service/hello
     * http://localhost:8080/maven-rest-app/webresources/service/getperson-xml
     * http://localhost:8080/maven-rest-app/webresources/service/getperson-json
     * http://localhost:8080/maven-rest-app/webresources/service/getpersons
     * http://localhost:8080/maven-rest-app/webresources/service/getperson/90
     */
    
    
    
    public ServiceResource() {
    }

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
        return "hello rest world";
    }

    @GET
    @Path("getperson-xml")
    @Produces({MediaType.APPLICATION_XML}) //default e xml, moje v content type da se iska izrichno json
    public Person getPersonXML() {
         return getMockPerson();
    }
    
    @GET
    @Path("getperson-json")
    @Produces({MediaType.APPLICATION_JSON})
    public Person getPersonJSON() {
        return getMockPerson();
    }

    /// tuk e nai-vajnata chast
    @GET
    @Path("getpersons")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getPersons() {
        return getResponse(getMockPersons());
    }
    
    @GET
    @Path("getperson/{age}")
    @Produces({MediaType.APPLICATION_JSON})
    public Person getPersonByAge(@PathParam(value = "age") int age) {
        return new Person(age, "John", "Doe");
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    private Person getMockPerson(){
        return new Person(35, "John", "Doe");
    }
    
    private List<Person> getMockPersons(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(35, "John", "Doe"));
        persons.add(new Person(35, "John", "Doe"));
        persons.add(new Person(35, "John", "Doe"));
        return persons;
    }
    
    private Response getResponse(Object o){
        return Response.status(Response.Status.OK)
                .entity(o)
                .build();
    }
}
