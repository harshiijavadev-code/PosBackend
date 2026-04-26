package harshjava.productcutsomerapi.DTO.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter @NoArgsConstructor
public class UpdateCategoryRequest {


    @NotBlank(message ="category name is required ")
    @Size(min =2, max = 100 , message = "name of the cataegory should be under the 2 to 100 characters ")
    private String name;
    @Size (min =2, max = 200 , message = "discription is required and cannot exceed 200 characters ")
    private String description;
}
