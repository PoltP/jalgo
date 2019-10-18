package tasks.turnstile;

import java.util.*;

public class Turnstile {
    enum TurnType {
        NONE,
        EXIT, // 1
        ENTER // 0
    }

    class Person {
        Integer index;
        Integer time;

        Person(Integer index, Integer time) {
            this.index = index;
            this.time = time;
        }
    }

    interface TurnProc {
        void turn(Queue<Person> queue, TurnType turnType);
    }

    int timer = 0;
    TurnType previousTurnType = TurnType.NONE;

    public List<Integer> getTimes(List<Integer> time, List<Integer> direction) {
        HashMap<Integer, Integer> result = new HashMap<>();

        Comparator<Person> comparator = (p1, p2) -> (p1.time > p2.time && p1.index > p2.index) ? 1 : -1;
        PriorityQueue<Person> queueEnter = new PriorityQueue<>(comparator);
        PriorityQueue<Person> queueExit = new PriorityQueue<>(comparator);
        for (int i = 0; i < time.size(); ++i) {
            if (direction.get(i) == 0) {
                queueEnter.offer(new Person(i, time.get(i)));
            } else {
                queueExit.offer(new Person(i, time.get(i)));
            }
        }

        TurnProc turnProc = (Queue<Person> queue, TurnType turnType) -> {
            Person person = queue.poll();
            result.put(person.index, timer);
            previousTurnType = turnType;
            timer++;
        };
        while (!queueEnter.isEmpty() || !queueExit.isEmpty()) {
            if (queueEnter.isEmpty()) {
                timer = Math.max(timer, queueExit.peek().time);
                turnProc.turn(queueExit, TurnType.EXIT);
                continue;
            }
            if (queueExit.isEmpty()) {
                timer = Math.max(timer, queueEnter.peek().time);
                turnProc.turn(queueEnter, TurnType.ENTER);
                continue;
            }

            Person nextEnter = queueEnter.peek();
            Person nextExit = queueExit.peek();
            if (timer < Math.min(nextEnter.time, nextExit.time)) {// ensure it
                previousTurnType = TurnType.NONE;
                timer = Math.min(nextEnter.time, nextExit.time);
            }
            if (nextEnter.time == nextExit.time ||
                    (timer > nextEnter.time && timer == nextExit.time) ||
                    (timer > nextExit.time && timer == nextEnter.time)) {
                // Collision case: 2 persons at the same time or one is waiting a permission to go
                if (previousTurnType == TurnType.NONE || previousTurnType == TurnType.EXIT) {
                    turnProc.turn(queueExit, TurnType.EXIT);
                } else {
                    turnProc.turn(queueEnter, TurnType.ENTER);
                }
            } else if (timer > nextExit.time && timer < nextEnter.time || nextExit.time == timer) {
                turnProc.turn(queueExit, TurnType.EXIT);
            } else if (timer > nextEnter.time && timer < nextExit.time || nextEnter.time == timer) {
                turnProc.turn(queueEnter, TurnType.ENTER);
            }
        }

        return new ArrayList<>(result.values());// HashMap keys are sorted out of the box
    }
}
