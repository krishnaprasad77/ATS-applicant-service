package org.example;

@EnableCaching
@Configuration
public class CacheConfig extends CachingConfigurerSupport{

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("productPrices");
    }
}

@Service
public class ExternalApiService {

    @Cacheable(value = "productPrices", key = "#productId")
    public ProductPriceResponse fetchLatestProductPrice(String productId) {
    }
}
