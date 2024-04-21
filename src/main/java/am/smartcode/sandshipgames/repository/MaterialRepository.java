package am.smartcode.sandshipgames.repository;

import am.smartcode.sandshipgames.model.entity.MaterialQuantityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<MaterialQuantityEntity, Integer> {

}