package com.NinoCenov.CarSpareParts.entity.category;
import com.NinoCenov.CarSpareParts.entity.part.Part;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Categories")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;


    @NotBlank
    @Size(min=2)
    private String name;


    @NotBlank
    @Size(max=255)
    private String categoryDescription;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Part> part;
}
