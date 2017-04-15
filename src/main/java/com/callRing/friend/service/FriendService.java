package com.callRing.friend.service;

import com.callRing.friend.po.Friend;
import com.callRing.friend.vo.SpanVo;
import com.callRing.self.po.User;
import com.callRing.self.po.UserPo;

import java.util.List;


public interface FriendService {

	List<Friend>  queryOftenChatFriend(User user)throws Exception;

	List<User> addFriend(UserPo userPo)throws Exception;

	void becomeFriend(Friend friend)throws Exception;

	List<SpanVo>selectFriendLogDay(String userName)throws Exception;
}
