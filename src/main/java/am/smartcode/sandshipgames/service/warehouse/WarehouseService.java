package am.smartcode.sandshipgames.service.warehouse;

import am.smartcode.sandshipgames.model.dto.warehouse.CreateWarehouseDto;
import am.smartcode.sandshipgames.model.dto.warehouse.WarehouseDto;

import java.util.List;

public interface WarehouseService {
    WarehouseDto create(CreateWarehouseDto createWarehouseDto);

    List<WarehouseDto> getAll();

    WarehouseDto getById(Integer id);

    void delete(int id);
}