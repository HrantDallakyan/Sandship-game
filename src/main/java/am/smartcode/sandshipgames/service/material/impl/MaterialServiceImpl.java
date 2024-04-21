package am.smartcode.sandshipgames.service.material.impl;

import am.smartcode.sandshipgames.model.dto.material.CreateMaterialDto;
import am.smartcode.sandshipgames.model.dto.material.MoveMaterialDto;
import am.smartcode.sandshipgames.model.dto.material.RemoveMaterialDto;
import am.smartcode.sandshipgames.model.entity.MaterialQuantityEntity;
import am.smartcode.sandshipgames.model.entity.MaterialTypeEntity;
import am.smartcode.sandshipgames.model.entity.WarehouseEntity;
import am.smartcode.sandshipgames.repository.MaterialTypeRepository;
import am.smartcode.sandshipgames.repository.WarehouseRepository;
import am.smartcode.sandshipgames.service.material.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {
    private final WarehouseRepository warehouseRepository;
    private final MaterialTypeRepository materialTypeRepository;

    @Override
    @Transactional
    public void addMaterial(CreateMaterialDto createMaterialDto) {
        WarehouseEntity warehouse = getWarehouse(createMaterialDto.getWarehouseId());
        MaterialTypeEntity materialType = getMaterialType(createMaterialDto.getMaterialTypeId());
        MaterialQuantityEntity material = getMaterialQuantity(warehouse, materialType);

        if (material != null)
            createMaterial(createMaterialDto.getQuantity(), material, materialType);
        else
            createNewMaterial(createMaterialDto.getQuantity(), warehouse, materialType);
        warehouseRepository.save(warehouse);
    }

    @Override
    @Transactional
    public void removeMaterial(RemoveMaterialDto removeMaterialDto) {
        WarehouseEntity warehouse = getWarehouse(removeMaterialDto.getWarehouseId());
        MaterialTypeEntity materialType = getMaterialType(removeMaterialDto.getMaterialTypeId());
        MaterialQuantityEntity material = getMaterialQuantity(warehouse, materialType);

        if (material != null)
            removeMaterial(removeMaterialDto.getQuantity(), material, materialType);
        warehouseRepository.save(warehouse);
    }

    @Override
    @Transactional
    public void moveMaterial(MoveMaterialDto materialTypeId) {
        removeMaterial(new RemoveMaterialDto(materialTypeId.getSourceWarehouseId(), materialTypeId.getMaterialTypeId(), materialTypeId.getQuantity()));
        addMaterial(new CreateMaterialDto(materialTypeId.getDestinationWarehouseId(), materialTypeId.getMaterialTypeId(), materialTypeId.getQuantity()));
    }

    private MaterialQuantityEntity getMaterialQuantity(WarehouseEntity warehouse, MaterialTypeEntity materialType) {
        return warehouse.getMaterials().stream()
                .filter(mq -> mq.getMaterialType().equals(materialType))
                .findFirst().orElse(null);
    }

    private WarehouseEntity getWarehouse(Integer warehouseId) {
        return warehouseRepository.findById(warehouseId).orElseThrow(() -> new RuntimeException("WarehouseEntity not found"));
    }

    private MaterialTypeEntity getMaterialType(Integer materialTypeId) {
        return materialTypeRepository.findById(materialTypeId).orElseThrow(() -> new RuntimeException("Material type not found"));
    }

    private void createMaterial(Integer quantity, MaterialQuantityEntity material, MaterialTypeEntity materialType) {
        int getQuantity = material.getQuantity() + quantity;
        int maxCapacity = materialType.getMaxCapacity();
        if (getQuantity <= maxCapacity)
            material.setQuantity(material.getQuantity() + quantity);
        else throw new IllegalArgumentException("Quantity exceeds maximum capacity");
    }

    private void createNewMaterial(Integer quantity, WarehouseEntity warehouse, MaterialTypeEntity materialType) {
        int maxCapacity = materialType.getMaxCapacity();
        if (quantity < maxCapacity) {
            MaterialQuantityEntity entity = new MaterialQuantityEntity();
            entity.setQuantity(quantity);
            entity.setWarehouse(warehouse);
            entity.setMaterialType(materialType);
            warehouse.getMaterials().add(entity);
        } else throw new IllegalArgumentException("Quantity exceeds maximum capacity");
    }

    private void removeMaterial(Integer quantity, MaterialQuantityEntity material, MaterialTypeEntity materialType) {
        int getQuantity = material.getQuantity() - quantity;
        if (getQuantity > 0)
            material.setQuantity(material.getQuantity() - quantity);
        else throw new IllegalArgumentException("Selected quantity exceeds");
    }

}