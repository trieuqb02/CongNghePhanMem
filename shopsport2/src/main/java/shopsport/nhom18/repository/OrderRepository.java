package shopsport.nhom18.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shopsport.nhom18.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	@Query("SELECT o FROM Order o LEFT JOIN o.staff s WHERE s IS NULL")
	List<Order> findOrdersWithNoStaff();

	@Query("SELECT o FROM Order o LEFT JOIN o.staff s WHERE s IS NULL")
	Page<Order> findOrdersWithNoStaff(Pageable pageable);

	@Query("SELECT o FROM Order o LEFT JOIN o.staff s WHERE s IS NOT NULL")
	List<Order> findOrdersWithStaff();

	@Query("SELECT o FROM Order o LEFT JOIN o.staff s WHERE s IS NOT NULL")
	Page<Order> findOrdersWithStaff(Pageable pageable);

	List<Order> findAllByCustomer_Id(String id);

	Order findOneById(Long id);
}
