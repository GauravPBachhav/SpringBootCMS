package in.gw.main.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.gw.main.entities.Orders;
import in.gw.main.services.OrderService;

@RestController
@RequestMapping("/api")
public class OrdersApi

{
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/storeOrderDetails")
public ResponseEntity<String>storeUserOrders(@RequestBody Orders orders)
{
	
	orderService.storeUserOrders(orders);
	
	return ResponseEntity.ok("Order Details Stored Succesfully");
	
}
}
