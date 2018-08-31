package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@ToString
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "price")
    private Integer price;

    @Enumerated(EnumType.STRING)
    @Column(name = "passenger_type")
    private PassengerType passengerType;

    public enum PassengerType {
        ADULT,
        CHILD
    }
}
