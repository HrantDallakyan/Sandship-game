package am.smartcode.sandshipgames.mapper;

import am.smartcode.sandshipgames.model.dto.material.CreateMaterialDto;
import am.smartcode.sandshipgames.model.dto.material.MaterialDto;
import am.smartcode.sandshipgames.model.dto.material.RemoveMaterialDto;
import am.smartcode.sandshipgames.model.entity.MaterialQuantityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialMapper {
    MaterialQuantityEntity toEntity(CreateMaterialDto createMaterialDto);
    MaterialQuantityEntity toEntityQuantity(RemoveMaterialDto removeMaterialDto);

    MaterialDto toDto(MaterialQuantityEntity materialQuantityEntity);
}
