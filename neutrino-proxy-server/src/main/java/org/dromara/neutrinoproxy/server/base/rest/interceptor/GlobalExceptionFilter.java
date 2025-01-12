package org.dromara.neutrinoproxy.server.base.rest.interceptor;

import org.dromara.neutrinoproxy.server.base.rest.ResponseBody;
import org.dromara.neutrinoproxy.server.base.rest.ServiceException;
import org.dromara.neutrinoproxy.server.constant.ExceptionConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;

/**
 * @author: aoshiguchen
 * @date: 2023/3/9
 */
@Slf4j
@Component
public class GlobalExceptionFilter implements Filter {

    @Override
    public void doFilter(Context ctx, FilterChain chain) throws Throwable {
        try {
            chain.doFilter(ctx);
        } catch (Throwable e) {
            log.error("全局异常", e);

            if (e instanceof ServiceException) {
                ServiceException serviceException = (ServiceException) e;
                ctx.render(new ResponseBody<>()
                        .setCode(serviceException.getCode())
                        .setMsg(serviceException.getMsg()));
                return;
            }

            ctx.render(new ResponseBody<>()
                    .setCode(ExceptionConstant.SYSTEM_ERROR.getCode())
                    .setMsg(ExceptionConstant.SYSTEM_ERROR.getMsg())
                    .setStack(ExceptionUtils.getStackTrace(e)));
        }
    }
}
