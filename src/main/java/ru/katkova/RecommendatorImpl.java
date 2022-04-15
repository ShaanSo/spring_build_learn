package ru.katkova;

@Singleton
@Deprecated
public class RecommendatorImpl implements Recommendator {

    @InjectProperty("wisky")
    private String something;

    public RecommendatorImpl()
    {
        System.out.println("Recommendator was created");
    }

    @Override
    public void recommend() {
        System.out.println("реклама " + something);
    }
}
