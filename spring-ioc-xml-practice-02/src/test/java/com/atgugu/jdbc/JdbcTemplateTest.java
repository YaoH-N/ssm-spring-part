package com.atgugu.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.controller.StudentController;
import com.atguigu.pojo.Student;
import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: 牛耀辉
 * @createTime: 2024/7/21 21:41
 * @description: 测试javaTemplate如何使用
 */
public class JdbcTemplateTest {

    public void testForJava() {

        /**
         * JdbcTemplate 简化数据库的crud 但是不提供连接池
         *      |
         * DruidDataSource  连接池 -> 负责连接的创建和数据库驱动的注册等
         */

        //0. 创建一个连接池对象
        DruidDataSource druidDataSource = new DruidDataSource();
        // 设置必须设置的属性
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/atguigu");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");

        //1. 实例化对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(druidDataSource);

        //2. 调用方法
        // jdbcTemplate.update() DDL、DML、DCL ... 给查询语句
        // jdbcTemplate.queryForObject()   DQL 查询单个对象
        // jdbcTemplate.query()    DQL 查询集合
    }

    /**
     * 通过ioc容器读取配置的JdbcTemplate组件
     */
    @Test
    public void testForIoc() {
        //1. 创建ioc容器对象
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        //2. 获取jdbcTemplate组件
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);

        //3. 进行数据库的crud操作
        //3.1 插入 删除 和 修改 DML update
        String sql = "INSERT INTO students(id,name,gender,age,class) VALUES(?,?,?,?,?)";

        /**
         * 参数1：String sql 可以带占位符 ?  但是 ? 只能替代值，不能替代关键字和容器名
         * 参数2：Object ...param  传入占位符的值 顺序 从左开始对应
         * 返回值：int 受影响的行数
         */
        int rows = jdbcTemplate.update(sql, 9, "二狗子", "男", 18, "三年级二班");
        System.out.println(rows);

        //3.2 查询单条数据 根据id查询学生数据，返回一个对应的实体对象
        /**
         * 参数1：String sql 可以带占位符 ?  但是 ? 只能替代值，不能替代关键字和容器名
         * 参数2：RowMapper  列名和属性名的映射器接口
         * 参数3：Object ...param  传入占位符的值 顺序 从左开始对应
         * 返回值：RowMapper 指定的对象
         */
        sql = "SELECT * FROM students where id = ?";

        // 常规写法，匿名内部类
        /*jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                //rs 代表结果集
                //rowNum 行数
                //rs结果集中获取列的值 赋值给实体类对象即可
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                student.setClasses(rs.getString("class"));
                return student;
            }
        }, 1);*/

        // 简化写法，用Lambda表达式将几名内部类简写
        Student student1 = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            //rs 代表结果集
            //rowNum 行数
            //rs结果集中获取列的值 赋值给实体类对象即可
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setGender(rs.getString("gender"));
            student.setAge(rs.getInt("age"));
            student.setClasses(rs.getString("class"));
            return student;
        }, 1);
        System.out.println(student1);

        //3.3 查询所有学生数据
        sql = "SELECT id, name, gender, age, class as classes FROM students";
        //TODO: BeanPropertyRowMapper帮助我们自动映射列和属性值！要求列名和属性名一致！ 不一致 就 起别名！
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println(studentList);
    }

    /**
     * 从ioc容器中获取controller并且调用业务！ 内部都是ioc容器进行组装
     */
    @Test
    public void testQueryAll() {
        //1. 创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        //2. 获取组件对象
        StudentController studentController = applicationContext.getBean(StudentController.class);
        //3. 使用组件对象
        studentController.findAll();
        //4. 关闭容器
        applicationContext.close();
    }

}
