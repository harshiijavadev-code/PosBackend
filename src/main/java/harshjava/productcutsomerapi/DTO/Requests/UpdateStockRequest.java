package harshjava.productcutsomerapi.DTO.Requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UpdateStockRequest {
    @NotNull( message = "quantity is required ")
    @Min(value =0,message = "cannot be negative")
    private Integer quantity;

    private String reason;
}
