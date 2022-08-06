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

/**
 *
 * @author: aoshiguchen
 * @date: 2022/8/6
 */

import fun.asgc.neutrino.core.annotation.Autowired;
import fun.asgc.neutrino.core.annotation.NonIntercept;
import fun.asgc.neutrino.core.web.annotation.PostMapping;
import fun.asgc.neutrino.core.web.annotation.RequestBody;
import fun.asgc.neutrino.core.web.annotation.RequestMapping;
import fun.asgc.neutrino.core.web.annotation.RestController;
import fun.asgc.neutrino.proxy.server.controller.req.LicenseCreateReq;
import fun.asgc.neutrino.proxy.server.controller.req.LicenseUpdateEnableStatusReq;
import fun.asgc.neutrino.proxy.server.controller.res.LicenseCreateRes;
import fun.asgc.neutrino.proxy.server.controller.res.LicenseUpdateEnableStatusRes;
import fun.asgc.neutrino.proxy.server.service.LicenseService;

@NonIntercept
@RequestMapping("license")
@RestController
public class LicenseController {

	@Autowired
	private LicenseService licenseService;

	@PostMapping("create")
	public LicenseCreateRes create(@RequestBody LicenseCreateReq req) {
		// TODO 参数校验

		return licenseService.create(req);
	}

	@PostMapping("update/enable-status")
	public LicenseUpdateEnableStatusRes updateEnableStatus(@RequestBody LicenseUpdateEnableStatusReq req) {
		// TODO 参数校验

		return licenseService.updateEnableStatus(req);
	}

}