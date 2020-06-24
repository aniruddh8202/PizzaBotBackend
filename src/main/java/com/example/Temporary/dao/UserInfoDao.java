package com.example.Temporary.dao;

import com.example.Temporary.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo, Long> {
}
