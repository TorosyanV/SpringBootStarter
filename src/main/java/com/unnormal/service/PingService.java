package com.unnormal.service;

import com.unnormal.service.dto.PingDto;

import java.util.List;

/**
 * Created by Vazgen on 08/02/2016.
 */
public interface PingService {
    long add(PingDto user);
    PingDto getById(long id);
    List<PingDto> findByName(String name);
}
