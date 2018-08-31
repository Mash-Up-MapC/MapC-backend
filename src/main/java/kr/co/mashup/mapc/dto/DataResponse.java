package kr.co.mashup.mapc.dto;

import lombok.Data;

import java.util.List;

@Data //TODO @Data 탐구
public class DataResponse<T> {
    private T Result;
    private List<T> Results;
}
