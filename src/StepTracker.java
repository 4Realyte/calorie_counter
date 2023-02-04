
public class StepTracker {
    private int stepsGoal = 10000;
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void saveStepsPerDay(int month, int day, int steps) {
        monthToData[month - 1].days[day - 1] = steps;
        System.out.println("Значение успешно сохранено");
    }

    public void printStepsDaily(int month) {
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            System.out.print((i + 1) + " день: " + monthToData[month - 1].days[i] + ", ");
        }
    }

    public int getStepsPerMonth(int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            sum = sum + monthToData[month - 1].days[i];
        }
        return sum;
    }

    public int getMaxSteps(int month) {
        int maxSteps = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            if (monthToData[month - 1].days[i] > maxSteps) {
                maxSteps = monthToData[month - 1].days[i];
            }
        }
        return maxSteps;
    }

    public int getAverageSteps(int sum) {
        int average = sum / 30;
        return average;
    }

    public int getStepsSeries(int month) {
        int currentSeries = 0;
        int maxSeries = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            if (monthToData[month - 1].days[i] >= stepsGoal) {
                currentSeries++;
                if (currentSeries > maxSeries) {
                    maxSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return maxSeries;
    }

    public void setStepsGoal(int stepsGoal) {
        if (stepsGoal > 0) {
            this.stepsGoal = stepsGoal;
        } else {
            System.out.println("Введенное значение не должно быть отрицательным");
        }
    }

    class MonthData {
        int[] days = new int[30];
        int stepsPerDay = 0;

        MonthData() {
            for (int i = 0; i < days.length; i++) {
                days[i] = stepsPerDay;
            }
        }
    }
}
