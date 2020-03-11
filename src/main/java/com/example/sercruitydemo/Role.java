package com.example.sercruitydemo;

import lombok.Data;

/**
 * Model：
 * Description：
 * Author: 赖允翔
 * created：2020/3/11 8:43
 */
@Data
public class Role {
    private long id;
    private String name;

    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
