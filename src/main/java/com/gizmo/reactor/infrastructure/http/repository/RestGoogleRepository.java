package com.gizmo.reactor.infrastructure.http.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "googleRepository", url = "https://google.com")
public interface RestGoogleRepository {
    @GetMapping(path = "/")
    String getSite();
}
