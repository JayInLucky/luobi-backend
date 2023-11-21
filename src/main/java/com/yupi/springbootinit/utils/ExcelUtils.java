package com.yupi.springbootinit.utils;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Excel 相关工具类
 */
@Slf4j
public class ExcelUtils {

    public static String excelToCsv(MultipartFile multipartFile)  {

        List<Map<Integer, String>> list = null;
        try {
            list = EasyExcel.read(multipartFile.getInputStream())
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet()
                    .headRowNumber(0)
                    .doReadSync();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //如果数据为空
        if (CollUtil.isEmpty(list)) {
            return "";
        }
        //转换为csv
        StringBuilder stringBuilder = new StringBuilder();

        //读取表头(第一行)  LinkedHashMap读取数据是线性的，保证了顺序。
        LinkedHashMap<Integer,String> headerMap = (LinkedHashMap<Integer, String>) list.get(0);
        // 过滤 为 null 的数据
        List<String> headerList=headerMap.values().stream().filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());
//        System.out.println(StringUtils.join(headerList,","));
        stringBuilder.append(StringUtils.join(headerList,",")).append("\n");

        //读取数据（读取完表头之后，从第一行开始读取）
        for (int i=1;i < list.size();i++){
            LinkedHashMap<Integer,String> dataMap = (LinkedHashMap<Integer, String>) list.get(i);
            List<String> dataList = dataMap.values().stream().filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());
            stringBuilder.append(StringUtils.join(dataList,",")).append("\n");
        }
        return stringBuilder.toString();
    }


}
