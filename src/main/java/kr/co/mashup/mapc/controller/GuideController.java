package kr.co.mashup.mapc.controller;

import kr.co.mashup.mapc.dto.CourseDto;
import kr.co.mashup.mapc.dto.StationDto;
import kr.co.mashup.mapc.service.GuideService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(value = "/guide", produces = "application/json")
public class GuideController {

    GuideService guideService;
    /**
     * uuid 는 mapc 에서 Token 과도 같은 위치이다.
     * 이 값을 헤더에 싫어서 보내야 하는데, 음.. 일단 QueryString 으로 보내고, 추후 변경하자.
     *
     * id 값의 booking 테이블에 당일에 예약이 있으면 success, 아니면 fail
     * pathVariable 을 쓸 수 없는데, 클라이언트에서 userId 값을 가지고 있지 않다.. 그냥 일단 이대로..
     *
     * Rest - Get 이 맞을까/?
     */
    @GetMapping(path = "/validation")
    public Map<String, Boolean> checkValidation(@RequestParam(name = "uuid") String uuid) {
        Map<String, Boolean> res = new HashMap<>();
        res.put("isRight", guideService.checkValidation(uuid));
        return res;
    }

    //TODO 일단 요청하면 코스 1 정보만 내리기.
    @GetMapping(path = "/info")
    public StationDto.ResGuideStation getGuideBasicInfo() {
        return guideService.getBasicInfo();
    }

    @GetMapping(path = "/info/enjoyment")
    public void getGuideEnjoymentInfo() {
        return ;
    }
}
