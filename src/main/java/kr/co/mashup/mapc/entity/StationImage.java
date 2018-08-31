package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "station_image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "stationImageId")
public class StationImage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_image_id")
    private Long stationImageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    private Station station;

    @Column(name = "image_url", length = 300)
    private String imageUrl;
}
