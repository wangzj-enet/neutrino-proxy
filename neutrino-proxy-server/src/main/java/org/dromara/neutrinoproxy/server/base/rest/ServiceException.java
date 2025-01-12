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
package org.dromara.neutrinoproxy.server.base.rest;

import org.dromara.neutrinoproxy.server.constant.ExceptionConstant;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 服务异常
 * @author: aoshiguchen
 * @date: 2022/7/31
 */
@Getter
public class ServiceException extends RuntimeException {
	/**
	 * 错误码
	 */
	private int code;
	/**
	 * 异常消息
	 */
	private String msg;

	public ServiceException(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public static ServiceException create(ExceptionConstant constant) {
		return new ServiceException(constant.getCode(), constant.getMsg());
	}

	public static ServiceException create(ExceptionConstant constant, Object... params) {
		return new ServiceException(constant.getCode(), format(constant.getMsg(), params));
	}

	/**
	 * 字符串格式化
	 * @param template
	 * @param params
	 * @return
	 */
	public static String format(String template, Object[] params) {
		if (StringUtils.isEmpty(template) || null == params || params.length == 0) {
			return template;
		}
		String result = template;
		for (Object param : params) {
			int index = result.indexOf("{}");
			if (index == -1) {
				return result;
			}
			result = result.substring(0, index) + param + result.substring(index + 2);
		}
		return result;
	}
}
