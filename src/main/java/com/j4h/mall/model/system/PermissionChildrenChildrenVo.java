package com.j4h.mall.model.system;

/**
 * 返回的systemPermission里最小的单位
 * @author sld
 * @version 1.0
 * @date 2019/10/4 19:56
 */
public class PermissionChildrenChildrenVo {

    /**
     * id : admin:collect:list
     * label : 查询
     * api : GET /admin/collect/list
     */
    private String id;
    private String label;
    private String api;

    public void setId(String id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getApi() {
        return api;
    }
}
