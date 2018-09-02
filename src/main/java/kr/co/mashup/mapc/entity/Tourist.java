package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * 관광객
 */
@Entity
@Table(name = "tourist")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"bookings"})
@EqualsAndHashCode(callSuper = false, of = "id")
public class Tourist extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", nullable = false)
    private String uuid;

    @OneToMany(mappedBy = "tourist")
    private List<Booking> bookings;

    @Builder
    public Tourist(String uuid) {
        this.uuid = uuid;
    }
}
