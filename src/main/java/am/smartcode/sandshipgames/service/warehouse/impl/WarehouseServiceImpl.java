package am.smartcode.sandshipgames.service.warehouse.impl;

import am.smartcode.sandshipgames.mapper.WarehouseMapper;
import am.smartcode.sandshipgames.model.dto.warehouse.CreateWarehouseDto;
import am.smartcode.sandshipgames.model.dto.warehouse.WarehouseDto;
import am.smartcode.sandshipgames.model.entity.WarehouseEntity;
import am.smartcode.sandshipgames.repository.WarehouseRepository;
import am.smartcode.sandshipgames.service.warehouse.WarehouseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;

    @Override
    @Transactional
    public WarehouseDto create(CreateWarehouseDto createWarehouseDto) {
        WarehouseEntity entity = warehouseMapper.toEntity(createWarehouseDto);
        warehouseRepository.save(entity);
        return warehouseMapper.toDto(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WarehouseDto> getAll() {
        return warehouseRepository.findAll().stream().map(warehouseMapper::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public WarehouseDto getById(Integer id) {
        WarehouseEntity materialType = warehouseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Warehouse with id: %d not found.", id)));
        return warehouseMapper.toDto(materialType);
    }

    @Override
    @Transactional
    public void delete(int id) {
        warehouseRepository.deleteById(id);
    }

}