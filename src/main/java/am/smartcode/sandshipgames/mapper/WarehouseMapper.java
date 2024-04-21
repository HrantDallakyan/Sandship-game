package am.smartcode.sandshipgames.mapper;

import am.smartcode.sandshipgames.model.dto.warehouse.CreateWarehouseDto;
import am.smartcode.sandshipgames.model.dto.warehouse.WarehouseDto;
import am.smartcode.sandshipgames.model.entity.WarehouseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {
    WarehouseEntity toEntity(CreateWarehouseDto createWarehouseDto);

    WarehouseDto toDto(WarehouseEntity warehouse);
}