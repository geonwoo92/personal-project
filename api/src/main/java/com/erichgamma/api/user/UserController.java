package com.erichgamma.api.user;

import java.sql.SQLException;
import java.util.*;

import com.erichgamma.api.enums.Messenger;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository repo;
    private final UserServiceImpl userservice;
    @SuppressWarnings("unchecked")
    @GetMapping("/api/all-users")
    public Map<?,?>findAll() throws SQLException {
        System.out.println("java 실행");
        Map<String,Object> map = new HashMap<>();
        map.put("message",Messenger.SUCCESS);
        List<User> list = new ArrayList<>();
        list = userservice.findAll();
        list.forEach(System.out::println);
        System.out.println("리스트 사이즈: "+ list.size());
        map.put("result",list);
        System.out.println("자바 실행 마무리");
        return map;
    }

    @PostMapping("/api/login")
    public Map<String, ?> longin(@RequestBody Map<?, ?> paramap) {
        Map<String, Messenger> map = new HashMap<>();
        User optUser = repo.findByUsername((String) paramap.get("username")).orElse(null);
        Long id = optUser.getId();
        String password = (String) paramap.get("password");
        String username = (String) paramap.get("username");

        if (optUser == null) {
            map.put("message", Messenger.FAIL);

        } else if (!optUser.getPassword().equals(password)) {
            map.put("message",Messenger.WRONG_PASSWORD);

        } else {
            map.put("message",Messenger.SUCCESS);
        }
        System.out.println("ID is " + optUser);
        return map;
    }
    @PostMapping(path = "/api/join")
    public Map<String, ?> join(@RequestBody Map<?, ?> paramap) {

        String strHeight = String.valueOf(paramap.get("height"));
        String strWeight = String.valueOf(paramap.get("weight"));

        User newUser = repo.save(User.builder().
                username((String) paramap.get("username")).
                password((String) paramap.get("password")).
                name((String) paramap.get("name")).
                phone((String) paramap.get("phone")).
                job((String) paramap.get("job")).
                height(Double.parseDouble(strHeight)).
                weight(Double.parseDouble(strWeight)).
                build());
        System.out.println("DB 에 저장된 user 정보:" + newUser);
        Map<String, Messenger> map = new HashMap<>();
        map.put("result", Messenger.SUCCESS);
        return map;
    }
}
