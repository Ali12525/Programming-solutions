package com.myproject;

import java.util.*;
import java.util.function.Consumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    public static class MailMessage implements MailService.Sendable<String> {
        private final String from;
        private final String to;
        private final String content;

        public MailMessage(String from, String to, String content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public String getContent() {
            return content;
        }
    }

    public static class Salary implements MailService.Sendable<Integer> {
        private final String from;
        private final String to;
        private final int salary;

        public Salary(String from, String to, int salary) {
            this.from = from;
            this.to = to;
            this.salary = salary;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public Integer getContent() {
            return salary;
        }
    }

    public static class MailService<T> implements Consumer<MailService.Sendable<T>> {
        private final Map<String, List<T>> mailBox = new HashMap<>();

        @Override
        public void accept(MailService.Sendable<T> item) {
            mailBox.computeIfAbsent(item.getTo(), k -> new ArrayList<>()).add(item.getContent());
        }

        public Map<String, List<T>> getMailBox() {
            return new HashMap<String, List<T>>(mailBox) {
                @Override
                public List<T> get(Object key) {
                    List<T> list = super.get(key);
                    return list == null ? Collections.emptyList() : list;
                }
            };
        }

        public interface Sendable<S> {
            String getFrom();
            String getTo();
            S getContent();
        }
    }
}