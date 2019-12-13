package igenerator;

import java.io.File;

/**
 * WindowsGenerator
 *
 * @author wangdonglei
 * @date 2019-12-12
 * @time 18:56
 * @desc Windows环境下代码生成器
 */
public class WindowsIGenerator extends IGenerator {

    private static final String CONFIG_FILE_PATH = "src/main/resources/generatorWindowsConfig.xml";

    /**
     * 返回Windows配置文件
     *
     * @return 配置文件
     */
    protected File configFile() {
        return new File(CONFIG_FILE_PATH);
    }
}
