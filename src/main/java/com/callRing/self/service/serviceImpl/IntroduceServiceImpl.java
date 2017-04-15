package com.callRing.self.service.serviceImpl;

import com.callRing.self.mapper.IntroduceMapper;
import com.callRing.self.po.Introduce;
import com.callRing.self.po.User;
import com.callRing.self.service.IntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kcz on 2016/5/20.
 */
@Service
@Transactional
public class IntroduceServiceImpl implements IntroduceService {

    @Autowired
    private IntroduceMapper introduceMapper;
   
    public Introduce queryIntroduce(User user) throws Exception {
        return  introduceMapper.queryIntroduce(user);
    }

	public void updateIntroduce(Introduce introduce) throws Exception {
		introduceMapper.updateIntroduce(introduce);
		
	}

	@Override
	public void insertIntroduce(Introduce introduce) throws Exception {
		introduceMapper.insertIntroduce(introduce);
		
	}

	@Override
	/**
	 * 自我介绍只允许一条 判断introduce表是否有用户名 如果没有则insert否则update
	 */
	public Boolean updateOrInsertIntroduce(User user) throws Exception {
		if (introduceMapper.updateOrInsertIntroduce(user)==null) {
			return false;
		}
		else {
			return true;
		}
		
	}
}
