package com.solitude.Ecommerce.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.solitude.Ecommerce.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
