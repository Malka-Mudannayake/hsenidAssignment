package hsenid.assignment.service;

import hsenid.assignment.entity.OrderDetails;
import hsenid.assignment.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository repository;

    public OrderDetails placeOrders(OrderDetails order){
        return repository.save(order);
    }

    public List<OrderDetails> getPlacedOrders(){
        return repository.findAll();
    }

    public OrderDetails getOrderById(int orderId){
        return repository.findById(orderId).orElse(null);
    }

    public String deleteOrder(int orderId){
        repository.deleteById(orderId);
        return "Order removed" +orderId;
    }

    public OrderDetails updateOrder(OrderDetails orderDetails){
        OrderDetails existingOrder = repository.findById(orderDetails.getId()).orElse(null);
        existingOrder.setQuantity(orderDetails.getQuantity());
        return repository.save(existingOrder);
    }

}
