package kz.springproject.phoenix.dto;

import lombok.Data;

@Data
public class ApplicationDto {

    private String product;
    private Integer quantity;
    private String deliveryAddress;
    private String phoneNumber;

}
