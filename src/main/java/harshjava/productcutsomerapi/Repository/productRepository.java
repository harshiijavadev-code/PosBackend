package harshjava.productcutsomerapi.Repository;

import harshjava.productcutsomerapi.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<Product,Long> {

}