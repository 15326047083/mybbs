package util;

import java.io.File;
/**
 * 上传图片所需工具类
 * @author Administrator
 *
 */
public class CreateFileUtil {
	/**
	 * 创建目录
	 * @param destDirName
	 * @return
	 */
	public static boolean createDir(String destDirName) {  
        File dir = new File(destDirName);  
        if (dir.exists()) {  
            return false;  
        }  
        if (!destDirName.endsWith(File.separator)) {  
            destDirName = destDirName + File.separator;  
        }  
        //创建目录  
        if (dir.mkdirs()) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
}
