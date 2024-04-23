package kz.springproject.phoenix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_applications")
@Data
public class Application extends AbstractEntity {

    private String product;
    private Integer quantity;
    private String deliveryAddress;
    private String phoneNumber;

}
