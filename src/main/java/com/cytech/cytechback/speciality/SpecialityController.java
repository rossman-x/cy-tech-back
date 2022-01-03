package com.cytech.cytechback.speciality;

import com.cytech.cytechback.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/specialities")
public class SpecialityController implements ISpecialityController{

    @Autowired
    private SpecialityService specialityService;

    @GetMapping(path = "list")
    @Override
    public ResponseEntity<List<SpecialityDTO>> getSpecialities() {
        return ResponseEntity.ok().body(specialityService.getSpecialities());
    }

    public void createSpecialityForStudent(int role, int speciality, int option) {
        if(role == 3){
            UserDTO dto = new UserDTO();

        }
    }
}
