package Service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class SecurityCep {
    
    private final RestTemplate restTemplate;

    public SecurityCep(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    private static class Token{
        private final String token;


        public Token(String token) {
            this.token = token;
        }
        
        public String getToken(){
            return token;
        }
        
        
        
    }
}
