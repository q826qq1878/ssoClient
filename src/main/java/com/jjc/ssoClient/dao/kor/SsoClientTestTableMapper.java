package com.jjc.ssoClient.dao.kor;


import com.jjc.ssoClient.po.SsoClientTestTable;

import java.util.List;

public interface SsoClientTestTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SsoClientTestTable record);

    int insertSelective(SsoClientTestTable record);

    SsoClientTestTable selectByPrimaryKey(Integer id);

    List<SsoClientTestTable> selectAll();


    int updateByPrimaryKeySelective(SsoClientTestTable record);

    int updateByPrimaryKey(SsoClientTestTable record);
}