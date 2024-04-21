package am.smartcode.sandshipgames.service.materialtype.impl;

import am.smartcode.sandshipgames.mapper.MaterialTypeMapper;
import am.smartcode.sandshipgames.model.dto.materialtype.CreateMaterialTypeDto;
import am.smartcode.sandshipgames.model.dto.materialtype.MaterialTypeDto;
import am.smartcode.sandshipgames.model.entity.MaterialTypeEntity;
import am.smartcode.sandshipgames.repository.MaterialTypeRepository;
import am.smartcode.sandshipgames.service.materialtype.MaterialTypeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MaterialTypeServiceImpl implements MaterialTypeService {
    private final MaterialTypeRepository materialTypeRepository;
    private final MaterialTypeMapper materialTypeMapper;

    @Override
    @Transactional
    public MaterialTypeDto create(CreateMaterialTypeDto createMaterialTypeDto) {
        MaterialTypeEntity entity = materialTypeMapper.toEntity(createMaterialTypeDto);
        materialTypeRepository.save(entity);
        return materialTypeMapper.toDto(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MaterialTypeDto> getAll() {
        return materialTypeRepository.findAll().stream().map(materialTypeMapper::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public MaterialTypeDto getById(Integer id) {
        MaterialTypeEntity materialType = materialTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("MaterialType with id: %d not found.", id)));
        return materialTypeMapper.toDto(materialType);
    }

    @Override
    @Transactional
    public void delete(int id) {
        materialTypeRepository.deleteById(id);
    }

}