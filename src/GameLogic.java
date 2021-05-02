public class GameLogic extends GameRun{
    public static String FindWinner() {

        int numberOfSimilar;
        // 3-в-рядок
        for (int row = 0; row < ROW; row++) {
            numberOfSimilar = 0;
            for (int column = 0; column < COLOMN; column++) {
                if (field[row][0] != NULL && field[row][0] == field[row][column]) {
                    numberOfSimilar++;
                }
            }
            if (numberOfSimilar == 3) {
                return field[row][0];
            }
        }

        // 3-в-стовпчик
        for (int column = 0; column < COLOMN; column++) {
            numberOfSimilar = 0;
            for (int row = 0; row < ROW; row++) {
                if (field[0][column] != NULL && field[0][column] == field[row][column]) {
                    numberOfSimilar++;
                }
            }
            if (numberOfSimilar == 3) {
                return field[0][column];
            }
        }

        if (field[0][0] != NULL && field[0][0] == field[1][1] && field[0][0] == field[2][2]) {
            return field[0][0];
        }

        // 3-по-діагоналі-справа-наліво
        if (field[0][2] != NULL && field[1][1] == field[0][2] && field[2][0] == field[0][2]) {
            return field[0][2];
        }

        return NULL;
    }
    public static void reciveInputPlayer(){
        boolean isTrue=false;
        do {
            System.out.println("Player "+activePlayer+ "Введите ряд от 1 до 3 через пробел");
            int row=in.nextInt()-1;
            int column=in.nextInt()-1;
            if(row >= 0 && row<ROW && column >= 0 && column<COLOMN && field[row][column] == NULL) {
                field[row][column] = activePlayer;
                isTrue = true;
            }else{
                System.out.println("Выбраное размещение("+(row+1)+","+(column+1)
                        +") не может быть выполнено, попробуйте еще раз");
            }
        }while(!isTrue);
    }
    public static void TableAnalise(){
        String winner=FindWinner();
        if (winner.equals(CROSS)){
            gameStatus=STATUS_WIN_X;
        } else if (winner.equals(ZERO)){
            gameStatus=STATUS_WIN_O;
        }else if (IfAllCellAreFilled()) {
            gameStatus = STATUS_DRAW;
        }else
            gameStatus = STATUS_CONTINUE;
    }
    public static boolean IfAllCellAreFilled(){
        for (int row = 0; row < ROW; row++) {
            for (int column = 0; column < COLOMN; column++) {
                if(field[row][column]==NULL){
                    return false;
                }
            }
        }
        return true;//пустых ячеек не найдено
    }
}
