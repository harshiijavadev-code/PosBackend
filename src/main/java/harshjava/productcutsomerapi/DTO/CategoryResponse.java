package harshjava.productcutsomerapi.DTO;



import harshjava.productcutsomerapi.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse {

    private Long id;
    private String name;
    private String description;
    private int productCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CategoryResponse from(Category category) {
        long activeProductCount = category.getProducts()
                .stream()
                .filter(p -> Boolean.TRUE.equals(p.getActive()))
                .count();

        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .productCount((int) activeProductCount)
                .createdAt(category.getCreatedAT())
                .updatedAt(category.getUpdatedAT())
                .build();
    }
}