package br.com.mandae.pontodrops.PontoDrops.Client;

import Response.ResponseResults;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url= "https://pudo-api.pontodrops.com.br/businessunits/api/v1/business-units/nearby/{postalcode}" , name = "Pudos")
public interface CepClient {

    @GetMapping("{postalcode}")
    ResponseResults buscaPontoPorCep(@PathVariable("postalcode") String postalcode);
}