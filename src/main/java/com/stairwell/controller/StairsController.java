package com.stairwell.controller;

import com.stairwell.service.StepsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Example Request
 *
 * http://localhost:8080/stairwell/calc/steps?stairwell=17,17&stepsPerStride=3
 */
@RestController()
@RequestMapping("/stairwell")
public class StairsController {

    private StepsService stepsService;

    public StairsController(StepsService stepsService) {
        this.stepsService = stepsService;
    }

    @GetMapping(value = "/calc/steps", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> calc(@RequestParam final List<Integer> stairwell,
                                       @RequestParam final Integer stepsPerStride) {
        try {
            int steps = stepsService.calcSteps(stairwell, stepsPerStride);
            return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(steps));
        } catch (NullPointerException | IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}