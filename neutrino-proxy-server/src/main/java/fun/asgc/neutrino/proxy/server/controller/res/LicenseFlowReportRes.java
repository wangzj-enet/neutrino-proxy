/**
 * Copyright (c) 2022 aoshiguchen
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package fun.asgc.neutrino.proxy.server.controller.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: aoshiguchen
 * @date: 2022/12/21
 */
@Accessors(chain = true)
@Data
public class LicenseFlowReportRes {
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * licenseId
     */
    private Integer licenseId;
    /**
     * license名称
     */
    private String licenseName;
    /**
     * 上行流量字节数
     */
    private Long upFlowBytes;
    /**
     * 下行流量字节数
     */
    private Long downFlowBytes;
    /**
     * 总流量字节数
     */
    private Long totalFlowBytes;
    /**
     * 上行流量描述
     */
    private String upFlowDesc;
    /**
     * 下行流量描述
     */
    private String downFlowDesc;
    /**
     * 总流量描述
     */
    private String totalFlowDesc;
}
