package com.NinoCenov.CarSpareParts.entity.maker;

import com.NinoCenov.CarSpareParts.entity.model.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "Maker")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Maker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maker_id", nullable = false)
    private Long id;

    @Column(name = "maker", nullable = false)
    @NotEmpty()
    @Size(min=2, max = 255)
    private String makerName;

    @OneToMany(mappedBy = "maker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Model> model;

}
