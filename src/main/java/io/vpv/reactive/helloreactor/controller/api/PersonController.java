package io.vpv.reactive.helloreactor.controller.api;

import io.vpv.reactive.helloreactor.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @GetMapping
    public Flux<Person> findAll() {
        return Flux.just(
                new Person("John", "Doe"),
                new Person("Jane", "Doe"));
    }
}