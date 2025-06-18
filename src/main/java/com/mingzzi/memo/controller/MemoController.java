package com.mingzzi.memo.controller;

import com.mingzzi.memo.dto.MemoRequestDto;
import com.mingzzi.memo.dto.MemoResponseDto;
import com.mingzzi.memo.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MemoController {

    // Long 에는 ID 값이 들어간다.
    private final Map<Long, Memo> memoList = new HashMap<>();

    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto){
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);

        // Memo Max ID Check (중복된 ID를 사용하면 안되기 때문)
        // memoList에 값이 0 보다 크다면 가장 마지막 값에 + 1을 해서 중복되지 않도록 해준다.
        // 만약 값이 0과 같거나 작은경우 1을 반환한다.
        Long maxId = memoList.size() > 0 ? Collections.max(memoList.keySet()) + 1 : 1;
        memo.setId(maxId);

        // DB 저장
        memoList.put(memo.getId(), memo);

        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);

        return memoResponseDto;
    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos(){
        // Map to List
        // values로 memoList에 있는 값을 하나하나 꺼내오고, stream이 for 문 마냥 각 아이템(Memo)을 돌면서
        // MemoResponseDto 생성자로 변환을 해준다. 그리고 그 변환된 값들을 모아서 배열로 만들어준다.
        List<MemoResponseDto> responseList = memoList.values().stream().map(MemoResponseDto::new).toList();

        return responseList;
    }
}
