package com.zeze.board_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeze.board_back.dto.request.board.PostBoardRequsetDto;
import com.zeze.board_back.dto.request.board.PostCommentRequestDto;
import com.zeze.board_back.dto.response.board.DeleteBoardResponseDto;
import com.zeze.board_back.dto.response.board.GetBoardRespnoseDto;
import com.zeze.board_back.dto.response.board.GetCommentListResponseDto;
import com.zeze.board_back.dto.response.board.GetFavoriteListRespnseDto;
import com.zeze.board_back.dto.response.board.IncreaseViewCountResponseDto;
import com.zeze.board_back.dto.response.board.PostBoardResponseDto;
import com.zeze.board_back.dto.response.board.PostCommentResponseDto;
import com.zeze.board_back.dto.response.board.PutFavoriteResponseDto;
import com.zeze.board_back.service.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/board")
@RequiredArgsConstructor

public class BoardController {
    
    private final BoardService boardService;

    // 게시물 조회
    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetBoardRespnoseDto> getBoard(
        @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super GetBoardRespnoseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    // 좋아요 리스트
    @GetMapping("/{boardNumber}/favorite-list")
    public ResponseEntity<? super GetFavoriteListRespnseDto> getFavoriteList(
        @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super GetFavoriteListRespnseDto> response = boardService.getFavoriteList(boardNumber);
        return response;
    }

    // 댓글 리스트
    @GetMapping("/{boardNumber}/comment-list")
    public ResponseEntity<? super GetCommentListResponseDto> getCommentList(
        @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super GetCommentListResponseDto> response = boardService.getCommentList(boardNumber);
        return response;
    }

    // 조회수 1증가
    @GetMapping("/{boardNumber}/increase-view-count")
    public ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount (
        @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super IncreaseViewCountResponseDto> response = boardService.increaseViewCount(boardNumber);
        return response;
    }

    // 게시물 작성
    @PostMapping("")
    public ResponseEntity<? super PostBoardResponseDto> postBoard(
        @RequestBody @Valid PostBoardRequsetDto requestBody,
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super PostBoardResponseDto> response = boardService.postBoard(requestBody, email);
        return response;
    }

    // 댓글 작성
    @PostMapping("/{boardNumber}/comment")
    public ResponseEntity<? super PostCommentResponseDto> postComment (
        @RequestBody @Valid PostCommentRequestDto requestBody,
        @PathVariable("boardNumber") Integer boardNumber,
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super PostCommentResponseDto> response = boardService.postComment(requestBody, boardNumber, email);
        return response;
    }

    // 좋아요 기능
    @PutMapping("/{boardNumber}/favorite")
    public ResponseEntity<? super PutFavoriteResponseDto> putFavorite (
        @PathVariable("boardNumber") Integer boardNumber,
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super PutFavoriteResponseDto> response = boardService.putFavorite(boardNumber, email);
        return response;
    }

    // 게시물 삭제
    @DeleteMapping("/{boardNumber}")
    public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(
        @PathVariable("boardNumber") Integer boardNumber,
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super DeleteBoardResponseDto> response = boardService.deleteBoard(boardNumber, email);
        return response;
    }

}
