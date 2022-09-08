package com.upaio.services.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.upaio.services.model.ServiceResponseCountryDTO;
import com.upaio.services.model.common.CountryDTO;

import lombok.extern.slf4j.Slf4j;
@Service("GetCountryCommand")
@Slf4j
public class GetCountryCommandImpl implements GetCountryCommand {

    @Override
    public ServiceResponseCountryDTO getCountry() {

        log.info("Ejecutando comando: GetCountryCommand en el metodo: getCountry");
        
        ServiceResponseCountryDTO response = new ServiceResponseCountryDTO();

        List<CountryDTO> countryListResponse = new ArrayList<>();

        CountryDTO countryDTOPan = new CountryDTO();
        countryDTOPan.setId("1");
        countryDTOPan.setName("Pan");

        CountryDTO countryDTOMex = new CountryDTO();
        countryDTOMex.setId("2");
        countryDTOMex.setName("Mex");

        CountryDTO countryDTOCol = new CountryDTO();
        countryDTOCol.setId("3");
        countryDTOCol.setName("Col");
        
        countryListResponse.add(countryDTOPan);
        countryListResponse.add(countryDTOMex);
        countryListResponse.add(countryDTOCol);

        response.setCountry(countryListResponse);
        return response;
    }
    
}
