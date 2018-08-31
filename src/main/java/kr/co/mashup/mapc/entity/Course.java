package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"courseOptions", "courseImages", "prices", "bookings", "stations"})
@EqualsAndHashCode(callSuper = false, of = "courseId")
public class Course extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "title", length = 45, nullable = false)
    private String title;

    @Column(name = "sub_title", length = 24, nullable = false)
    private String subTitle;

    @Column(name = "main_color", length = 10, nullable = false)
    private String mainColor;

    @Column(name = "sub_color", length = 10, nullable = false)
    private String subColor;

    @Column(name = "icon_url", length = 300, nullable = false)
    private String iconUrl;

    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "course")
    private List<CourseOption> courseOptions;

    @OneToMany(mappedBy = "course")
    private List<CourseImage> courseImages;

    @OneToMany(mappedBy = "course")
    private List<Price> prices;

    @OneToMany(mappedBy = "course")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "course")
    private List<Station> stations;
}
