package am.smartcode.sandshipgames.repository;

import am.smartcode.sandshipgames.model.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Integer> {
}