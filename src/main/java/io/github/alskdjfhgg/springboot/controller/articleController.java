package io.github.alskdjfhgg.springboot.controller;

import io.github.alskdjfhgg.springboot.pojo.Result;
import io.github.alskdjfhgg.springboot.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class articleController {

    @PostMapping("/list")
    public Result<String> list() {
        return Result.success("all article......");
    }
}
