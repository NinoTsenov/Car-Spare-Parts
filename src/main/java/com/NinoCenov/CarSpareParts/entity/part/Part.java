package com.NinoCenov.CarSpareParts.entity.part;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.entity.category.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.List;


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
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "part", nullable = false)
    @NotEmpty()
    @Size(min=2, max = 255)
    private String partName;

    @Column(name = "part_description", nullable = false)
    @NotEmpty()
    @Size(min=2, max = 255)
    private String partDescription;

    @Column(name = "price", nullable = false)
    @NotEmpty()
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "part_model",
            joinColumns = @JoinColumn(name = "part_id"),
            inverseJoinColumns = @JoinColumn(name = "model_id"))
    private List<Model> setOfPartsAndModels;
}
