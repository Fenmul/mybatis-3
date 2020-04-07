package com.fox.test;

import com.fox.dao.UserDao;
import com.fox.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
  private InputStream in;
  private SqlSession sqlSession;

  @Before
  public void init() throws Exception {
    in = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
    sqlSession = sqlSessionFactory.openSession();
  }

  @After
  public void destory() throws Exception {
    if (in != null) {
      in.close();
    }
    if (sqlSession != null) {
      sqlSession.close();
    }
  }

  /**
   * 使用 mybatis 调用接口查询 User 信息
   */
  @Test
  public void testSelectList(){
    UserDao mapper = sqlSession.getMapper(UserDao.class);
    List<User> users = mapper.selectList();

    for (User user : users) {
      System.out.println(user);
    }
  }
}
