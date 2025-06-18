package com.mingzzi.memo.entity;

import com.mingzzi.memo.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Memo {
    private Long id;
    private String username;
    private String contents;

    // client 에서 받아온 dto를 가지고 데이터를 넣어준다.
    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    // 만약 Lombok을 안썼더라면 아래와 같이 모두 사용해줘야
    // Getter
    //    public Long getId() {
    //        return id;
    //    }
    //
    //    public String getUsername() {
    //        return username;
    //    }
    //
    //    public String getContents() {
    //        return contents;
    //    }
    //
    // Setter
    //    public void setId(Long id) {
    //        this.id = id;
    //    }
    //
    //    public void setUsername(String username) {
    //        this.username = username;
    //    }
    //
    //    public void setContents(String contents) {
    //        this.contents = contents;
    //    }
}