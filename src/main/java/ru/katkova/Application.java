package ru.katkova;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Application {
    public static ApplicationContext run (String packageToScan, Map<Class,Class> ifc2implClass) {
        JavaConfig config = new JavaConfig(packageToScan, ifc2implClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);
        Map<Class,Object> map = new ConcurrentHashMap<Class, Object>();
        //сканируем пакеты и выбираем не-ленивые синглтоны
        for (Class<?> sClass : config.getScanner().getTypesAnnotatedWith(Singleton.class)) {
            //создаем объекты для найденных классов
            Object object = objectFactory.createObject(sClass);
            // складываем их в мапу, чтобы потом передать в кэш
            map.put(sClass, object);
        }
        context.setFactory(objectFactory);
        context.setCache(map);
        return context;
    }
}
