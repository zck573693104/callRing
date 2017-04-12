package com.friend.service;

import com.friend.po.Friend;
import com.friend.vo.SpanVo;
import com.self.po.User;
import com.self.po.UserPo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface FriendService {

	List<Friend>  queryOftenChatFriend(User user)throws Exception;

	List<User> addFriend(UserPo userPo)throws Exception;

	void becomeFriend(Friend friend)throws Exception;

	List<SpanVo>selectFriendLogDay(String userName)throws Exception;
}
