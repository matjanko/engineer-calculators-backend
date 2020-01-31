package com.github.matjanko.calculators.api.root;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

/**
 * @author matjanko
 *
 */

@Getter
public class ResourcesResponse extends RepresentationModel<ResourcesResponse> {

    private String serverName = "ENGINEER CALCULATORS API";

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime currentDateTime = LocalDateTime.now();
}
