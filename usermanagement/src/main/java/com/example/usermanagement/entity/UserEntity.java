package com.example.usermanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    private String mobile;

    private String email;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private StateEntity stateEntity;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity cityEntity;

    private String hobbies;

    private String photoPath;
}
