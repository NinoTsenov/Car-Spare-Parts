package com.NinoCenov.CarSpareParts.entity.make;

import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.entity.part.Part;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.Set;

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
    @Column(name = "make_id", nullable = false)
    private Long id;

    @Column(name = "make_name", nullable = false)
    @NotEmpty()
    @Size(min=2, max = 255)
    private String makeName;

    @OneToMany(mappedBy = "make", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Model> model;

}
