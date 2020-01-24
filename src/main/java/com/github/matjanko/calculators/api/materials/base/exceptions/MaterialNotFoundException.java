package com.github.matjanko.calculators.api.materials.base.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author matjanko
 *
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MaterialNotFoundException extends RuntimeException{

    public MaterialNotFoundException() {
        super();
    }

    public MaterialNotFoundException(String message) {
        super(message);
    }

}
