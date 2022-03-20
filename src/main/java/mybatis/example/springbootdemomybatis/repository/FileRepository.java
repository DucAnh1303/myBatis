package mybatis.example.springbootdemomybatis.repository;

import mybatis.example.springbootdemomybatis.model.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileRepository {

    @Insert("insert into file(name, type, data ) values (#{name},#{type},#{data})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty = "id",
    before = false,resultType = Integer.class)
    File save(File file);

    @Select("select * from file where id =#{id}")
    File getOne(@Param("id")int id);
}
