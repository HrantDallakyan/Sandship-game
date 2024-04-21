package am.smartcode.sandshipgames.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "warehouse")
public class WarehouseEntity extends BaseEntity {

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MaterialQuantityEntity> materials = new ArrayList<>();

}