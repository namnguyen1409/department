package com.namnguyen1409.test.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    String id;

    @Column(nullable = false, unique = true, length = 50)
    String username;

    @Column(nullable = false, length = 100)
    String password;

    @ManyToOne
    @JoinColumn(name = "department_id")
    Department department;


    private String role;

}
