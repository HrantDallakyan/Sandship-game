package am.smartcode.sandshipgames.service.material;

import am.smartcode.sandshipgames.model.dto.material.CreateMaterialDto;
import am.smartcode.sandshipgames.model.dto.material.MoveMaterialDto;
import am.smartcode.sandshipgames.model.dto.material.RemoveMaterialDto;

public interface MaterialService {
    void addMaterial(CreateMaterialDto createMaterialDto);

    void removeMaterial(RemoveMaterialDto removeMaterialDto);

    void moveMaterial(MoveMaterialDto materialTypeId);
}