package com.NinoCenov.CarSpareParts.entity.model;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "Model")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id", nullable = false)
    private Long id;

    @Column(name = "model_name", nullable = false)
    @NotEmpty()
    @Size(min=2, max = 255)
    private String modelName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "make_id")
    @JsonBackReference()
    private Make make;


}
