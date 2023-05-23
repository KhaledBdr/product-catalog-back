package com.fawry.productcatalog.dto;
import com.fawry.productcatalog.entity.Address;
import com.fawry.productcatalog.entity.Order;
import com.fawry.productcatalog.entity.ShipmentState;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ShipmentDTO {
        private Long id;
        @NotNull
        private Address address;
        @NotNull
        private Order order;
        private ShipmentState state = ShipmentState.RECEIVED;
        private Boolean userAcknowledge = false;

        public ShipmentDTO(Address address, Order order) {
            this.address = address;
            this.order = order;
            this.userAcknowledge = false;
        }
}
