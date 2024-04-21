package am.smartcode.sandshipgames.controller;

import am.smartcode.sandshipgames.model.dto.materialtype.CreateMaterialTypeDto;
import am.smartcode.sandshipgames.model.dto.materialtype.MaterialTypeDto;
import am.smartcode.sandshipgames.service.materialtype.MaterialTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/materialtype")
public class MaterialTypeController {
    private final MaterialTypeService materialTypeService;

    @PostMapping
    public ResponseEntity<MaterialTypeDto> create(@RequestBody @Valid CreateMaterialTypeDto createMaterialTypeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(materialTypeService.create(createMaterialTypeDto));
    }

    @GetMapping
    public ResponseEntity<List<MaterialTypeDto>> getAll() {
        return ResponseEntity.ok(materialTypeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialTypeDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(materialTypeService.getById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        materialTypeService.delete(id);
        return ResponseEntity.ok().build();
    }


}