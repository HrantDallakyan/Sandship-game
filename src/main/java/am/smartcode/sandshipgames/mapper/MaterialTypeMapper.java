package am.smartcode.sandshipgames.mapper;
import am.smartcode.sandshipgames.model.dto.materialtype.CreateMaterialTypeDto;
import am.smartcode.sandshipgames.model.dto.materialtype.MaterialTypeDto;
import am.smartcode.sandshipgames.model.entity.MaterialTypeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialTypeMapper {
    MaterialTypeEntity toEntity(CreateMaterialTypeDto createMaterialTypeDto);

    MaterialTypeDto toDto(MaterialTypeEntity materialType);

}