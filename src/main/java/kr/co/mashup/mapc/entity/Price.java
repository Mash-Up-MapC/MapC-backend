package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;

/**
 * 가격 정보
 */
@Entity
@Table(name = "price")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
public class Price extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    // FIXME: 2018. 9. 2. price.price ?? 살짝 이상한듯..
    @Column(name = "price")
    private int price;

    @Column(name = "passenger_type")
    private String passengerType;


    @Builder
    public Price(Course course, int price, String passengerType) {
        this.course = course;
        this.price = price;
        this.passengerType = passengerType;
    }
}
