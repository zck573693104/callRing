package com.callRing.friend.service.serviceImpl;

import com.callRing.friend.mapper.FriendMapper;
import com.callRing.friend.po.Friend;
import com.callRing.friend.service.FriendService;
import com.callRing.friend.vo.SpanVo;
import com.callRing.self.po.User;
import com.callRing.self.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendMapper friendMapper;

	public List<Friend>  queryOftenChatFriend(User user) throws Exception {
		
		return friendMapper.queryOftenChatFriend(user);
		
	}
	@Override
	public List<User> addFriend(UserPo userPo) throws Exception {
		return friendMapper.addFriend(userPo);
	}
	@Override
	public void becomeFriend(Friend friend) throws Exception {
		friendMapper.becomeFriend(friend);
		
	}

	@Override
	public List<SpanVo> selectFriendLogDay(String userName) throws Exception {
		return friendMapper.selectFriendLogDay(userName);
	}

	public void becomeFriend() {
	}
}
