package com.unnormal.service;

import com.sun.javafx.collections.MappingChange;
import com.unnormal.data.entity.UserEntity;
import com.unnormal.data.repository.UserRepository;
import com.unnormal.helper.DozerHelper;
import com.unnormal.service.dto.UserDto;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vazgen on 08/02/2016.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Mapper dozerBean;


    public long add(UserDto user) {
        UserEntity userEntity = dozerBean.map(user, UserEntity.class);
        UserEntity savedUser=userRepository.save(userEntity);
        return savedUser.getId();
    }

    @Override
    public UserDto getById(long id) {

        UserEntity userEntity=userRepository.getOne(id);
        UserDto userDto = dozerBean.map(userEntity, UserDto.class);
        return userDto;
    }

    @Override
    public List<UserDto> findByEmail(String email) {
        List<UserEntity> usersEntities=userRepository.findByEmail(email);


        List<UserDto> users = DozerHelper.map(dozerBean, usersEntities, UserDto.class);
        return users;
    }
}
