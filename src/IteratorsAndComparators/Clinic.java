package IteratorsAndComparators;

public class Clinic {
    private String name;
    private Pet[] rooms;
    private int counter;
    private int index;

    public Clinic(String name, int roomCount){
        this.name = name;
        rooms = new Pet[roomCount];
        counter = 1;
        index = 3;
    }

    public String getName() {
        return name;
    }

    public boolean addPet(Pet pet){
        if(!hasEmptyRooms()){
            return false;
        }

        int currIndex = rooms.length / 2;

        for (int i = 0; i < rooms.length; i++) {
            currIndex = currIndex + i * (int) Math.pow(-1, i);

            if(rooms[currIndex] != null){
                continue;
            } else {
                rooms[currIndex] = pet;
                return true;
            }
        }

        return true;
    }

    public boolean releasePet(){
        for (int i = rooms.length / 2; i < rooms.length; i++) {
            if(rooms[i] != null){
                rooms[i] = null;
                return true;
            }
        }

        for (int i = 0; i < rooms.length / 2; i++) {
            if(rooms[i] != null){
                rooms[i] = null;
                return true;
            }
        }

        return false;
    }

    public boolean hasEmptyRooms(){

        for (int i = 0; i < rooms.length; i++) {
            if(rooms[i] == null)
                return true;
        }
        return false;
    }

    public void print(){
        for (int i = 0; i < rooms.length; i++) {
            printRoom(i + 1);
        }
    }

    public void printRoom(int room){
        if(rooms[room - 1] != null){
            System.out.println(rooms[room - 1].petInfo());
        } else {
            System.out.println("Room empty");
        }
    }
}
