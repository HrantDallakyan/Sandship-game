package am.smartcode.sandshipgames.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "material")
public class MaterialQuantityEntity extends BaseEntity {

    @ManyToOne
    private MaterialTypeEntity materialType;

    @ManyToOne
    private WarehouseEntity warehouse;

    private int quantity;
    
}