package project.back.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.back.entity.product.JoinMart;
import project.back.entity.product.Product;

import java.util.List;

public interface JoinMartRepository extends JpaRepository<JoinMart, Long> {

    @Query("""
            SELECT mp.joinMart FROM MartProduct mp
            WHERE mp.product IN :products
            GROUP BY mp.joinMart
            HAVING COUNT(DISTINCT mp.product) = :numberOfProducts
            """)
    List<JoinMart> findJoinMartsSellingAllProducts(List<Product> products, Long numberOfProducts);
}
