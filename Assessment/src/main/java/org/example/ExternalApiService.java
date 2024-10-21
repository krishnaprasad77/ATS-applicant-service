package org.example;

@Service
public class ExternalApiService {
    @Autowired
    private RestTemplate restTemplate;

    public ProductPriceResponse fetchLatestProductPrice(String productId) {
        String url = "http://mock-external-api.com/products/" + productId + "/price";
        ResponseEntity<ProductPriceResponse> response = restTemplate.getForEntity(url, ProductPriceResponse.class);
        return response.getBody();
    }
}
