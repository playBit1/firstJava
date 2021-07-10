package cinema;

public class test {
    public static void main(String[] arg) {
        Cinema c1 = new Cinema();

        c1.setTotalRows();
        c1.setTotalSeats();
        c1.setGrid(c1.getTotalRows(),c1.getTotalSeats());
        c1.menu();






    }
}
