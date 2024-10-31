package com.eventmanagement.event_management_app.users;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findByUserEmail(String email);// custom query method provided by Spring Data MongoDB. It allows you to query your MongoDB database by using a specific field (in this case, the userEmail field)
    //The method findByUserEmail is derived from the naming pattern findBy<FieldName>, where FieldName refers to the name of the field in your User class
    Optional<User> findById(String id);
}

