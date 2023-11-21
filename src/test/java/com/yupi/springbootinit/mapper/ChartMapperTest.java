package com.yupi.springbootinit.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChartMapperTest {

//    @Resource
//    private ChartMapper chartMapper;
//
//    @Test
//    void queryChartData() {
//
//        String chartId="1688112716385726466";
//        String querySql = String.format("select * from chart_%s",chartId);
//
//        List<Map<String,Object>> resultData= chartMapper.queryChartData(querySql);
//        System.out.println(resultData);
//
//        ThreadPoolExecutor executor = new ThreadPoolExecutor();
//    }
//
//    @Test
//    void createTable() {
//
//        String chartId="1688218422376157186";
//        Integer table = chartMapper.createTable(chartId);
//        System.out.println(table);
//
//    }
}