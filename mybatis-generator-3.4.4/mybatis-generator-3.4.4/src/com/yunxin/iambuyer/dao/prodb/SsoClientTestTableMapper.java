package com.yunxin.iambuyer.dao.prodb;

import com.yunxin.po.prodb.SsoClientTestTable;

public interface SsoClientTestTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SsoClientTestTable record);

    int insertSelective(SsoClientTestTable record);

    SsoClientTestTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SsoClientTestTable record);

    int updateByPrimaryKey(SsoClientTestTable record);
}