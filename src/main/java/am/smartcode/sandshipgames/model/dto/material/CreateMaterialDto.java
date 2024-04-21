package am.smartcode.sandshipgames.model.dto.material;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateMaterialDto {
    @NotNull
    private Integer warehouseId;
    @NotNull
    private Integer materialTypeId;
    private int quantity;
}