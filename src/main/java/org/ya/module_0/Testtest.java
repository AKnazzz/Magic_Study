package org.ya.module_0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Testtest {
    private long ip4;
    private long ip6;
    private long time;

    public long getIp4() {
        return ip4;
    }

    public void setIp4(long ip4) {
        this.ip4 = ip4;
    }

    public long getIp6() {
        return ip6;
    }

    public void setIp6(long ip6) {
        this.ip6 = ip6;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Testtest(long ip4, long ip6, long time) {
        this.ip4 = ip4;
        this.ip6 = ip6;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Testtest{" +
                "ip4=" + ip4 +
                ", ip6=" + ip6 +
                ", time=" + time +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        Testtest test1 = new Testtest(111, 4444444, 7777777);
        Testtest test2 = new Testtest(111, 5555555, 8888888);
        Testtest test3 = new Testtest(333, 5555555, 9999999);

        Collection<Testtest> list = new ArrayList<>();

        list.add(test2);
        list.add(test3);
        list.add(test1);

        List<Testtest> number = list.stream()
                .sorted((a, b) -> {
                    if (a.getIp4() == b.getIp4()) {
                        if (a.getIp6() == b.getIp6()) {
                            return Long.compare(a.getTime(), b.getTime());
                        } else {
                            return Long.compare(a.getIp6(), b.getIp6());
                        }
                    } else {
                        return Long.compare(a.getIp4(), b.getIp4());

                    }

                }).toList();


        System.out.println(number);
    }
}