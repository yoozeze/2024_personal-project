package com.zeze.board_back.dto.response.board;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.zeze.board_back.common.ResponseCode;
import com.zeze.board_back.common.ResponseMessage;
import com.zeze.board_back.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class PostBoardResponseDto extends ResponseDto{
    
    private PostBoardResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<PostBoardResponseDto> success() {
        PostBoardResponseDto result = new PostBoardResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 유저 존재 확인
    public static ResponseEntity<ResponseDto> noExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
    
}
