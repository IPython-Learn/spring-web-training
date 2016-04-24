package com.innominds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tvajjala.vo.Training;

@RestController
@RequestMapping("/cors")
public class CorsTestController {

    @RequestMapping(value = "/training", method = RequestMethod.GET)
    public Training getUser() {
        final Training user = new Training();
        user.setId(1l);
        user.setTrainerName("David");
        user.setTrainingTitle("Spring and JPA training");
        return user;
    }

}
