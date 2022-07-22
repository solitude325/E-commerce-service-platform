package com.solitude.Ecommerce.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.solitude.Ecommerce.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
