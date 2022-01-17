package mybatis.example.springbootdemomybatis.repository;

import mybatis.example.springbootdemomybatis.model.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UsersMapper {

    @Select("select * from user")
    List<Users> findAll();

    @Insert("insert into user(name,age,address) values(#{name},#{age},#{address})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void insert(Users users);

    @Update("update user set name=#{name}, age=#{age}, address=#{address} where id=#{id}")
    void update(Users users);

    @Delete("delete from user where id=#{id}")
    void delete(int id);
}
