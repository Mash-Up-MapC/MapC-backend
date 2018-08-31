package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;

/**
 * 정류장의 주변 정보의 카테고리
 */
@Entity
@Table(name = "information_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "informationCategoryId")
public class InformationCategory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "information_category_id")
    private Long informationCategoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "information_id")
    private Information information;
}
