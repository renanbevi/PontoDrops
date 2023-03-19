package br.com.mandae.pontodrops.PontoDrops;


import Response.ResponseResults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.net.URISyntaxException;

@RestController
@RequestMapping("/cep")
public class CepController {

        @Value("${tokenacesso}")
        private String accessToken;


        @GetMapping("/{postalcode}")
        public ResponseResults consultarDistrito(@PathVariable("postalcode") String postalcode) throws URISyntaxException {
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<ResponseResults> resp =
                    restTemplate.getForEntity(String.format("https://pudo-api.pontodrops.com.br/businessunits/api/v1/business-units/nearby/%s"
                            , postalcode) ,ResponseResults.class);

            //HttpHeaders headers = new HttpHeaders();
            //headers.setBearerAuth(accessToken);
           // restTemplate.exchange(RequestEntity.get(new URI(url)).headers(headers).build(), returnType);

            return resp.getBody();
        }
}
