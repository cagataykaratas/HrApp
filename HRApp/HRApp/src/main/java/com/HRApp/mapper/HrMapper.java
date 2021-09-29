package com.HRApp.mapper;

import com.HRApp.lib.dto.HrDto;
import com.HRApp.entity.Hr;

public class HrMapper {
    public HrDto toDto(Hr hr){
        HrDto hrDto = new HrDto();
        hrDto.setEmail(hr.getEmail());
        hrDto.setPassword(hr.getPassword());
        return hrDto;
    }

    public Hr toEntity(HrDto hrDto){
        Hr hr = new Hr();
        hr.setEmail(hrDto.getEmail());
        hr.setPassword(hrDto.getPassword());
        return hr;
    }
}
