package am.smartcode.sandshipgames.controller;

import am.smartcode.sandshipgames.model.dto.warehouse.CreateWarehouseDto;
import am.smartcode.sandshipgames.model.dto.warehouse.WarehouseDto;
import am.smartcode.sandshipgames.service.warehouse.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    private final WarehouseService warehouseService;

    @PostMapping
    public ResponseEntity<WarehouseDto> create(@RequestBody CreateWarehouseDto createWarehouseDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(warehouseService.create(createWarehouseDto));
    }

    @GetMapping
    public ResponseEntity<List<WarehouseDto>> getAll() {
        return ResponseEntity.ok(warehouseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(warehouseService.getById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        warehouseService.delete(id);
        return ResponseEntity.ok().build();
    }

}