package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.utils.DataUtils;
import org.apache.commons.beanutils.BeanUtils;

import java.util.List;

public class UserDao {
    // 用户的查询
    public List<User> find() {
        // 获取数据 readAll
        List<User> list = DataUtils.readAll();
        return list;
    }

    // 用户添加
    public void add(User user) {
        // 查询文档中的数据 list
        List<User> list = DataUtils.readAll();
        // 将最新添加的用户数据给list集合
        list.add(user); //5
        // 将最新的list集合写入文档中
        DataUtils.writeAll(list);
    }

    //用户删除
    public void delete(String id) {
        DataUtils dataUtil = new DataUtils();
        // 获取文档所有数据  list<User>
        List<User> list = dataUtil.readAll();
        // 遍历循环list 循环中使用传递的id和每个user的getId()做对比
        for (User user : list) {
            if (id.equalsIgnoreCase(user.getId())) {
                // 一致：把当前的这个user从list集合中删除
                list.remove(user);
                break; //结束跳出循环
            }
        }
        dataUtil.writeAll(list);

    }

    // 用户修改上集--数据回显
    public User findById(String id) {

        User returnUser = null;

        // 获取到文本中的数据  list<User>
        List<User> list = DataUtils.readAll();
        // 遍历循环list 获取每一个user
        for (User user : list) {
            // 判断传递的用户id和每一个user的id对比
            if (id.equalsIgnoreCase(user.getId())) {
                returnUser = user;
            }
        }
        // 一致：返回该User实体
        return returnUser;
    }

    // 用户修改下集--数据修改
    public void update(User user) {
        try {

            // 获取所有数据 List<User>
            List<User> list = DataUtils.readAll();
            // 遍历list循环每一个user
            for (User old_user : list) {
                // 将页面user的id和list的user的id做对比
                if (user.getId().equalsIgnoreCase(old_user.getId())) {
                    // 一致：将页面user的属性覆盖list的user属性
                    BeanUtils.copyProperties(old_user, user);
                }
            }
            //将最新数据的list集合重新写入（覆盖）
            DataUtils.writeAll(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
