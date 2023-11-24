package com.NinoCenov.CarSpareParts.entity.make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Makes")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Make {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "make_id")
    private Long id;


    @NotBlank
    @Size(min=2)
    private String name;

    @OneToMany(mappedBy = "make", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Model> model=new ArrayList<>();

}
