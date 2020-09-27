import java.util.Scanner;

public class Main {

    private static Scanner scan;
    private static int fieldSize;

    public static void main(String[] args) {

        scan = new Scanner(System.in);

        playNoughtsAndCrosses();

        scan.close();
    }

    public static void playNoughtsAndCrosses(){

        int statusGame;
        boolean userMove = true;

        char[][] field = createField();

        do {
            if (userMove) {
                doPlayerMove(field);
                System.out.println("You move:");
            }
            else {
                doAIMove(field);
                System.out.println("AI move:");
            }

            printField(field);

            statusGame = getStatusGame(field);
            switch (statusGame){
                case (0):
                    break;
                case (1):
                    System.out.println("You won");
                    break;
                case (2):
                    System.out.println("AI won");
                    break;
                case (3):
                    System.out.println("Friendship won");
                    break;
            }

            userMove = !userMove;

        } while (statusGame == 0);

    }

    private static char[][] createField(){

        System.out.println("Please, enter the field size");
        fieldSize = scan.nextInt();

        char[][] field = new char[fieldSize][fieldSize];

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = '-';
            }
        }

        return field;
    }

    private static void doPlayerMove(char[][] field) {

        int x, y;

        do {
            x = enterCoordinate('x');
            y = enterCoordinate('y');
            if(field[x][y] != '-'){
                System.out.println("This cell is already occupied, try again");
            } else
                break;
        } while (true);

        field[x][y] = 'x';
    }

    private static void doAIMove(char[][] field){

        int[][] movePriorities = new int[fieldSize][fieldSize];
        int maxPriority = 0;

        for (int i = 0; i < movePriorities.length; i++) {
            for (int j = 0; j < movePriorities.length; j++) {
                movePriorities[i][j] = getMovePriority(i,j,field);
                if (movePriorities[i][j]>maxPriority){
                    maxPriority = movePriorities[i][j];
                }
            }
        }

        for (int i = 0; i < movePriorities.length; i++) {
            for (int j = 0; j < movePriorities.length; j++) {
                if (movePriorities[i][j] == maxPriority){
                    field[i][j] = '0';
                    return;
                }
            }
        }
    }

    private static int enterCoordinate(char coordinateView){

        int coordinate;

        do {
            System.out.printf("Please, enter the %s-coordinate (1-%s)\n", coordinateView, fieldSize);
            coordinate = scan.nextInt();
        } while (coordinate < 1 || coordinate > fieldSize);

        return coordinate-1;
    }

    private static int getStatusGame(char[][] field){

        int countX, count0, countAll;

        // 1. Выигрыш горизонталь
        for (int i = 0; i < fieldSize; i++) {
            countX = 0;
            count0 = 0;
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][j] == 'x')
                    countX++;
                else if (field[i][j] == '0')
                    count0++;
            }
            if (countX == fieldSize)
                return 1;
            else if (count0 == fieldSize)
                return 2;
        }

        // 2. Выигрыш вертикаль
        for (int i = 0; i < fieldSize; i++) {
            countX = 0;
            count0 = 0;
            for (int j = 0; j < fieldSize; j++) {
                if (field[j][i] == 'x')
                    countX++;
                else if (field[j][i] == '0')
                    count0++;
            }
            if (countX == fieldSize)
                return 1;
            else if (count0 == fieldSize)
                return 2;
        }

        // 3. Выигрыш диагональ (слева - направо)
        countX = 0;
        count0 = 0;
        for (int i = 0; i < fieldSize; i++) {
            if (field[i][i] == 'x')
                countX++;
            else if (field[i][i] == '0')
                count0++;
        }
        if (countX == fieldSize)
            return 1;
        else if (count0 == fieldSize)
            return 2;

        // 4. Выигрыш диагональ (справо - налево)
        countX = 0;
        count0 = 0;
        for (int i = 0; i < fieldSize; i++) {
            if (field[fieldSize-1-i][i] == 'x')
                countX++;
            else if (field[fieldSize-1-i][i] == '0')
                count0++;
        }
        if (countX == fieldSize)
            return 1;
        else if (count0 == fieldSize)
            return 2;

        // 5. Ничья
        countAll = 0;
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][j] != '-')
                    countAll++;
            }
        }
        if (countAll == fieldSize * fieldSize)
            return 3;

        return 0;
    }

    private static int getMovePriority(int x, int y, char[][] field){

        int priorityHorizontal  = 0;
        int priorityVertical    = 0;
        int priorityDiagonalL   = 0;
        int priorityDiagonalR   = 0;
        int countX, count0;

        if (field[x][y] !='-')
            return -1;

        // Анализ горизонталь
        countX = 0;
        count0 = 0;
        for (int i = 0; i < fieldSize; i++) {
            if (field[x][i] == 'x')
                countX++;
            else if (field[x][i] == '0')
                count0++;
        }
        priorityHorizontal = getLinePriority(countX, count0);

        // Анализ вертикаль
        countX = 0;
        count0 = 0;
        for (int i = 0; i < fieldSize; i++) {
            if (field[i][y] == 'x')
                countX++;
            else if (field[i][y] == '0')
                count0++;
        }
        priorityVertical = getLinePriority(countX, count0);

        // Анализ диагональ, важность хода по диагонали всегда увеличиваем на 1
        // Слева направо
        if (x==y) {
            countX = 0;
            count0 = 0;
            for (int i = 0; i < fieldSize; i++) {
                if (field[i][i] == 'x')
                    countX++;
                else if (field[i][i] == '0')
                    count0++;
            }
            priorityDiagonalL = getLinePriority(countX, count0)+1;
        }

        // Справа налево
        if (x+y==fieldSize-1) {
            countX = 0;
            count0 = 0;
            for (int i = 0; i < fieldSize; i++) {
                if (field[fieldSize-1-i][i] == 'x')
                    countX++;
                else if (field[fieldSize-1-i][i] == '0')
                    count0++;
            }
            priorityDiagonalR = getLinePriority(countX, count0)+1;
        }

        return Math.max(priorityHorizontal, Math.max(priorityVertical, Math.max(priorityDiagonalL, priorityDiagonalR)));
    }

    private static int getLinePriority(int countX, int count0){

        int priority = 0;

        // 1. До выигрыша один шаг
        if (count0 == fieldSize - 1)
            priority = 10;
        // 2. До проигрыша один шаг
        else if (countX == fieldSize-1 && count0 == 0)
            priority = 5;
        // 3. Блокируем дальнейшую стратегию игрока
        else if (countX>count0 && count0 == 0)
            priority = 2;
        // 4 Атакуем сами
        else if (count0 > 0 && countX == 0)
            priority = 1;

        return priority;
    }

    private static void printField(char[][] field){
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

}






