package com.entity;


import java.util.List;
import java.util.Map;

public interface UserMapper {

    User getUserById();

    List<Map> selectUser();
}
