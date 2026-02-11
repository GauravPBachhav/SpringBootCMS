package in.gw.main.api;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import in.gw.main.entities.Orders;
import in.gw.main.services.OrderService;

@RestController
@RequestMapping("/api")
public class OrdersApi

{
	@Autowired
	private OrderService orderService;

//	@PostMapping("/storeOrderDetails")
//	public ResponseEntity<String> storeUserOrders(@RequestBody Orders orders) {
//
//		orderService.storeUserOrders(orders);
//
//		return ResponseEntity.ok("Order Details Stored Succesfully");
//
//	}
//	
	
	
	@PostMapping("/storeOrderDetails")
	public ResponseEntity<String> storeUserOrders(@RequestBody Orders orders) throws RazorpayException {          // this is for if you want to generate order Id
		

		
		RazorpayClient razorpayClient = new RazorpayClient("rzp_test_SEWEpdgePUCpmR", "cGJiw0GlT041FaA1xW6vUGvw");

		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount",orders.getCourseAmount());
		orderRequest.put("currency","INR");
		orderRequest.put("receipt", "rcpt_id"+System.currentTimeMillis());
	

		Order order = razorpayClient.orders.create(orderRequest);
		
		
		
		String orderId = order.get("id").toString();
		orders.setOrderId(orderId);
		
		
		
		orderService.storeUserOrders(orders);

		return ResponseEntity.ok("Order Details Stored Succesfully");

	}
	
	
	
}
