package Creational.builder;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lyd
 * @Description
 * 1. 类的属性很多，并满足以下条件之一时
 * 当类的构造函数存在很多必填属性
 * 属性之间存在一定的约束关系
 * 希望创建不可变对象
 * 推荐用建造者模式
 * 2. 建造者模式vs工厂模式
 * 工厂模式侧重创建多种不同类的对象，有给定的参数决定创建哪一类的对象
 * 建造者模式侧重创建同一个类的不同对象，设置不同的可选属性，定制化的创建不同对象
 * @create 2022-07-08-16:37
 */
public class ResourcePoolConfig {

    private String name;
    private int maxTotal; // 最大总资源
    private int maxIdle; // 最大空闲资源
    private int minIdle; // 最小空闲资源

    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal;
        private int maxIdle;
        private int minIdle;

        /**
         * 参数校验，并创建对象
         * @return
         */
        public ResourcePoolConfig build() {

            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("name 必须被初始化！");
            }

            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("maxIdle > maxTotal!");
            }

            if (minIdle > maxIdle) {
                throw new IllegalArgumentException("minIdle > maxIdle!");
            }

            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("name is blank!!");
            }
            this.name = name;
            return  this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal < 0) {
                throw new IllegalArgumentException("maxTotal < 0 !");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("maxIdle < 0 !");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("minIdle < 0 !");
            }
            this.minIdle = minIdle;
            return this;
        }
    }

}
