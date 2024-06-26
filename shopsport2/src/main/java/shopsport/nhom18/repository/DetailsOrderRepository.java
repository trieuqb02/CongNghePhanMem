package shopsport.nhom18.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shopsport.nhom18.model.DetailsOder;
import shopsport.nhom18.model.DetailsOderPk;

public interface DetailsOrderRepository extends JpaRepository<DetailsOder,DetailsOderPk>{

}
