package com.cloud.repository;

import com.cloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mk on 2017/12/5.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
