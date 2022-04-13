package ru.katkova;

@Singleton
public class RecommendatorImpl implements Recommendator {

    @InjectProperty("wisky")
    private String something;

    @Override
    public void recommend() {
        System.out.println("реклама " + something);
    }
}
