package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * 카테고리
 */
@Entity
@Table(name = "category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"informationCategories"})
@EqualsAndHashCode(callSuper = false, of = "categoryId")
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "name", length = 100)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<InformationCategory> informationCategories;

    @Builder
    public Category(String name) {
        this.name = name;
    }
}
