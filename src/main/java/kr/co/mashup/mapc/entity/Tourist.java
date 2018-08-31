package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@ToString(exclude = {"bookingItems"})
@Table(name = "tourist")
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // TODO 타입별 차이 알아내기
    private Long id;

    @Column(name = "uuid")
    private String uuid;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // TODO FetchType 별 차이 알아내기
    @JoinColumn(name = "tourist_id")
    private List<Booking> bookingItems;

    @Builder
    public Tourist(String uuid) {
        this.uuid = uuid;
    }
}
