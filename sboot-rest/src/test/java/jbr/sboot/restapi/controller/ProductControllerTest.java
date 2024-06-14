package jbr.sboot.restapi.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import jbr.sboot.restapi.product.service.ProductService;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest(ProductControllerTest.class)
@TestInstance(Lifecycle.PER_CLASS)
class ProductControllerTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    final void testAddProduct() throws Exception {
        
    }
    
}
