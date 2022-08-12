package com.iweb.DAO;

import lombok.Data;

/**
 * @author Caesar
 * @date 2022 08 2022/8/12 17:56
 * @description 类的描述与介绍
 */

public interface UserDAO {
    boolean login(String username,String password);
}
