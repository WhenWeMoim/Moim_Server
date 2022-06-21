package com.example.demo.src.moim;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.moim.model.*;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moims")
public class MoimController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final MoimProvider moimProvider;
    @Autowired
    private final MoimService moimService;
    @Autowired
    private final JwtService jwtService;


    public MoimController(MoimProvider moimProvider, MoimService moimService, JwtService jwtService){
        this.moimProvider = moimProvider;
        this.moimService = moimService;
        this.jwtService = jwtService;
    }

    //테스트를 위한 유저 추가 API


    //Moims 조회 API
    @ResponseBody
    @GetMapping("/moims/{userIdx}")
    public BaseResponse<GetUserMoimsRes> getUserMoims(@PathVariable("userIdx") int userIdx) {
        try{
            GetUserMoimsRes getUserMoimsRes = moimProvider.getUserMoimsByUserIdx(userIdx);
            return new BaseResponse<>(getUserMoimsRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    //Moim 생성 API


    //Moim 조회 API



    //Personal schedule 추가 API



    /**
     * Moim 삭제 API
     */

    /**
     * 모임 참가 비밀번호 생성 API
     * MoimDate 테이블 데이터 마다 추가된 유저의 personalSchedule 테이블 데이터가 생긴다.
     */

    @ResponseBody
    @PatchMapping("/moims/{moimIdx}/password")
    public BaseResponse<String> updateMoimPassword(@PathVariable("moimIdx") int moimIdx) {
        try{
            String password = moimService.updateMoimPassword(moimIdx);
            return new BaseResponse<>(password);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }


}
