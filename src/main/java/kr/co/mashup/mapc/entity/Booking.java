package kr.co.mashup.mapc.entity;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@ToString
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "booker")
    private String booker;

    @Column(name = "booker_password")
    private String bookerPassword;

    @Column(name = "cellphone")
    private String cellphone;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "adult_personnel")
    private String adultPersonnel;

    @Column(name = "child_personnel")
    private String childPersonnel;

    @Column(name = "booking_date")
    private String bookingDate;

    @Column(name = "boarding_time")
    private String boardingTime;

    @Column(name = "boarding_place")
    private String boardingPlace;

    @Column(name = "sum_price")
    private String sumPrice;

    @Column(name = "payment_method")
    private String paymentMethod;

}
