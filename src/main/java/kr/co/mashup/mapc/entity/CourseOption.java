package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by ethan.kim on 2018. 9. 1..
 */
@Entity
@Table(name = "course_option")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "courseOptionId")
public class CourseOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_option_id")
    private Long courseOptionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Enumerated(EnumType.STRING)
    @Column(name = "option_type", length = 50, nullable = false)
    private OptionType optionType;

    @Column(name = "option_value", length = 1000, nullable = false)
    private String optionValue;

    enum OptionType {
        SUMMARY,
        DETAIL
    }
}
