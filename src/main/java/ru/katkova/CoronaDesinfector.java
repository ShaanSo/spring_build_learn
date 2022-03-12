package ru.katkova;

public class CoronaDesinfector {

    public void start(Room room) {
        announcer.announcee("Начинаем дезинфекцию всего!")
        desinfect(room);
    }


    private void desinfect(Room room){
        System.out.println("Комната дезинфицируется");
    }
}
