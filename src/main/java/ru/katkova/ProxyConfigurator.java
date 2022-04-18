package ru.katkova;

public interface ProxyConfigurator {
        Object replaceWithProxyIfNeeded(Object t, Class implClass);
}
