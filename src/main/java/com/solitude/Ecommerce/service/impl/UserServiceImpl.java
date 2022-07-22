package com.solitude.Ecommerce.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.solitude.Ecommerce.entity.User;
import com.solitude.Ecommerce.mapper.UserMapper;
import com.solitude.Ecommerce.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
