package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * 정류장
 */
@Entity
@Table(name = "station")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"course", "stationImages", "informations", "timeTables"})
@EqualsAndHashCode(callSuper = false, of = "id")
public class Station extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Lob
    @Column(name = "audio_content", columnDefinition = "TEXT")
    private String audioContent;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "station")
//    @JoinColumn(name = "station_id")
    @OneToMany(mappedBy = "station")
    private List<StationImage> stationImages;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "station", cascade = CascadeType.ALL)
    private List<Information> informations;

    @OneToMany(mappedBy = "station")
    private List<StationTimeTable> timeTables;

    @Builder
    public Station(Course course, String name, String description, int number, Double latitude, Double longitude, String audioContent) {
        this.course = course;
        this.name = name;
        this.description = description;
        this.number = number;
        this.latitude = latitude;
        this.longitude = longitude;
        this.audioContent = audioContent;
    }
}
