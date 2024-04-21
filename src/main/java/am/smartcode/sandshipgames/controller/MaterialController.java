package am.smartcode.sandshipgames.controller;

import am.smartcode.sandshipgames.model.dto.material.CreateMaterialDto;
import am.smartcode.sandshipgames.model.dto.material.MoveMaterialDto;
import am.smartcode.sandshipgames.model.dto.material.RemoveMaterialDto;
import am.smartcode.sandshipgames.service.material.MaterialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/material")
public class MaterialController {
    private final MaterialService materialService;

    @PostMapping("/add")
    ResponseEntity<Void> addMaterial(@RequestBody @Valid CreateMaterialDto createMaterialDto) {
        materialService.addMaterial(createMaterialDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/remove")
    ResponseEntity<Void> removeMaterial(@RequestBody @Valid RemoveMaterialDto removeMaterialDto) {
        materialService.removeMaterial(removeMaterialDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/move")
    ResponseEntity<Void> moveMaterial(@RequestBody MoveMaterialDto moveMaterialDto) {
        materialService.moveMaterial(moveMaterialDto);
        return ResponseEntity.ok().build();
    }

}