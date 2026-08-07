package com.raj;

import com.raj.config.HikariConnectionPool;
import com.raj.ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        try {
            new ConsoleMenu().start();
        } finally {
            HikariConnectionPool.shutdown();
        }
    }
}