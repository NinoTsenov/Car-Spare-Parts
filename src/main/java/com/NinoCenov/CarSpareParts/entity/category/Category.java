package com.NinoCenov.CarSpareParts.entity.category;
import com.NinoCenov.CarSpareParts.entity.part.Part;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Category")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "category", nullable = false)
    @NotEmpty()
    @Size(min=2, max = 255)
    private String categoryName;

    @Column(name = "category_description", nullable = false)
    @NotEmpty()
    @Size(min=2, max = 255)
    private String categoryDescription;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference()
    private List<Part> part;
}
