import java.util.Random;

class Main {

  public static void main(String[] args) {
    /*
    theChain is 3, 4, 7, 6, 3, 2, 9, 6, 3, 6
    */
    //*
    LinkedList list = new LinkedList();
    list.add(3);
    list.add(3);
    list.add(3);
    list.add(7);
    list.add(8);
    list.add(3);
    list.add(7);
    list.add(1);
    list.add(6);
    list.add(3);

    System.out.println(list);
    boolean thing = list.removeN(3, 4);
    System.out.println(thing);
    System.out.println(list);
/*
    for (int b = 0; b < 1000; b++){
      Random rng = new Random();
      int rnging;
      int rngsize = rng.nextInt(10);
      LinkedList list = new LinkedList();
      for (int i = 0; i < rngsize; i++){
        rnging = rng.nextInt(3) - 1;
        list.add(rnging);
      }
      rnging = rng.nextInt(3) - 1;
      int numberoftimesremoved = rng.nextInt(5) - 1;

      System.out.println(list);
      System.out.printf("%d, %d, ", rnging, numberoftimesremoved);
      boolean thing = list.removeN(rnging, numberoftimesremoved);
      System.out.println(thing + " " + list.getSize());
      System.out.println(list + "\n");
      
    }
    */
  }
}