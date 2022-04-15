package ru.katkova;

import java.util.Map;

public class Application {
    public static ApplicationContext run (String packageToScan, Map<Class,Class> ifc2implClass) {
        JavaConfig config = new JavaConfig(packageToScan, ifc2implClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);
//        проинициализировать не ленивые синглтоны
//                - просканировать пакеты
//            поискать аннтотацию Синглтон
//                посоздавать обхекты
//                        засунуть их в контекст
     context.setFactory(objectFactory);
     return context;
    }
}
