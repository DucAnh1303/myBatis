package mybatis.example.springbootdemomybatis.controllr;

import mybatis.example.springbootdemomybatis.repository.UsersMapper;
import mybatis.example.springbootdemomybatis.model.Users;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MybatisController {
    private UsersMapper usersMapper;

    public MybatisController(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @GetMapping("/all")
    public List<Users> getAll() {
        return usersMapper.findAll();
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody Users users) {
        Users usersList = new Users();
        usersList.setName(users.getName());
        usersList.setAge(users.getAge());
        usersList.setAddress(users.getAddress());
        usersMapper.insert(usersList);
        return "SUCCESS";
    }

    @PostMapping("/update")
    public List<Users> update(@RequestBody Users users) {
        users.setId(users.getId());
        users.setName(users.getName());
        users.setAge(users.getAge());
        users.setAddress(users.getAddress());
        usersMapper.update(users);
        return usersMapper.findAll();
    }

    @PostMapping("/delete")
    public List<Users> deleteUser(@RequestParam("id") int id) {
        usersMapper.delete(id);
        return usersMapper.findAll();
    }


}
