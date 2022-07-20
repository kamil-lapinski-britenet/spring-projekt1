package pl.britenet.campus.springprojekt1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.database.object.CartProducts;
import pl.britenet.campus.service.*;

@Configuration
public class ServiceConfig {

    private final DatabaseService databaseService;

    @Autowired
    public ServiceConfig(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @Bean
    public ProductService getProductService() {
        return new ProductService(this.databaseService);
    }

    @Bean
    public UserService getUserService() {
        return new UserService(this.databaseService);
    }

    @Bean
    public OrderService getOrderService() {
        return new OrderService(this.databaseService);
    }

    @Bean
    public CartService getCartService() {
        return new CartService(this.databaseService);
    }

    @Bean
    public OrderProductsService getOrderProductsService() {
        return new OrderProductsService(databaseService);
    }

    @Bean
    public ImagesService getImagesService() {
        return new ImagesService(databaseService);
    }

    @Bean
    public CartProductsService getCartProductService() {
        return new CartProductsService(databaseService);
    }


}