package ukr.spring.test.Project;

import org.springframework.web.client.RestTemplate;

public class Test {
    public static void main(String [] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/users";
        String response = restTemplate.getForObject(url, String.class);




    }
}
