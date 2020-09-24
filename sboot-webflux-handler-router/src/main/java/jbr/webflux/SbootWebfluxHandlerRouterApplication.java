package jbr.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SbootWebfluxHandlerRouterApplication {

  public static void main(String[] args) {
    SpringApplication.run(SbootWebfluxHandlerRouterApplication.class, args);

    ProductWebClient productWebClient = new ProductWebClient();
    log.info(productWebClient.hello());

    productWebClient.getAllProducts()
        .subscribe((response) ->
          {
            log.info("response: " + response.toString());
          });
  }

}
