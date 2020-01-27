package com.github.matjanko.calculators.api.cover;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author matjanko
 *
 */

@RestController
@RequestMapping("/api/cover")
@RequiredArgsConstructor
public class CoverController {

    private final CoverService coverService;

    @GetMapping
    public ResponseEntity<CoverResponse> getCoverCalculation(@Valid CoverRequest coverRequest) {
        return new ResponseEntity<>(coverService.getCalculation(coverRequest), HttpStatus.OK);
    }
}
