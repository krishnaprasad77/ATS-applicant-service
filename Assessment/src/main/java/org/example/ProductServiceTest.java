package org.example;

@ExtendWith(MockitoExtension.class)
public class    ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void testGetAllProducts() {
        List<Product> products = Arrays.asList(new Product("Product1", "Desc1", 100.0));
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.getAllProducts();

        assertEquals(1, result.size());
    }
}
