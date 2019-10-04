package com.j4h.mall.model.system;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/4 19:59
 */
public class PermissionChildrenVo {
    String id;
    String label;
    List<PermissionChildrenChildrenVo> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<PermissionChildrenChildrenVo> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionChildrenChildrenVo> children) {
        this.children = children;
    }
}
