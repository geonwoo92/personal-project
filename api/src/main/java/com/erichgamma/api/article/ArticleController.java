package com.erichgamma.api.article;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erichgamma.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
public class ArticleController {
    private final ArticleServiceImpl service;
    private final ArticleRepository repo;

    @SuppressWarnings("unchecked")
    @GetMapping("/api/all-articles")
    public Map <?,?> findAll() throws SQLException {
        Map<String, Object> map = new HashMap<>();
        map.put("message",Messenger.SUCCESS);
        List<Article> list = new ArrayList<>();
        list = service.findAll();
        list.forEach(System.out::println);
        System.out.println("리스트 사이즈 : 12"+list.size());
        map.put("result",list);
        return map;
    }
}
//        return Map.of(
//                "message", Messenger.SUCCESS,
//                "articles", Article.builder()
//                        .id((long)0)
//                        .title("test title")
//                        .content("test content")
//                        .registerDate("test registerDate")
//                        .build()
//        );

