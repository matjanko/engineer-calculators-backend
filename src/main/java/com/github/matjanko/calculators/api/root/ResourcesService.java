package com.github.matjanko.calculators.api.root;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author matjanko
 *
 */

@Service
public interface ResourcesService {

    ResourcesResponse getResources(HttpServletRequest req);

}
