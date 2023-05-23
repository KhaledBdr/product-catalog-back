package com.fawry.productcatalog.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Shipment {
    @SequenceGenerator(name = "shipment_id_seq", sequenceName = "shipment_id_seq" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "shipment_id_seq")
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private ShipmentState state = ShipmentState.RECEIVED;
    private Boolean userAcknowledge = false;

    public Shipment(Address address, Order order, ShipmentState state, Boolean userAcknowledge) {
        this.address = address;
        this.order = order;
        this.state = state;
        this.userAcknowledge = userAcknowledge;
    }
}