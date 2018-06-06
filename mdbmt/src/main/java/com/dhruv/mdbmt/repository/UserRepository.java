package com.dhruv.mdbmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dhruv.mdbmt.documents.UserDetails;

public interface UserRepository extends MongoRepository<UserDetails, String> {

}
