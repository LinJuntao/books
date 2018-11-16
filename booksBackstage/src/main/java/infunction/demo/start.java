package infunction.demo;

import com.jfinal.core.JFinal;

public class start {
    public static void main(String[] args) {
        JFinal.start("src/main/webapp", 8080, "/", 5);
    }
}