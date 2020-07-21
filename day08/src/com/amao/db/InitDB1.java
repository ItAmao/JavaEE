package com.amao.db;

import com.amao.domain.Book;
import com.amao.domain.Book1;

import java.util.HashMap;
import java.util.Map;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/20 19:59
 */
public class InitDB1 {

    private static Map<String, Book1> map = new HashMap<>();

    static {
        map.put("1", new Book1("1", "红楼梦", "曹雪芹", 50d, null));
        map.put("2", new Book1("2", "西游记", "吴承恩", 60d, null));
        map.put("3", new Book1("3", "三国演义", "罗贯中", 50d, null));
        map.put("4", new Book1("4", "水浒传", "施耐庵", 50d, null));
    }

    //写一个方法,提供用户使用
    public static Book1 getBookById(String key) {
        return map.get(key);
    }
}
