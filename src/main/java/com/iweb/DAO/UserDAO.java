package com.iweb.DAO;

import com.iweb.pojo.User;


/**
 * @author Caesar
 * @date 2022 08 2022/8/12 17:56
 * @description 类的描述与介绍
 */

public interface UserDAO {
    /**
     * 用户验证登录
     * @param user 包含用户密码和登录信息
     * @return 返回的布尔值代表验证的情况
     */
    boolean login(User user);
}
