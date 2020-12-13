package hsenid.assignment.controller;

import hsenid.assignment.entity.OrderDetails;
import hsenid.assignment.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService service;

    @PostMapping("/placeOrder")
    public OrderDetails placeOrder(@RequestBody OrderDetails order){

        return service.placeOrders(order);
    }

    @GetMapping("/placedOrders")
    public List<OrderDetails> showOrders(){
        return service.getPlacedOrders();
    }

    @GetMapping("/findOrder/{orderId}")
    public OrderDetails findOrderById(@PathVariable int orderId){
        return service.getOrderById(orderId);
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public String deleteOrder(@PathVariable int orderId){
        return service.deleteOrder(orderId);
    }

   @PutMapping("/updateOrder")
    public OrderDetails updateOrder(@PathVariable OrderDetails orderDetails){
        return service.updateOrder(orderDetails);
    }


}
