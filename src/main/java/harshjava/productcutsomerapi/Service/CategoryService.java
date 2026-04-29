package harshjava.productcutsomerapi.Service;

import harshjava.productcutsomerapi.DTO.Requests.CreateCategoryRequest;
import harshjava.productcutsomerapi.DTO.Requests.UpdateCategoryRequest;
import harshjava.productcutsomerapi.DTO.Response.CategoryResponse;
import harshjava.productcutsomerapi.Entity.Category;
import harshjava.productcutsomerapi.Exception.DuplicateResourceException;
import harshjava.productcutsomerapi.Exception.ResourceNotFoundException;
import harshjava.productcutsomerapi.Repository.categoryRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryService {
    private final categoryRepository categoryRepository;

    public CategoryService(categoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
   public CategoryResponse createCategory(CreateCategoryRequest request) {
       if (categoryRepository.existbyname(request.getName())) {
           throw new DuplicateResourceException("category", "name", request.getName());
       }
       Category category = Category.builder()
               .name(request.getName().trim())
               .description(request.getDescription())
               .build();

       Category savedCategory = categoryRepository.save(category);
       return CategoryResponse.from(savedCategory);

   }
   @Transactional
   public List<CategoryResponse> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryResponse::from)
                .collect(Collectors.toList());
   }
@Transactional
   public CategoryResponse geCategoryId(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow() -> new ResourceNotFoundException("category", "id", id);
        return CategoryResponse.from(category);
   }
   public CategoryResponse updateCategory( Long id , UpdateCategoryRequest request) {
        Category category =categoryRepository.findAll(id)
                .orElseThrow() -> new ResourceNotFoundException("category", "id", id);{
                    if(request.getName()!=null&&!request.getName().isBlank()) {
                        boolean nameTakenByAnother = categoryRepository.findByName(request.getName())
                                .map(existingCategory -> existingCategory.getId().equals(id))
                                .orElse(false);
                    }


       }
   }
}
