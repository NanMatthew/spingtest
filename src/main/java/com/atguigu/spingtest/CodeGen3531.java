package com.atguigu.spingtest;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.ibatis.annotations.Mapper;

import java.util.function.Consumer;

/**
 * @author 李杭勇
 * @version 1.0
 * @className CodeGen3531
 * @description
 * @date 2023/6/29 16:09
 */
public class CodeGen3531 {

    public static void main(String[] args) {
        //   String[] tables={ "governance_metric","governance_type","governance_assess_detail"};
        //  String[] tables={ "t_ds_task_definition","t_ds_task_instance"};
        String[] tables={ "order_info"  };

        FastAutoGenerator.create("jdbc:mysql://hadoop102:3306/gmall","root","000000")
                .globalConfig(builder -> {
                    builder.author("matthew")               //作者
                            .outputDir("D:\\BigData_Study\\Code\\spingtest\\src\\main\\java")    //输出路径(写到java目录)
                            .commentDate("yyyy-MM-dd")
                            .dateType(DateType.ONLY_DATE);  //选择实体类中的日期类型  ，Date or LocalDatetime
                })
                .packageConfig(builder -> {                 //各个package 名称
                    builder.parent("com.atguigu.spingtest")
                            .moduleName("order")
                            .entity("bean")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .mapper("mapper");

                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables)
                            .serviceBuilder()
                            .formatServiceFileName("%sService")  //类后缀
                            .formatServiceImplFileName("%sServiceImpl")  //类后缀
                            .entityBuilder()
                            .enableLombok()  //允许使用lombok
                            .controllerBuilder()
                            .formatFileName("%sController")  //类后缀
                            .enableRestStyle()   //生成@RestController 否则是@Controller
                            .mapperBuilder()
                            //生成通用的resultMap 的xml映射
                            .enableBaseResultMap()  //生成xml映射
                            .superClass(BaseMapper.class)  //标配
                            .formatMapperFileName("%sMapper")  //类后缀
                            //.enableFileOverride()   //生成代码覆盖已有文件 谨慎开启
                            .mapperAnnotation(Mapper.class) ; //生成代码Mapper上自带@Mapper

                })
                .templateConfig(new Consumer<TemplateConfig.Builder>() {
                    @Override
                    public void accept(TemplateConfig.Builder builder) {
                        // 实体类使用我们自定义模板
                        builder.entity("templates/myentity.java");
                    }
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}

