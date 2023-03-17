package br.com.mandae.pontodrops.PontoDrops;


import Response.ResponseResults;
import br.com.mandae.pontodrops.PontoDrops.Client.CepClient;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@RequestMapping
public class CepController {

    @Autowired
    private CepClient cepClient;

    @GetMapping("/drops")
    public ResponseEntity<ResponseResults> getCep(@PathVariable String postalcode) {

        ResponseResults responseResults = cepClient.buscaPontoPorCep(postalcode);

        return responseResults != null ? ResponseEntity.ok().body(responseResults) : ResponseEntity.notFound().build();
    }


}
