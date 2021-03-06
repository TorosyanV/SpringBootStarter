package com.unnormal.data.repository;

import com.unnormal.data.entity.PingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vazgen on 08/02/2016.
 */

@Repository
public interface PingRepository extends JpaRepository<PingEntity, Long> {

    PingEntity save(PingEntity user);
    List<PingEntity> findByName(String name);

}

