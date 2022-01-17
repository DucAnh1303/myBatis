package mybatis.example.springbootdemomybatis;

import mybatis.example.springbootdemomybatis.model.Users;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(Users.class)
@SpringBootApplication
public class SpringBootDemoMybatisApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoMybatisApplication.class, args);
	}

}
