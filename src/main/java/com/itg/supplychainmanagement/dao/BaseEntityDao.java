package com.itg.supplychainmanagement.dao;

import com.itg.supplychainmanagement.model.BaseEntity;

public interface BaseEntityDao {
    int save(BaseEntity baseEntity, String userType);
}
