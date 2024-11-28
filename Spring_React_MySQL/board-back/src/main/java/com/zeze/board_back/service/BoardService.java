package com.zeze.board_back.service;

import org.springframework.http.ResponseEntity;

import com.zeze.board_back.dto.request.board.PostBoardRequsetDto;
import com.zeze.board_back.dto.response.board.GetBoardRespnoseDto;
import com.zeze.board_back.dto.response.board.PostBoardResponseDto;
import com.zeze.board_back.dto.response.board.PutFavoriteResponseDto;

public interface BoardService {
    
    ResponseEntity<? super GetBoardRespnoseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequsetDto dto, String email);
    ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);

}