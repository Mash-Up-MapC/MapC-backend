package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;

/**
 * 정류장 시간표
 * TODO: 2018. 8. 31. time table 데이터보고 필드 추가 필요
 * <p>
 * Created by ethan.kim on 2018. 8. 31..
 */
@Entity
@Table(name = "station_time_table")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
public class StationTimeTable extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    private Station station;

    @Column(name = "arrival_time", length = 45, nullable = false)
    private String arrivalTime;

    @Builder
    public StationTimeTable(Station station, String arrivalTime) {
        this.station = station;
        this.arrivalTime = arrivalTime;
    }
}
