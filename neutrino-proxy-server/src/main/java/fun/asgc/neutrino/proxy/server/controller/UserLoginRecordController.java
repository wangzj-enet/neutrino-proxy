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
package fun.asgc.neutrino.proxy.server.controller;

import fun.asgc.neutrino.core.annotation.Autowired;
import fun.asgc.neutrino.core.annotation.NonIntercept;
import fun.asgc.neutrino.core.db.page.Page;
import fun.asgc.neutrino.core.db.page.PageQuery;
import fun.asgc.neutrino.core.web.annotation.GetMapping;
import fun.asgc.neutrino.core.web.annotation.RequestMapping;
import fun.asgc.neutrino.core.web.annotation.RestController;
import fun.asgc.neutrino.proxy.server.controller.req.UserLoginRecordListReq;
import fun.asgc.neutrino.proxy.server.controller.res.UserLoginRecordListRes;
import fun.asgc.neutrino.proxy.server.service.UserLoginRecordService;
import fun.asgc.neutrino.proxy.server.util.ParamCheckUtil;

/**
 * @author: aoshiguchen
 * @date: 2022/10/20
 */
@NonIntercept
@RequestMapping("user-login-record")
@RestController
public class UserLoginRecordController {
    @Autowired
    private UserLoginRecordService userLoginRecordService;

    @GetMapping("page")
    public Page<UserLoginRecordListRes> page(PageQuery pageQuery, UserLoginRecordListReq req) {
        ParamCheckUtil.checkNotNull(pageQuery, "pageQuery");

        return userLoginRecordService.page(pageQuery, req);
    }
}