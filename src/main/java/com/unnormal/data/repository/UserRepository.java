package com.unnormal.data.repository;

import com.unnormal.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vazgen on 08/02/2016.
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity save(UserEntity user);

}
