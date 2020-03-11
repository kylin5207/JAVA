package AnnotationTest.DefinedAnnotation;

/*
    自定义注解：
        public @interface 注解名称{属性列列表; }

        本质:注解本质上就是⼀个接口，该接口默认继承Annotation接口
            public interface MyAnno extends java.lang.annotation.Annotation {}

        接⼝中的抽象方法要求:
        1. 属性的返回值类型有下列取值
                * 基本数据类型
                * String
                * 枚举
                * 注解
                * 以上类型的数组
         2. 定义了属性，在使⽤时需要给属性赋值
                如果定义属性时，使⽤用default关键字给属性默认初始化值，则使⽤注解时，可以不进行属性的赋值。
                如果只有⼀个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可。
                数组赋值时，值使用{}包裹。如果数组中只有⼀个值，则{}可以省略
 */

/*
    元注解:⽤于描述注解的注解
    @Target:描述注解能够作⽤的位置
        ElementType取值:
            TYPE:可以作⽤于类上
            METHOD:可以作⽤于⽅法上
            FIELD:可以作用于成员变量上
    @Retention:描述注解被保留的阶段
        @Retention(RetentionPolicy.RUNTIME):当前被描述的注解，会保留留到class字节码⽂文件中，并被JVM读取到

    @Documented:描述注解是否被抽取到api⽂文档中
    @Inherited:描述注解是否被⼦类继承
 */

import java.lang.annotation.*;

@Target(value = {ElementType.TYPE}) // 该注解只能作用于类上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
    int age();

    //默认属性初始化值
    String name() default "默认值";

    String[] letters();


}
