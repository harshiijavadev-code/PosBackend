package harshjava.productcutsomerapi.Repository;
import harshjava.productcutsomerapi.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface categoryRepository extends JpaRepository<Category, Long>{
    Optional<Category> findbyname(String name);
    boolean existbyname(String name);

    Boolean updatebyname( String name );

}
