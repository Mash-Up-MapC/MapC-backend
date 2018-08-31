package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "price")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "priceId")
public class Price extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Long priceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "price")
    private int price;

    @Enumerated(EnumType.STRING)
    @Column(name = "passenger_type")
    private PassengerType passengerType;

    public enum PassengerType {
        ADULT,
        CHILD
    }
}
