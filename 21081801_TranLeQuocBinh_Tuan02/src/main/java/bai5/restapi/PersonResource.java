package bai5.restapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import bai5.entity.Person;

import java.util.ArrayList;
import java.util.List;

@Path("/api/users")
public class PersonResource {
    private static List<Person> personList = new ArrayList<>();
    private static int currentId = 1;

    // Get all users
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllUsers() {
        return personList;
    }

    // Get a user by ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getUserById(@PathParam("id") String id) {
        return personList.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Add a new user
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person addUser(Person person) {
        person.setId(String.valueOf(currentId++));
        personList.add(person);
        return person;
    }

    // Update an existing user
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person updateUser(@PathParam("id") String id, Person updatedPerson) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                person.setFirstName(updatedPerson.getFirstName());
                person.setLastName(updatedPerson.getLastName());
                person.setDob(updatedPerson.getDob());
                return person;
            }
        }
        return null;
    }

    // Delete a user by ID
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteUser(@PathParam("id") String id) {
        personList.removeIf(person -> person.getId().equals(id));
        return "User removed";
    }
}
