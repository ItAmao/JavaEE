package com.amao.db;

import com.amao.domain.Book;

import java.util.HashMap;
import java.util.Map;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/20 19:59
 */
public class InitDB {

    private static Map<String, Book> map = new HashMap<>();

    static {
        map.put("1", new Book("1", "红楼梦", "曹雪芹", 50d));
        map.put("2", new Book("2", "西游记", "吴承恩", 60d));
        map.put("3", new Book("3", "三国演义", "罗贯中", 50d));
        map.put("4", new Book("4", "水浒传", "施耐庵", 50d));
    }

    //写一个方法,提供用户使用
    public static Book getBookById(String key) {
        return map.get(key);
    }
}
