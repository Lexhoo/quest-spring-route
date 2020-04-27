package com.wildcodeschool.doctor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Person doctor(@PathVariable int number) {
        Person response;
        if (number < 0 || number > 13) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + number);
        }
        else if(number == 13){
            response = new Person("Jodie Whittaker", 13);
        }
        else{
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Status 303");
        }
        return response;
    }

}
