package com.packt.chapter3.indianstates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StateController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StateController.class);
    private final StateService stateService;


    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/states")
    private List<State> getAllStates() {
        LOGGER.info("Getting all Indian states and their capitals.");
        return stateService.findAll();
    }

    @GetMapping(value = "/state")
    private String getSpecificState(@RequestParam(required = false, name = "name", defaultValue = "Maharashtra") String name) {
        return stateService.findByName(name);
    }
}
