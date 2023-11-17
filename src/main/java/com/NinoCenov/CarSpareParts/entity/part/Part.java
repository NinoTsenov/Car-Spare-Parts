package com.NinoCenov.CarSpareParts.entity.part;

import com.NinoCenov.CarSpareParts.entity.partcategory.PartCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "Parts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id", nullable = false)
    private Long id;

    @Column(name = "part_name", nullable = false)
    @NotEmpty()
    @Size(min=2, max = 255)
    private String partName;

    @Column(name = "part_description", nullable = false)
    @NotEmpty()
    @Size(min=2, max = 255)
    private String partDescription;

    @Column(name = "part_price", nullable = false)
    @NotEmpty()
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "part_category_id")
    private PartCategory partCategory;
}
