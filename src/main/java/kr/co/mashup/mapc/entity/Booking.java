package kr.co.mashup.mapc.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "booking")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "bookingId")
public class Booking extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "booker", length = 45, nullable = false)
    private String booker;

    @Column(name = "booker_password")
    private String bookerPassword;

    @Column(name = "cell_phone_number", length = 20, nullable = false)
    private String cellPhoneNumber;

    @Column(name = "home_phone_number", length = 20)
    private String homePhoneNumber;

    @Column(name = "adult_personnel", nullable = false)
    private int adultPersonnel;

    @Column(name = "child_personnel", nullable = false)
    private int childPersonnel;

    @Column(name = "booking_date", length = 100, nullable = false)
    private String bookingDate;

    @Column(name = "boarding_time", length = 100, nullable = false)
    private String boardingTime;

    @Column(name = "boarding_place", nullable = false)
    private String boardingPlace;

    @Column(name = "sum_price", nullable = false)
    private int sumPrice;

    @Column(name = "payment_method", length = 45, nullable = false)
    private String paymentMethod;
}
