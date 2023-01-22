package com.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/version")
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
public class VersionController {

	@GetMapping
    public ResponseEntity<?> versionAPP(){
        return ResponseEntity.status(HttpStatus.OK).body("GLabCliente- VersionController - versionAPP: 1.0");
    }
}
