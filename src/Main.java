import com.entity.User;
import com.entity.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream("mybatis-config.xml"));
            try (SqlSession session = sqlSessionFactory.openSession(true)) {
                UserMapper mapper = session.getMapper(UserMapper.class);
//                List<User> list = mapper.selectUser();
                mapper.insertUser(new User("小张", 12));
                session.commit();
                session.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
