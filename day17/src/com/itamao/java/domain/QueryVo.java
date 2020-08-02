package com.itamao.java.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * query 查询 vo 实体类
 * 专门用于 封装数据库查询条件的对象
 */
public class QueryVo {
    private List<Integer> idsList;
    private  Integer [] idsArray;
    //定义很多属性 都用于查询

    public List<Integer> getIdsList() {
        return idsList;
    }

    public void setIdsList(List<Integer> idsList) {
        this.idsList = idsList;
    }

    public Integer[] getIdsArray() {
        return idsArray;
    }

    public void setIdsArray(Integer[] idsArray) {
        this.idsArray = idsArray;
    }
}
