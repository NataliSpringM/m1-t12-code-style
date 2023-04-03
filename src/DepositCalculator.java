import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double initialAmount, double yearRate, int depositPeriod) {
        double resultAmount = initialAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return roundValue(resultAmount, 2);
    }
    double calculateSimplePercent(double initialAmount, double yearRate, int depositPeriod) {
        double resultAmount = initialAmount + initialAmount * yearRate * depositPeriod;

        return roundValue(resultAmount, 2);
    }
    double roundValue(double value,int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;}

    void calculateResultAmount() {
        int depositPeriod;
        int depositType;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");

        int initialAmount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");

        depositPeriod = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");

        depositType = scanner.nextInt();

        double resultAmount = 0;

        if (depositType == 1) {
            resultAmount = calculateSimplePercent(initialAmount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            resultAmount = calculateComplexPercent(initialAmount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + initialAmount + " за " + depositPeriod + " лет превратятся в " + resultAmount);
    }
    public static void main(String[] args) {

        new DepositCalculator().calculateResultAmount();
    }
}
