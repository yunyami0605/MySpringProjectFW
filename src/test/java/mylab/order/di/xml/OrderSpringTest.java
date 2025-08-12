package mylab.order.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:mylab-order-di.xml")
public class OrderSpringTest {
	@Autowired
    private ShoppingCart shoppingCart;
	
	@Autowired
	private OrderService orderService;
	
	private int expected = 1500000 + 800000;

	@Test
	public void shoppingCartTest() {
        assertEquals(2, shoppingCart.getProducts().size());
        
        
        assertEquals(expected, shoppingCart.getTotalPrice());
        assertEquals("ShoppingCart 2", shoppingCart.toString());
    }

    @Test
    public void orderServiceTest() {
        assertEquals(expected, orderService.calculateOrderTotal());
        assertEquals("ShoppingCart 2", orderService.toString());
    }
}
