package com.tatchik.cs.homework5.encapsulation;

public class ATM {
    private int countOf10;
    private int countOf20;
    private int countOf50;


    // Конструктор класса, принимает начальное количество купюр каждого номинала
    public ATM(int initialCountOf10, int initialCountOf20, int initialCountOf50) {
        this.countOf10 = initialCountOf10;
        this.countOf20 = initialCountOf20;
        this.countOf50 = initialCountOf50;
    }

    // Метод для добавления денег в банкомат
    public void addMoney(int countOf10, int countOf20, int countOf50) {
        this.countOf10 += countOf10;
        this.countOf20 += countOf20;
        this.countOf50 += countOf50;
        System.out.println("Деньги успешно добавлены в банкомат." );
    }
    // Метод для снятия денег из банкомата
    public boolean withdrawMoney(int amount) {
        int remainingAmount = amount;

        // Расчет количества купюр номиналом 50
        int countOf50ToWithdraw = Math.min(remainingAmount / 50, countOf50);
        remainingAmount -= countOf50ToWithdraw * 50;

        // Расчет количества купюр номиналом 20
        int countOf20ToWithdraw = Math.min(remainingAmount / 20, countOf20);
        remainingAmount -= countOf20ToWithdraw * 20;

        // Расчет количества купюр номиналом 10
        int countOf10ToWithdraw = Math.min(remainingAmount / 10, countOf10);
        remainingAmount -= countOf10ToWithdraw * 10;

        // Проверка, удалось ли выдать запрошенную сумму
        if (remainingAmount == 0) {
            // Обновление количества купюр в банкомате
            countOf50 -= countOf50ToWithdraw;
            countOf20 -= countOf20ToWithdraw;
            countOf10 -= countOf10ToWithdraw;

            // Вывод информации о выдаче купюр
            System.out.println("Сумма " + amount + " успешно выдана купюрами:");
            System.out.println("50 рублей: " + countOf50ToWithdraw + " шт.");
            System.out.println("20 рублей: " + countOf20ToWithdraw + " шт.");
            System.out.println("10 рублей: " + countOf10ToWithdraw + " шт.");

            return true;
        } else {
            System.out.println("Недостаточно средств в банкомате для выдачи запрошенной суммы.");
            return false;
        }
    }
}

