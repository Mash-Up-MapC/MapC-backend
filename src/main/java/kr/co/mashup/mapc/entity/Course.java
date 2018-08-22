package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@ToString(exclude = {"courseImageItems", "priceItems"})
@Table(name = "course")
public class Course  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id", nullable = true)
    private Company company;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // TODO FetchType 별 차이 알아내기
    @JoinColumn(name = "course_id")
    private List<CourseImage> courseImageItems;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Price> priceItems;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "description")
    private String description;

    @Column(name = "is_audio")
    private Integer isAudio;

    @Builder
    public Course (String courseName, String description, Integer isAudio) {
        this.courseName = courseName;
        this.description = description;
        this.isAudio = isAudio;
    }
}
