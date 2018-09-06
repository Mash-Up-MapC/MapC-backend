package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;

/**
 * 정류장의 이미지
 */
@Entity
@Table(name = "station_image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"station"})
@EqualsAndHashCode(callSuper = false, of = "id")
public class StationImage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    private Station station;

    @Column(name = "image_url", length = 300)
    private String imageUrl;

    @Builder
    public StationImage(Station station, String imageUrl) {
        this.station = station;
        this.imageUrl = imageUrl;
    }
}
