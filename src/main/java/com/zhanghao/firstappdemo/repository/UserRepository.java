package com.zhanghao.firstappdemo.repository;

import com.zhanghao.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用Java doc 的表达方式
 * {@link User} {@link Repository}
 */


//使用领域驱动的方式，标注组件。
@Repository
public class UserRepository {

    /**
     * 采用内存型的存储方式 -> Map
     */
    private final  ConcurrentMap<Integer,User>  repository
            = new ConcurrentHashMap<>();

    /**
     * Id 是自增长的，创建一个id生成器
     */
    private final static AtomicInteger idGenerator =
            new AtomicInteger();

    /**
     * 保存用户对象
     * @param user {@link User} 对象
     * @return 如果保存成功，返回<code>true</code>
     *          否则，返回<code>false</code>
     */
    public boolean save(User user) {
        //ID从1开始。
        Integer id=idGenerator.incrementAndGet();
        //设置id
        user.setId(id);
        return repository.put(id, user) == null;
    }

}

