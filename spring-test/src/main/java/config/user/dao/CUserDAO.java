package config.user.dao;

import config.user.domain.CUser;
import org.springframework.stereotype.Repository;

@Repository
public interface CUserDAO {
    int deleteByPrimaryKey(int userId);

    int insert(CUser record);

    int insertSelective(CUser record);

    CUser selectByPrimaryKey(int userId);

    int updateByPrimaryKeySelective(CUser record);

    int updateByPrimaryKeyWithBLOBs(CUser record);

    int updateByPrimaryKey(CUser record);
}