package com.woniu.bean;

import com.woniu.pojo.Role;

public class RoleBean {
    private Role role;
    private String checked="";//该属性主要作用于前端复选框勾选

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}
