package kz.springproject.phoenix.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationDto {

    private Long id;
    private LocalDateTime publishedDate;

    @NotBlank(message = "Product name cannot be empty")
    private String product;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @NotBlank(message = "Delivery address cannot be empty")
    private String deliveryAddress;

    // Регулярное выражение для проверки номера телефона. Это пример и его нужно адаптировать под формат номеров в вашей стране.
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid phone number format")
    private String phoneNumber;

}
