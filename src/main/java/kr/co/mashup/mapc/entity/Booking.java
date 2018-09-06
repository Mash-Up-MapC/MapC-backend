package kr.co.mashup.mapc.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * 예약 정보
 */
@Entity
@Table(name = "booking")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
public class Booking extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "booker_name", length = 45, nullable = false)
    private String bookerName;

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
    private Date bookingDate;

    @Column(name = "boarding_time", length = 100, nullable = false)
    private String boardingTime;

    @Column(name = "boarding_place")
    private String boardingPlace;

    @Column(name = "sum_price", nullable = false)
    private int sumPrice;

    @Column(name = "payment_method", length = 45, nullable = false)
    private String paymentMethod;

    @Builder
    public Booking(Tourist tourist,
                   Long id,
                   Course course,
                   String bookerName,
                   String bookerPassword,
                   String cellPhoneNumber,
                   String homePhoneNumber,
                   int adultPersonnel,
                   int childPersonnel,
                   Date bookingDate,
                   String boardingTime,
                   String boardingPlace,
                   int sumPrice, String paymentMethod) {
        this.id = id;
        this.tourist = tourist;
        this.course = course;
        this.bookerName = bookerName;
        this.bookerPassword = bookerPassword;
        this.cellPhoneNumber = cellPhoneNumber;
        this.homePhoneNumber = homePhoneNumber;
        this.adultPersonnel = adultPersonnel;
        this.childPersonnel = childPersonnel;
        this.bookingDate = bookingDate;
        this.boardingTime = boardingTime;
        this.boardingPlace = boardingPlace;
        this.sumPrice = sumPrice;
        this.paymentMethod = paymentMethod;
    }
}
