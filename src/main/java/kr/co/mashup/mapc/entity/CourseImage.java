package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "course_image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "courseImageId")
public class CourseImage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_image_id")
    private Long courseImageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "image_url", length = 300)
    private String imageUrl;
}
