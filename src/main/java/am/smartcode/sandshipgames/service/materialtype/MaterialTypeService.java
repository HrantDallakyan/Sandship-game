package am.smartcode.sandshipgames.service.materialtype;

import am.smartcode.sandshipgames.model.dto.materialtype.CreateMaterialTypeDto;
import am.smartcode.sandshipgames.model.dto.materialtype.MaterialTypeDto;

import java.util.List;

public interface MaterialTypeService {
    MaterialTypeDto create(CreateMaterialTypeDto createMaterialTypeDto);

    List<MaterialTypeDto> getAll();

    MaterialTypeDto getById(Integer id);

    void delete(int id);
}
