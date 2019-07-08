package com.wildcodeschool.myProjectWithDB.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wildcodeschool.myProjectWithDB.entities.Wizard;
import com.wildcodeschool.myProjectWithDB.repositories.WizardRepository;

import java.sql.Date;
import java.util.List;
import org.springframework.http.HttpStatus;

@Controller
@ResponseBody
public class WizardController {
    @GetMapping("/api/wizards")
      public List<Wizard> getWizards(@RequestParam(defaultValue = "%") String family) {
        return WizardRepository.selectByLastname(family);
    }
    @PostMapping("/api/wizards")
    @ResponseStatus(HttpStatus.CREATED)
    public Wizard store(
         @RequestParam String firstname,
         @RequestParam String lastname,
         @RequestParam Date birthday,
         @RequestParam(required = false, name = "birth_place") String birthPlace,
         @RequestParam(required = false) String biography,
         @RequestParam(name = "is_muggle") Boolean isMuggle
) {
    int idGeneratedByInsertion = WizardRepository.insert(
        firstname,
        lastname,
        birthday,
        birthPlace,
        biography,
        isMuggle
    );
    return WizardRepository.selectById(idGeneratedByInsertion);
}


}


