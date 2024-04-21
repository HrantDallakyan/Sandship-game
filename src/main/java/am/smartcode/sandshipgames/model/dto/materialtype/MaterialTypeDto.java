package am.smartcode.sandshipgames.model.dto.materialtype;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialTypeDto {
    private Integer id;
    private String name;
    private String description;
    private String icon;
    private int maxCapacity;
}
