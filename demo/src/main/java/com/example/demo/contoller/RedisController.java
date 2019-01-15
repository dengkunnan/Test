package com.example.demo.contoller;

import com.example.demo.pojo.JsonObjService;
import com.example.demo.pojo.User;
import com.example.demo.unit.JsonUtils;
import com.example.demo.unit.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisOperator redisOperator;
    @RequestMapping("/test")
    public JsonObjService test() {
        stringRedisTemplate.opsForValue().set("redis-cache", "My Frist Redis Cache");
        return JsonObjService.ok(stringRedisTemplate.opsForValue().get("redis-cache"));
    }

    @RequestMapping("/redisjson")
    public JsonObjService redisjsontest() {
        User user = new User();
        user.setDesc("test1");
        user.setAge("1");
        user.setName("name1");
        user.setPassword("pas1");
        stringRedisTemplate.opsForValue().set("json.user", JsonUtils.objectToJson(user));
        User user1 =JsonUtils.jsonToPojo(stringRedisTemplate.opsForValue().get("json.user"), User.class);
        return JsonObjService.ok(user1);
    }

    @RequestMapping("/getJsonList")
    public JsonObjService getJsonList() {

        User user = new User();
        user.setAge("18");
        user.setName("慕课网");
        user.setPassword("123456");
        user.setBirthday(new Date());

        User u1 = new User();
        u1.setAge("19");
        u1.setName("imooc");
        u1.setPassword("123456");
        u1.setBirthday(new Date());

        User u2 = new User();
        u2.setAge("17");
        u2.setName("hello imooc");
        u2.setPassword("123456");
        u2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);
        userList.add(u2);

        redisOperator.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);

        String userListJson = redisOperator.get("json:info:userlist");
        List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);

        return JsonObjService.ok(userListBorn);
    }

}
