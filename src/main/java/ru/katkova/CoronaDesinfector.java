package ru.katkova;

public class CoronaDesinfector {

    @InjectByType
    private Announcer announcer;
    //private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    @InjectByType
    private Policeman policeman;
    //private Policeman policeman = ObjectFactory.getInstance().createObject(Policeman.class);

    public void start(Room room) {
        announcer.announce("Начинаем дезинфекцию всего!");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Можно заходить обратно");

    }


    private void desinfect(Room room){
        System.out.println("Комната дезинфицируется");
    }
}
