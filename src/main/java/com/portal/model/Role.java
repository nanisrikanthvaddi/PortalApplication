package com.portal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="role_sequence")
    @SequenceGenerator(name = "role_sequence" , sequenceName =  "role_sequence",allocationSize = 1)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name")
    private String roleName;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "roles_permission", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permissions> permissions = new ArrayList<>();

}
