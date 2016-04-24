package com.innominds.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.innominds.exception.ResourceNotFoundException;
import com.tvajjala.vo.Training;

@RestController
@RequestMapping("/secure")
public class TrainingController {

    @RequestMapping(value = "/trainings", produces = { "application/json" }, method = RequestMethod.GET)
    public List<Training> getAllTrainings() {
        return Arrays.asList(new Training("Spring", "Ram"), new Training("JPA", "kathi "), new Training("Java", "Charan"));
    }

    @RequestMapping(value = "/training/{name}/{trainer}")
    public Training getTraining(@PathVariable String name, @PathVariable String trainer) {
        return new Training(name, trainer);
    }

    @RequestMapping(value = "/error", produces = { "application/json" }, method = RequestMethod.GET)
    public List<Training> exceptionTest() {
        throw new ResourceNotFoundException("Required Resource not found ");
    }

}
