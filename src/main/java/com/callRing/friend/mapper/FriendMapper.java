package com.callRing.friend.mapper;

import com.callRing.friend.po.Friend;
import com.callRing.friend.vo.SpanVo;
import com.callRing.self.po.User;
import com.callRing.self.po.UserPo;

import java.util.List;

public interface FriendMapper {

	List<Friend> queryOftenChatFriend(User user);

	List<User> addFriend(UserPo userPo);

	void becomeFriend(Friend friend);

	List<SpanVo>selectFriendLogDay(String userName);
}
