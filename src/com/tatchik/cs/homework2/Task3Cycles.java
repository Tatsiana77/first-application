package com.tatchik.cs.homework2;

/**
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior Java Developer с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 * Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
 */
public class Task3Cycles {
    public static void main(String[] args) {
        int initialSalary = 600;
        int monthlyExpenses = 300;
        double investmentPercentage = 0.10;
        double monthlyReturnRate = 0.02;
        int salaryIncrease = 400;
        // Рассчитываем средства Вани и брокера на протяжении 3 лет и 2 месяцев (38 месяцев)
        double vanyaSavings = calculateVanyaSavings(initialSalary, monthlyExpenses, investmentPercentage, monthlyReturnRate, salaryIncrease);
        double brokerAccount = calculateBrokerAccount(initialSalary, investmentPercentage, monthlyReturnRate);

        System.out.println("Средства Вани через 3 года и 2 месяца: $" + vanyaSavings);
        System.out.println("Средства на счету брокера: $" + brokerAccount);
    }

    /**
     * Метод для расчета средств Вани на основе его зарплаты, расходов и инвестиций.
     * @param initialSalary        Начальная зарплата Вани
     * @param monthlyExpenses      Месячные расходы Вани
     * @param investmentPercentage Процент зарплаты, который Ваня инвестирует
     * @param monthlyReturnRate    Месячная доходность от инвестиций
     * @param salaryIncrease       Подъем зарплаты каждые 6 месяцев
     * @return Средства Вани через указанный период
     */
    private static double calculateVanyaSavings(int initialSalary,
                                                int monthlyExpenses,
                                                double investmentPercentage,
                                                double monthlyReturnRate,
                                                int salaryIncrease) {
        double vanyaSavings = 0;

        for (int month = 1; month <= 38; month++) {
            // Каждые 6 месяцев увеличиваем зарплату Вани
            if (month % 6 == 0) {
                initialSalary += salaryIncrease;
            }
            // Рассчитываем сумму для инвестирования
            double monthlyInvestment = initialSalary * investmentPercentage;

            // Обновляем счет Вани с учетом расходов и инвестиций
            vanyaSavings += initialSalary - monthlyExpenses - monthlyInvestment;
        }
        return vanyaSavings;
    }

    /**
     * Метод для расчета средств на счету брокера на основе инвестиций Вани.
     * @param initialSalary        Начальная зарплата Вани
     * @param investmentPercentage Процент зарплаты, который Ваня инвестирует
     * @param monthlyReturnRate    Месячная доходность от инвестиций
     * @return Средства на счету брокера через указанный период
     */
    private static double calculateBrokerAccount(int initialSalary, double investmentPercentage, double monthlyReturnRate) {
        double brokerAccount = 0;

        // Рассчитываем сумму для инвестирования
        for (int month = 1; month <= 38; month++) {
            double monthlyInvestment = initialSalary * investmentPercentage;

            // Обновляем счет брокера с учетом доходности от инвестиций
            brokerAccount += monthlyInvestment * (1 + monthlyReturnRate);
        }
        return brokerAccount;
    }
}

