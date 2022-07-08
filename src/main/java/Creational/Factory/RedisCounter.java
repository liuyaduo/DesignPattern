package Creational.Factory;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author lyd
 * @Description
 * @create 2022-07-08-9:02
 */
public class RedisCounter {
    private String ipAddress;
    private int port;

    public RedisCounter(String ipAddress, Integer port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getPort() {
        return port;
    }

    public void test() {
        System.out.println("hello redis counter");
    }

    //...
}
