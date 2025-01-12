package org.dromara.neutrinoproxy.server.controller.req.system;

import lombok.Data;

/**
 * 获取可用端口请求
 */
@Data
public class AvailablePortListReq {

    /**
     * licenseId
     */
    private Integer licenseId;
}
