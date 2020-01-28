package com.github.matjanko.calculators.api.exposure;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author matjanko
 *
 */

@RestController
@RequestMapping("/api/exposures")
@RequiredArgsConstructor
public class ExposureClassController {

    private final ExposureClassService exposureClassService;

    @GetMapping
    public ResponseEntity<List<String>> getExposureClasses() {
        return new ResponseEntity<>(exposureClassService.getAllExposureClasses(), HttpStatus.OK);
    }
}
