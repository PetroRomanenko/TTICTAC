public class GameField extends GameRun{
    public static void ShowField(){
        for (int row = 0; row < ROW; row++){
            for (int column = 0; column < COLOMN ; column++) {
                System.out.print(field[row][column]);//вывести каждую из яцеек
                if(column!=COLOMN-1){
                    System.out.print("|");//вывести вертикальный разделитель
                }
            }
            System.out.println();
            if (row!=ROW-1){
                System.out.println  ("-----------");//вывести горизонтальный разделитель
            }
        }
        System.out.println();
    }
}
