package com.mingzzi.memo.controller;

import com.mingzzi.memo.dto.MemoRequestDto;
import com.mingzzi.memo.dto.MemoResponseDto;
import com.mingzzi.memo.service.MemoService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemoController {
    // 제어 흐름 상황 : 강한결함 MemoController > MemoService > MemoRepository
    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        // Service
        return memoService.createMemo(requestDto);
    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        // Service
        return memoService.getMemos();
    }

    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        // Service
        return memoService.updateMemo(id, requestDto);
    }

    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        // Service
        return memoService.deleteMemo(id);
    }
}