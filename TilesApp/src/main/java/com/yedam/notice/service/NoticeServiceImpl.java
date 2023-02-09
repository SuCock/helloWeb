package com.yedam.notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.notice.mapper.NoticeMapper;
import com.yedam.notice.vo.NoticeVO;
import com.yedam.notice.vo.ReplyVO;

public class NoticeServiceImpl implements NoticeService {
	SqlSession session = DataSource.getInstance().openSession(true);
	NoticeMapper mapper = session.getMapper(NoticeMapper.class);
	// NoticeService service = new NoticeServiceImpl();
	// session.selectOne("com.yedam.notice.mapper.NoticeMapper.getNoticeId") ->
	// NoticeMapper mapper = session.getMapper(NoticeMapper.class); 메소드만 호출해도 기능이
	// 실행되도록.

	@Override
	public List<NoticeVO> noticeList() {
		return mapper.selectList();
	}

	@Override
	public NoticeVO getNotice(int nid) {
		mapper.increaseCnt(nid); // 카운트증가.
		return mapper.searchOne(nid);
	}

	@Override
	public int addNotice(NoticeVO notice) {
		return mapper.insertNotice(notice);
	}

	@Override
	public int modNotice(NoticeVO notice) {
		return mapper.updateNotice(notice);
	}

	@Override
	public int remNotice(int nid) {
		return mapper.deleteNotice(nid);
	}

	@Override
	public List<ReplyVO> replyList(int nid) {
		return mapper.replyList(nid);
	}

	@Override
	public int removeReply(int rid) {
		// TODO Auto-generated method stub
		return mapper.deleteReply(rid);
	}

	@Override
	public int addReply(ReplyVO reply) {
		// TODO Auto-generated method stub
		return mapper.insertReply(reply);
	}

}
