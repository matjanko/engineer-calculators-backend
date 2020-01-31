package com.github.matjanko.calculators.api.root.impl;

import com.github.matjanko.calculators.api.root.ResourcesResponse;
import com.github.matjanko.calculators.api.root.ResourcesService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.NameValueExpression;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @author matjanko
 *
 */

@Service
@RequiredArgsConstructor
public class ResourcesServiceImpl implements ResourcesService {

    private final RequestMappingHandlerMapping mapping;

    @Override
    public ResourcesResponse getResources(HttpServletRequest req) {
        Map<RequestMappingInfo, HandlerMethod> methods = mapping.getHandlerMethods();
        ResourcesResponse resources = new ResourcesResponse();

        methods.keySet().stream()
                .filter(requestMappingInfo -> requestMappingInfo.getPatternsCondition().getPatterns().stream()
                        .anyMatch(s -> s.startsWith("/api")))
                .forEach(p -> {
                    resources.add(new Link(produceLink(p, req), "resources"));
                });

        return resources;
    }

    private String produceLink(RequestMappingInfo mapping, HttpServletRequest request) {
        Optional<String> path = mapping.getPatternsCondition().getPatterns().stream().findFirst();
        Set<NameValueExpression<String>> expressions = mapping.getParamsCondition().getExpressions();

        StringBuffer requestURL = request.getRequestURL();
        StringBuilder builder = new StringBuilder(requestURL.deleteCharAt(requestURL.length() - 1));

        path.ifPresent(builder::append);

        if (expressions.size() > 0) {
            builder.append("?");
            expressions.forEach(s -> {
                builder.append(s);
                builder.append("=&");
            });
            builder.deleteCharAt(builder.length()-1);
        }

        return builder.toString();
    }
}
