package ru.vsu.cs.maslovaei;

public class Main {
    public static void main(String[] args) {

        Logic logic = new Logic();

        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(1);
        list.addLast(6);
        list.addLast(35);
        list.addLast(6235);
        list.addLast(-3);
        list.addLast(1);

        try {

            logic.findNumber(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
