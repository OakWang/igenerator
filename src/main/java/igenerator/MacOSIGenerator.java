package igenerator;

import java.io.File;

/**
 * MacOSGenerator
 *
 * @author wangdonglei
 * @date 2019-12-12
 * @time 18:56
 * @desc MacOS环境下代码生成器
 */
public class MacOSIGenerator extends IGenerator {

    private static final String CONFIG_FILE_PATH = "src/main/resources/generatorMacOSConfig.xml";

    /**
     * 返回MacOS配置文件
     *
     * @return 配置文件
     */
    protected File configFile() {
        return new File(CONFIG_FILE_PATH);
    }
}
