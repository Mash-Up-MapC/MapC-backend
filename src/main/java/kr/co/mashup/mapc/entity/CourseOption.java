package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;

/**
 * 코스의 부가 정보
 * <p>
 * Created by ethan.kim on 2018. 9. 1..
 */
@Entity
@Table(name = "course_option")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
public class CourseOption extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Enumerated(EnumType.STRING)
    @Column(name = "option_type", length = 50, nullable = false)
    private OptionType optionType;

    @Column(name = "option_value", length = 1000, nullable = false)
    private String optionValue;

    public enum OptionType {
        SUMMARY,
        DETAIL,
        ROUTE,
        PRECAUTIONS
    }

    @Builder
    public CourseOption(Course course, OptionType optionType, String optionValue) {
        this.course = course;
        this.optionType = optionType;
        this.optionValue = optionValue;
    }
}
