package am.smartcode.sandshipgames.model.dto.warehouse;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateWarehouseDto {
    @NotNull
    private Integer id;
}
