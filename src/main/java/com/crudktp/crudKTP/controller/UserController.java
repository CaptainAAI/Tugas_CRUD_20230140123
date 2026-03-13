package com.crudktp.crudKTP.controller;

import com.crudktp.crudKTP.model.dto.UserAddRequest;
import com.crudktp.crudKTP.model.dto.UserDto;
import com.crudktp.crudKTP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(
            path = "/api/dataWarga",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> addDataWarga(@RequestBody UserAddRequest request) {
        UserDto result = userService.AddDataWarga(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "status", "success",
                "data", result
        ));
    }

    @GetMapping(
            path = "/api/dataWarga",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> getAllDataWarga() {
        List<UserDto> result = userService.getAllDataWarga();

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", "success",
                "data", result
        ));
    }

    @GetMapping(
            path = "/api/dataWarga/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> getDataWargaById(@PathVariable("id") int id) {
        UserDto result = userService.getDataWargaById(id);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", "success",
                "data", result
        ));
    }

    @PutMapping(
            path = "/api/dataWarga/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> updateDataWarga(
            @PathVariable("id") int id,
            @RequestBody UserAddRequest request
    ) {
        UserDto result = userService.updateDataWarga(id, request);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", "success",
                "data", result
        ));
    }

    @DeleteMapping(
            path = "/api/dataWarga/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> deleteDataWarga(@PathVariable("id") int id) {
        userService.deleteDataWarga(id);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "status", "success delete dataWarga with id " + id
        ));
    }
}