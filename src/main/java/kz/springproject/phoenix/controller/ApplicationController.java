package kz.springproject.phoenix.controller;

import jakarta.validation.Valid;
import kz.springproject.phoenix.dto.ApplicationDto;
import kz.springproject.phoenix.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getAllApplications() {
        List<ApplicationDto> applications = applicationService.getAllApplications();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApplicationDto> getApplicationById(@PathVariable Long id) {
        ApplicationDto applicationDto = applicationService.getApplicationById(id);
        if (applicationDto != null) {
            return new ResponseEntity<>(applicationDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ApplicationDto> createApplication(@Valid @RequestBody ApplicationDto applicationDto) {
        ApplicationDto createdApplication = applicationService.createApplication(applicationDto);
        return new ResponseEntity<>(createdApplication, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationDto> updateApplication(@PathVariable Long id, @Valid @RequestBody ApplicationDto applicationDto) {
        ApplicationDto updatedApplication = applicationService.updateApplication(id, applicationDto);
        if (updatedApplication != null) {
            return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        if (applicationService.deleteApplication(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
