package ru.mephi.java.ch05.addTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private HashMap<Integer, Person> persons = new HashMap<>();

    public HashMap<Integer, Person> offerDepositExc(int amount) {
        HashMap<Integer, Person> per = new HashMap<>();
        for (Map.Entry<Integer, Person> entry : persons.entrySet()) {
            try {
                checkPersonExc(amount, entry.getValue());
                per.put(entry.getKey(), entry.getValue());
            } catch (BalanceException e) {
                System.err.println(e);
            }
        }
        return per;
    }

    public void setPersons() {
        persons.put(1, new Person("Sasha", 10000));
        persons.put(2, new Person("Ivan", 20000));
        persons.put(3, new Person("Andrey", 30000));
    }

    private void checkPersonExc(double amount, Person person) throws BalanceException {
        double m = person.getBalance() - amount;
        if (m < 0)
            throw new BalanceException(person.getName(), -m);
        else
            person.setBalance(m);
    }
    // когда выбрасываем исклюение, а когда ловим
    public HashMap<Integer, Person> offerDepositErrCode(int amount) {
        HashMap<Integer, Person> per = new HashMap<>();
        for (Map.Entry<Integer, Person> entry : persons.entrySet()) {
            int x = checkPersonErrCode(amount, entry.getValue());
            if (x == 0)
                per.put(entry.getKey(), entry.getValue());
            else {
                System.out.println(entry.getValue().getName() + " вам не хватает" +
                       (amount - entry.getValue().getBalance()) );
            }

        }
        return per;
    }

    private int checkPersonErrCode(int amount, Person person) {
        double m = person.getBalance() - amount;
        if (m < 0)
            return -1;
        else {
            person.setBalance(m);
            return 0;
        }

    }

}
