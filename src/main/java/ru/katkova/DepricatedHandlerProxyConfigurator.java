package ru.katkova;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DepricatedHandlerProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {

        if (implClass.getInterfaces().length == 0) {
            return Enhancer.create(implClass, (net.sf.cglib.proxy.InvocationHandler) (o, method, args) -> getInvocationHandlerLogic(t, args, method));
        }

        if (implClass.isAnnotationPresent(Deprecated.class)) {
            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> getInvocationHandlerLogic(t, args, method));
        } else
        return t;
    }

    private Object getInvocationHandlerLogic(Object t, Object[] args, Method method) throws IllegalAccessException, InvocationTargetException {
        System.out.println("красивый текст из InvocationHandler-a о depricated методе");
        return method.invoke(t, args);
    }
}
