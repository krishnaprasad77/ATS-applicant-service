package org.example;

@Service
public class ProductPriceUpdater {

    @Autowired
    private ExternalApiService externalApiService;

    @Autowired
    private ProductRepository productRepository;

    @Scheduled(cron = "0 0 0 * * ?")
    public void updateProductPrices() {
        List<Product> products = productRepository.findAll();
        products.forEach(product -> {
            ProductPriceResponse response = externalApiService.fetchLatestProductPrice(product.getId());
            product.setPrice(response.getPrice());
            productRepository.save(product);
        });
    }
}
