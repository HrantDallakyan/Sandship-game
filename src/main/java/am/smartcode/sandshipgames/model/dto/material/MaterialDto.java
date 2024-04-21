package am.smartcode.sandshipgames.model.dto.material;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialDto {
    private Integer id;
    private Integer warehouseId;
    private Integer materialTypeId;
    private int quantity;
}