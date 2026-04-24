package harshjava.productcutsomerapi.DTO;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter @NoArgsConstructor
public class CreateProductRequest {

    @NotBlank(message = "name is required")
    @Size(min= 2, max =100 , message = "cannot excced more than 100 characters ")
    private String name;

    @Size(min= 2, max =200 , message = "cannot excced more than 200 characters ")
    private String description;

    @NotNull(message = "price cannot be null")
    @DecimalMin(value ="0.01", message = "price must be greater than 0")
    private BigDecimal price;

    @NotNull(message = "category id is required ")
    private Integer CategoryID;
}
