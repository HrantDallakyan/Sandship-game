package am.smartcode.sandshipgames.model.dto.material;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RemoveMaterialDto {
    @NotNull
    private Integer warehouseId;
    @NotNull
    private Integer materialTypeId;
    private int quantity;
}
