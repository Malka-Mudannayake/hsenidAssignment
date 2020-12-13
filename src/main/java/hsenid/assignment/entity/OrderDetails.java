package hsenid.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetails {

    @Id
    @Column(name="detail_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order_id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product_id;

    private double sub_total;


}
