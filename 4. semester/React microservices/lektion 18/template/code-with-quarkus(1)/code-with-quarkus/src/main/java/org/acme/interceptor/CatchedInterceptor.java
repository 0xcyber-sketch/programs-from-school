package org.acme.interceptor;



import javax.annotation.Priority;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Cached
@Interceptor
@Priority(1)
public class CatchedInterceptor {

    //private

    public CatchedInterceptor() {

    }

    @AroundInvoke
    public Object cacheMethod(InvocationContext invocationContext) throws Exception {
        System.out.println("Before Method");
        Object o = invocationContext.proceed();
        System.out.println(o.getClass().getName());
        System.out.println("After Method");
        return o;
    }
}
