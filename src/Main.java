import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                System.out.println("Введите номер месяца");
                int month = scanner.nextInt();
                if (month <= 0 || month >= 13) {
                    System.out.println("Значение месяца не может быть отрицательным или равным нулю");
                    System.out.println("Допустимый диапазон значений от 1 до 12 включительно");
                    continue;
                }
                System.out.println("Введите число дня");
                int day = scanner.nextInt();
                if (day <= 0 || day >= 31) {
                    System.out.println("Значение дня не может быть отрицательным или равным нулю");
                    System.out.println("Допустимый диапазон значений от 1 до 30 включительно");
                    continue;
                }
                System.out.println("Введите количество шагов");
                int steps = scanner.nextInt();
                if (steps < 0) {
                    System.out.println("Значение шагов не может быть отрицательным");
                    continue;
                }
                stepTracker.saveStepsPerDay(month, day, steps);

            } else if (userInput == 2) {
                System.out.println("Введите месяц, за который хотите получить статистику");
                int month = scanner.nextInt();

                stepTracker.printStepsDaily(month);

                System.out.println("Общее количество шагов за месяц № " + month + " = "
                        + stepTracker.getStepsPerMonth(month));

                System.out.println("Максимальное количество шагов в месяце: " + stepTracker.getMaxSteps(month));

                System.out.println("Среднее количество шагов за месяц № " + month + " = "
                        + stepTracker.getAverageSteps(stepTracker.getStepsPerMonth(month)));

                System.out.println("Пройденная дистанция за месяц № " + month + " = "
                        + converter.getWalkedDistance(stepTracker.getStepsPerMonth(month)) + " км");

                System.out.println("Количество сожженных калорий за месяц № " + month + " = "
                        + converter.getBurnedCalories(stepTracker.getStepsPerMonth(month)) + " килокалорий");

                System.out.println("Лучшая серия шагов : " + stepTracker.getStepsSeries(month) + " дней подряд");
            } else if (userInput == 3) {
                System.out.println("Введите новое значение цели шагов за день");
                int stepsGoal = scanner.nextInt();
                stepTracker.setStepsGoal(stepsGoal);
            } else if (userInput == 4) {
                System.out.println("Программа завершена");
                break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1. - Ввести количество шагов за день");
        System.out.println("2. - Напечатать статистику за месяц");
        System.out.println("3. - Изменить цель по количеству шагов за день");
        System.out.println("4. - Выйти из приложения");
    }
}