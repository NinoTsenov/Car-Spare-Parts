package com.NinoCenov.CarSpareParts.entity.make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "Make")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Make {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "make", nullable = false)
    @NotEmpty()
    @Size(min=2, max = 255)
    private String make;

    @OneToMany(mappedBy = "make", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Model> models;

}
