package kr.co.mashup.mapc.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@ToString
@Table(name = "info_type")
public class InformationType {
}
