package xuriven.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 过滤类型，前置过滤器
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序，返回的int越小，优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 该过滤器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     * 登录校验逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        //http://localhost:10010/api/service-provider/user?id=28&token=xxx。多个参数传递用&连接
        if (StringUtils.isBlank(token)){
            //拦截该请求，不对其进行路由
            context.setSendZuulResponse(false);
            //设置响应码状态401，401-身份未认证
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            context.setResponseBody("sorry request error!");
        }
        //校验通过，把登录信息放入上下文信息，继续向后执行
        context.set("token",token);
        //返回值Null,表示该过滤器什么都不做
        return null;
    }
}
