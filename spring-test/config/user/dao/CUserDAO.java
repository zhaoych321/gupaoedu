package config.user.dao;

import config.user.domain.CUser;
import config.user.domain.CUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CUserDAO {
    long countByExample(CUserExample example);

    int delete(CUserExample example);

    int delete(int userId);

    int insert(CUser record);

    int insertSelective(CUser record);

    List<CUser> selectWithBLOBs(CUserExample example);

    List<CUser> select(CUserExample example);

    CUser select(int userId);

    int updateSelective(@Param("record") CUser record, @Param("example") CUserExample example);

    int updateWithBLOBs(@Param("record") CUser record, @Param("example") CUserExample example);

    int updateByExample(@Param("record") CUser record, @Param("example") CUserExample example);

    int updateSelective(CUser record);

    int update(CUser record);

    int update(CUser record);
}