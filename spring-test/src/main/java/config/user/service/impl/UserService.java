package config.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import config.user.dao.CUserDAO;
import config.user.domain.CUser;
import config.user.domain.CUserExample;
import config.user.domain.CUserExample.Criteria;
import config.user.service.IUserService;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	CUserDAO cUserDao;

	public void doPrint() {
		System.out.println("ppppppppppppppppppppp");
		CUserExample ex = new CUserExample();
		Criteria ca = ex.createCriteria();
		ca.andNameEqualTo("aa");
		
		
	}
	
	

	@Override
	public void getAndPrint(int userId) {
		CUser user = cUserDao.selectByPrimaryKey(userId);
		System.out.println(user.toString());

	}

	@Override
	public void doUpdateUserName(int userId) {
		CUser user = cUserDao.selectByPrimaryKey(userId);
		user.setName("ergou");
		cUserDao.updateByPrimaryKey(user);
		doPrint();
	}

	@Override
	public void doCreateUser() {
		CUser user = new CUser();
		user.setUserId(1);
		user.setName("二狗");
		user.setBiLogJson("");
		user.setComment("");
		user.setCreatedAt(0);
		user.setExp(0);
		user.setHasReleasedArousal(false);
		user.setHasReleasedGuild(false);
		user.setHasReleasedInherit(false);
		user.setHasReleasedLeague(false);
		user.setHasReleasedPowerUp(false);
		user.setHasReleasedPvp(false);
		user.setLanguageCode((byte) 0);
		user.setPvpGradeId(0);
		user.setPvpGradeIdUpdatedAt(0);
		user.setPvpStandardGradeId(0);
		user.setPvpStandardGradeIdUpdatedAt(0);
		user.setTeamName("");
		user.setTotalPayAmount(0);
		user.setTutorialPhase((byte) 0);
		user.setUpdatedAt(0);
		cUserDao.insert(user);

	}



	public void doTake() {
		// TODO Auto-generated method stub
		System.out.println("do..... ttttttttttttttttake");
	}

}
