package com.kh.board.domain.reply.dao;

import com.kh.board.domain.entity.Reply;

import java.util.List;

public interface ReplyDAO {

  // 댓글 등록
  Long rpSave(Reply reply);

  // 댓글 목록
  List<Reply> findAll();

  // 댓글 수정
  public int updateByEmail(Long replyId, Reply reply);

  // 댓글 삭제
  int deleteById(Long userId, Long replyId);

  // 총 레코드 건수
  int totalCnt();
}
