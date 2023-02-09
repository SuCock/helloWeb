package com.yedam.notice.mapper;

import java.util.List;

import com.yedam.notice.vo.NoticeVO;
import com.yedam.notice.vo.ReplyVO;


public interface NoticeMapper {
	public List<NoticeVO> selectList();
	public NoticeVO searchOne(int nid);
	public int insertNotice(NoticeVO notice);
	public int updateNotice(NoticeVO notice);
	public int deleteNotice(int nid);
	public int increaseCnt(int nid); // 조회수증가.
	// 댓글목록.
	public List<ReplyVO> replyList(int nid);
	// 댓글삭제.
	public int deleteReply(int rid); // 댓글아이디를 매개값으로 받는다.
	// 댓글등록.
	public int insertReply(ReplyVO reply);
}
