package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorDisplay {

	public void generator() throws Exception{

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		//指定 逆向工程配置文件
		File configFile = new File("B:\\spring_workspace\\Test\\generatorConfig2.xml");
/*		configFile.toString();
		configFile.getPath();
		FileOutputStream out = null;
		try {
			if (!configFile.exists()) {
				// 先得到文件的上级目录，并创建上级目录，在创建文件
				configFile.getParentFile().mkdir();
				configFile.createNewFile();
			}
			//创建文件输出流
			out = new FileOutputStream(configFile);
			//将字符串转化为字节
			byte[] byteArr = "FileInputStream Test".getBytes();
			out.write(byteArr);
			out.close();
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);

	} 
	
	public static void main(String[] args) throws Exception {
		try {
			GeneratorDisplay generatorSqlmap = new GeneratorDisplay();
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
