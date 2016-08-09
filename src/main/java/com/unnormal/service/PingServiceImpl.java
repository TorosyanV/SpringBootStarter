package com.unnormal.service;

import com.unnormal.data.entity.PingEntity;
import com.unnormal.data.repository.PingRepository;
import com.unnormal.helper.DozerExtension;
import com.unnormal.service.dto.PingDto;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vazgen on 08/02/2016.
 */
@Service
@Transactional
public class PingServiceImpl implements PingService {

    @Autowired
    private PingRepository pingRepository;
    @Autowired
    private Mapper dozerBean;


    public long add(PingDto user) {
        PingEntity pingEntity = dozerBean.map(user, PingEntity.class);
        PingEntity savedPing= pingRepository.save(pingEntity);
        return savedPing.getId();
    }

    @Override
    public PingDto getById(long id) {

        PingEntity pingEntity= pingRepository.getOne(id);
        PingDto pingDto = dozerBean.map(pingEntity, PingDto.class);
        return pingDto;
    }

    @Override
    public List<PingDto> findByName(String name) {
        List<PingEntity> pingEntities= pingRepository.findByName(name);


        List<PingDto> users = DozerExtension.map(dozerBean, pingEntities, PingDto.class);
        return users;
    }
}
