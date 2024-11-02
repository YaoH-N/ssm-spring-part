package com.atguigu.service;

import com.atguigu.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Transactional
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * 添加事务：
     *
     * @Transactional 位置： 方法 | 类上
     * 方法： 当前方法有事务
     * 类上： 类下的所有方法都有事务
     * 查询方法可以通过再次添加注解，设置为只读模式，提高效率！
     * <p>
     * 1. 只读模式
     * 只读模式可以提升查询事务的效率！ 推荐事务中只有查询代码，使用只读模式
     * 默认：boolean readOnly() default false;
     * <p>
     * 2. 超时时间
     * 默认：永不超时 -1
     * 设置：timeout = 时间 秒数 超过时间，就会回滚事务和释放异常
     * 如果类上设置事务属性，方法也设置了事务注解！方法会不会生效？
     * 不会生效：方法的注解覆盖率了类上的注解
     * <p>
     * 3. 指定异常回滚和指定异常不回滚     *      默认情况下，指定发生运行时异常的事务才会回滚！
     * 我们可以指定Exception异常来控制所有的异常都回滚
     * rollbackFor = Exception.class
     * noRollbackFor = 回滚异常范围，控制某个异常不回滚
     * <p>
     * 4. 隔离级别设置
     * 推荐设置第二个隔离级别
     * isolation = Isolation.REAM_COMMITED
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class, noRollbackFor = FileNotFoundException.class, isolation = Isolation.READ_COMMITTED)
    public void changeInfo() throws FileNotFoundException {
        studentDao.updateAgeById(33, 1);
        new FileInputStream("xxxx");
        studentDao.updateNameById("test3", 1);
    }

    @Transactional(readOnly = true) // 查询可以设置为只读模式
    public void getStudentInfo() {
        // 获取学生信息 查询数据库 不修改
    }
}
