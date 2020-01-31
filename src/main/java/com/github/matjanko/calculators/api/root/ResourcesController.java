package com.github.matjanko.calculators.api.root;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @author matjanko
 *
 */

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ResourcesController {

    private final ResourcesService resourcesService;

    @GetMapping
    public ResponseEntity<?> getAllResources(HttpServletRequest req) {
        return new ResponseEntity<>(resourcesService.getResources(req), HttpStatus.OK);
    }

}
