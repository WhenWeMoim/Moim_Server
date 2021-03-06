package com.example.demo.src.moim.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetMoimInfoRes {
    private MoimInfo moimInfo;
    private List<Integer> dates;
    private List<MoimPersonalSchedule> moimUserSchedules;
}
