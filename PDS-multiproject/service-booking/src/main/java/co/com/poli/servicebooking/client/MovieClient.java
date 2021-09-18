package co.com.poli.servicebooking.client;

import co.com.poli.commonslibrary.libraries.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

@FeignClient(name = "service-movie")
public interface MovieClient {

    @GetMapping("/users/{id}")
    Response findById(@Valid @PathVariable("id") Long id);
}
