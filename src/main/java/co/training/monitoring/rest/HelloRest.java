package co.training.monitoring.rest;

import io.micrometer.core.annotation.Timed;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HelloRest {

  @Timed(value = "hello-api", description = "Hello API")
  @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
  public String sayHello() {
    return "Hello!";
  }

}
