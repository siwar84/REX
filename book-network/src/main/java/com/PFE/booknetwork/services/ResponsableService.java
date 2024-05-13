package com.PFE.booknetwork.services;


import com.PFE.booknetwork.dto.ResponsableDto;

import java.util.List;

public interface ResponsableService {
    ResponsableDto save(ResponsableDto dto);

    ResponsableDto findById(Integer id);

    List<ResponsableDto> findAll();

    void delete(Integer id);
}
