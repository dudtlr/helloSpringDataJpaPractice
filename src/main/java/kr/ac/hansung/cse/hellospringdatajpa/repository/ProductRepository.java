package kr.ac.hansung.cse.hellospringdatajpa.repository;

import kr.ac.hansung.cse.hellospringdatajpa.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //안달아도 된다는데?
public interface ProductRepository extends JpaRepository<Product,Long> {


    Product findByName(String name);
    List<Product> findByNameContaining(String searchKeyword, Pageable paging);

    @Query("select p from Product p where p.name like %?1%")
    List<Product> searchByName(String name);
    @Query("select p from Product p where p.name like %:name%")
    List<Product> searchByName2(@Param("name") String name);

}
