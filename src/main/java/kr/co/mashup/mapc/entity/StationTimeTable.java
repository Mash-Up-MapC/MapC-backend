package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by ethan.kim on 2018. 8. 31..
 */
@Entity
@Table(name = "station_time_table")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "stationTimeTableId")
public class StationTimeTable extends BaseTimeEntity {

    // TODO: 2018. 8. 31. time table 데이터보고 필드 추가 필요
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_time_table_id")
    private Long stationTimeTableId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    private Station station;

    @Column(name = "arrival_time", length = 45, nullable = false)
    private String arrivalTime;
}
