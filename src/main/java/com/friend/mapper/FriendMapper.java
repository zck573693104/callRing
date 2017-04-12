package com.friend.mapper;

import com.friend.po.Friend;
import com.friend.vo.SpanVo;
import com.self.po.User;
import com.self.po.UserPo;

import java.util.List;

public interface FriendMapper {

	List<Friend> queryOftenChatFriend(User user);

	List<User> addFriend(UserPo userPo);

	void becomeFriend(Friend friend);

	List<SpanVo>selectFriendLogDay(String userName);
}
