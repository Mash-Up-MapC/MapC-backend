package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@ToString
@Table(name = "info_type")
public class InformationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_def_id")
    private TypeDefine typeDef;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "information_id")
    private Information information;
}
