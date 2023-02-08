package com.yedam.notice.mapper;

import java.util.List;

import com.yedam.notice.vo.NoticeVO;


public interface NoticeMapper {
	public List<NoticeVO> selectList();
	public NoticeVO searchOne(int nid);
	public int insertNotice(NoticeVO notice);
	public int updateNotice(NoticeVO notice);
	public int deleteNotice(int nid);
	public int increaseCnt(int nid); // 조회수증가.
	// 댓글등록.
	// 댓글목록.
}
