package com.NinoCenov.CarSpareParts.entity.partcategory;

import com.NinoCenov.CarSpareParts.entity.part.Part;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "PartCategory")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_category_id", nullable = false)
    private Long id;

    @Column(name = "part_category_name", nullable = false)
    @NotEmpty()
    @Size(min=2, max = 255)
    private String partCategoryName;

    @Column(name = "part_category_description", nullable = false)
    @NotEmpty()
    @Size(min=2, max = 255)
    private String partCategoryDescription;

    @OneToMany(mappedBy = "partCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference()
    private List<Part> part;
}
