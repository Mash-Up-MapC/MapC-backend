package kr.co.mashup.mapc.entity;


import kr.co.mashup.mapc.dto.BookingDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@ToString
//@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "booker", nullable = false)
    private String booker;

    @Column(name = "booker_password")
    private String bookerPassword;

    @Column(name = "cellphone", nullable = false)
    private String cellphone;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "adult_personnel", nullable = false)
    private Integer adultPersonnel;

    @Column(name = "child_personnel", nullable = false)
    private Integer childPersonnel;

    @Column(name = "booking_date", nullable = false)
    private Date bookingDate;

    @Column(name = "boarding_time", nullable = false)
    private String boardingTime;

    @Column(name = "boarding_place")
    private String boardingPlace;

    @Column(name = "sum_price", nullable = false)
    private Integer sumPrice;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    public Booking(){}

    @Builder
    public Booking(Long id, Integer adultPersonnel, Integer childPersonnel, Date bookingDate, String boardingTime, String booker, String cellphone, Integer sumPrice, String paymentMethod, Tourist tourist, Course course) {
        this.id = id;
        this.adultPersonnel = adultPersonnel;
        this.childPersonnel = childPersonnel;
        this.bookingDate = bookingDate;
        this.boardingTime = boardingTime;
        this.booker = booker;
        this.cellphone = cellphone;
        this.sumPrice = sumPrice;
        this.paymentMethod = paymentMethod;
        this.tourist = tourist;
        this.course = course;
    }

//    @Builder
//    public Booking(BookingDto bookingDto) {
//        this.id = bookingDto.getCourseId();
//        this.adultPersonnel = bookingDto.getAdultPersonnel();
//        this.childPersonnel = bookingDto.getChildPersonnel();
//        this.bookingDate = bookingDto.getBookingDate();
//        this.boardingTime = bookingDto.getBoardingTime();
//        this.booker = bookingDto.getBooker();
//        this.cellphone = bookingDto.getCellphone();
//        this.sumPrice = bookingDto.getAdultPersonnel();
//        this.paymentMethod = bookingDto.getPaymentMethod();
//    }
}
