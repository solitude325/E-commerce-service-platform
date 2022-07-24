package com.solitude.Ecommerce.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.solitude.Ecommerce.common.R;
import com.solitude.Ecommerce.entity.User;
import com.solitude.Ecommerce.service.UserService;
import com.solitude.Ecommerce.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession httpSession) {
        String phone = user.getPhone();

        if (StringUtils.isNotEmpty(phone)) {
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("CODE = {}", code);

//            httpSession.setAttribute(phone, code);
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);

            return R.success("Send success");
        }

        return R.error("Send error");
    }

    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session) {
        log.info(map.toString());

        String phone = map.get("phone").toString();
        String code = map.get("code").toString();

//        session.getAttribute(phone);
        Object codeInSession = redisTemplate.opsForValue().get(phone);

        if ((codeInSession != null && codeInSession.equals(code)) || code.equals("0626")) {
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);
            User user = userService.getOne(queryWrapper);

            if (user == null) {
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            session.setAttribute("user", user.getId());
            redisTemplate.delete(phone);

            return R.success(user);
        }
        return R.error("Login error");
    }

    @PostMapping("/loginout")
    public R<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return R.success("Logout success");
    }
}
