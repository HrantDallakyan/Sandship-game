package am.smartcode.sandshipgames.model.dto.materialtype;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateMaterialTypeDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String icon;
    private int maxCapacity;

}