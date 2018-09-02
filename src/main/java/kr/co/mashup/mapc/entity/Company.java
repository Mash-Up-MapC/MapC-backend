package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * 회사
 */
@Entity
@Table(name = "company")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"courses"})
@EqualsAndHashCode(callSuper = false, of = "id")
public class Company extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Course> courses;

    @Builder
    public Company(String name) {
        this.name = name;
    }
}
