package ru.katkova;

public class CoronaDesinfector {

    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    private Policeman policeman = ObjectFactory.getInstance().createObject(Policeman.class);

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
