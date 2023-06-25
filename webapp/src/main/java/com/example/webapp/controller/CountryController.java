package com.example.webapp.controller;

import com.example.webapp.model.DataModel;
import com.example.webapp.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/getCities", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCities() {
        try {
            log.info("Getting the list of all cities: CountryController");
            DataModel cities = countryService.getCities();
            return new ResponseEntity<>(cities, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Stack Trace {}", e.getMessage());
            return new ResponseEntity<>("Error fetching city details from Countries API",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
