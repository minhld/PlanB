package com.minhld.planb.data.repository;

import com.minhld.planb.data.object.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{username: '?0'}")
    User findUserByName(String userName);
}
