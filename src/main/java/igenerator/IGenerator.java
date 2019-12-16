package igenerator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Generator
 *
 * @author itoak
 * @date 2019-12-13
 * @time 11:45
 * @desc 代码生成抽象类
 */
public abstract class IGenerator {

    /**
     * 代码生成
     *
     * @param args args
     */
    public static void main(String[] args) {
        if (System.getProperty("os.name").startsWith("Windows")) {
            new WindowsIGenerator().generate();
        } else {
            new MacOSIGenerator().generate();
        }
    }

    /**
     * 生成代码
     */
    void generate() {
        try {
            List<String> warnings = new ArrayList<>();
            File configFile = configFile();
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取配置文件
     *
     * @return 配置文件
     */
    protected abstract File configFile();
}
