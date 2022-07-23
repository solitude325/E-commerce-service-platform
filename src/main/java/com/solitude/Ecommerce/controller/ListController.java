package com.solitude.Ecommerce.controller;

import com.solitude.Ecommerce.common.R;
import com.solitude.Ecommerce.entity.Sales;
import com.solitude.Ecommerce.mapper.ListMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
@Slf4j
public class ListController {

    @Autowired
    private ListMapper listMapper;

    @GetMapping("/list")
    public R<List<Sales>> list(){
        log.info("To List");
        List<Sales> sales = listMapper.listAll();
        return R.success(sales);
    }
}
