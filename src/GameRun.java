import java.util.Scanner;

public class GameRun {
    //фиксированые переменные
    public static final String NULL="   ";
    public static final String CROSS=" x ";
    public static final String ZERO=" o ";
    public static String activePlayer;

    //переменные для сохранени информации про игровое поле и состояние игры
    public static final int ROW=3, COLOMN=3;
    //игровое поле в виде двухмерного массива
    public static String[][] field=new String[ROW][COLOMN];
    //статус игры в данный момент
    public static int gameStatus;
    //фиксированые переменные которые указывают на конкретный момент
    public static final  int STATUS_CONTINUE=0;
    public static final  int STATUS_DRAW=1;
    public static final  int STATUS_WIN_X=3;
    public static final  int STATUS_WIN_O=4;
    //получение введение играков с помощью Scanner
    public static Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
        //Рисуем игровое поле
        startGame();
        //следующий ход игрока ао очереди
        do{
            //получение введеных данных от игрока
            GameLogic.reciveInputPlayer();
            //Проверка статуса игры
            GameLogic.TableAnalise();
            GameField.ShowField();
            //проверка статуса игры и если игра закончилась вывести результат
            if (gameStatus==STATUS_WIN_X){
                System.out.println("'X' Выиграл! поздравляем!");
            }else if (gameStatus==STATUS_WIN_O) {
                System.out.println("'O' Выиграл! поздравляем!");
            }else if (gameStatus==STATUS_DRAW) {
                System.out.println("Игра закончилась ничья!");
            }
            //смена хода игрока
            activePlayer=(activePlayer==CROSS?ZERO:CROSS);

        }
        while (gameStatus==STATUS_CONTINUE);

    }
    public static void startGame() {
        for (int row = 0; row < ROW; row++) {
            for (int column = 0; column < COLOMN; column++) {
                field[row][column] = NULL;//все ячейки пустые
            }
        }

        activePlayer = CROSS;//Крестик начинает
        GameField.ShowField();        //ввести пустое поле
    }
}
