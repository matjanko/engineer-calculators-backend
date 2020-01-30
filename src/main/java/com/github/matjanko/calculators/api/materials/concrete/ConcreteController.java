package com.github.matjanko.calculators.api.materials.concrete;

import com.github.matjanko.calculators.api.materials.base.exceptions.MaterialNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

/**
 * @author matjanko
 *
 */

@RestController
@RequestMapping("/api/concretes")
@RequiredArgsConstructor
public class ConcreteController {

    private final ConcreteService concreteService;

    @GetMapping
    public ResponseEntity<List<ConcreteResponse>> getAllConcretes() {
        List<ConcreteResponse> concretes = concreteService.getAll();

        concretes.forEach(c -> c.add(linkTo(methodOn(ConcreteController.class).getByClassName(c.getName()))
                .withSelfRel()));

        return new ResponseEntity<>(concretes, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = "className")
    public ResponseEntity<?> getByClassName(@NotBlank @RequestParam String className) {
        try {
            ConcreteResponse concrete = concreteService.getByName(className);
            return new ResponseEntity<>(concrete, HttpStatus.OK);
        } catch (MaterialNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/classes")
    public ResponseEntity<Set<String>> getAllClassesNames() {
        return new ResponseEntity<>(concreteService.getClassesNames(), HttpStatus.OK);
    }
}
