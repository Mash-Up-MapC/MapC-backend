package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tourist")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"bookings"})
@EqualsAndHashCode(callSuper = false, of = "touristId")
public class Tourist extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tourist_id")
    private Long touristId;

    @Column(name = "uuid", nullable = false)
    private String uuid;

    @OneToMany(mappedBy = "tourist")
    private List<Booking> bookings;

    @Builder
    public Tourist(String uuid) {
        this.uuid = uuid;
    }
}
