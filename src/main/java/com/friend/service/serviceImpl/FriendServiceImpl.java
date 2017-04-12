package com.friend.service.serviceImpl;

import com.friend.mapper.FriendMapper;
import com.friend.po.Friend;
import com.friend.service.FriendService;
import com.friend.vo.SpanVo;
import com.self.po.User;
import com.self.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
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
