package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "station")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"stationImages"})
@EqualsAndHashCode(callSuper = false, of = "stationId")
public class Station extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id")
    private Long stationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "station_name", length = 50, nullable = false)
    private String stationName;

    @Column(name = "station_number", nullable = false)
    private int stationNumber;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Lob
    @Column(name = "audio_content", columnDefinition = "TEXT")
    private String audioContent;

    @OneToMany(mappedBy = "station")
    private List<StationImage> stationImages;

    @OneToMany(mappedBy = "station")
    private List<Information> informations;

    @OneToMany(mappedBy = "station")
    private List<StationTimeTable> timeTables;
}
