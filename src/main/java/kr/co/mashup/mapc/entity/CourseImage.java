package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;

/**
 * 코스의 이미지
 */
@Entity
@Table(name = "course_image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
public class CourseImage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "image_url", length = 300)
    private String imageUrl;

    @Builder
    public CourseImage(Course course, String imageUrl) {
        this.course = course;
        this.imageUrl = imageUrl;
    }
}
