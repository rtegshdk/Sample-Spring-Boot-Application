package com.example.webapp.service;

import com.example.webapp.model.DataModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CountryService {
    @Autowired
    private WebClient webClient;
    private static final Logger log = LogManager.getLogger(CountryService.class);
    private static final String GET_CITIES_URL = "/api/v0.1/countries/population/cities";

    public DataModel getCities() {
        log.info("Calling the getCountries API");
        return webClient.get()
                .uri(GET_CITIES_URL)
                .retrieve()
                .bodyToMono(DataModel.class)
                .block();
    }
}
