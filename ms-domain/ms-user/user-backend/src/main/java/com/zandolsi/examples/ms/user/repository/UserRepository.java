package com.zandolsi.examples.ms.user.repository;

import com.zandolsi.examples.ms.user.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
