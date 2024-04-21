package am.smartcode.sandshipgames.repository;

import am.smartcode.sandshipgames.model.entity.MaterialTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialTypeRepository extends JpaRepository<MaterialTypeEntity, Integer> {
}